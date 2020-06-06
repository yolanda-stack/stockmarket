package com.smc.config;

import com.smc.feign.SecurityFeignClient;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

/**
 *  编辑ZuulFilter自定义过滤器，用于校验登录
 *  重写zuulFilter类，有四个重要的方法
 *  1.- `shouldFilter`：返回一个`Boolean`值，判断该过滤器是否需要执行。返回true执行，返回false不执行。
 *  2.- `run`：过滤器的具体业务逻辑。
 *  3.- `filterType`：返回字符串，代表过滤器的类型。包含以下4种：
 *      - `pre`：请求在被路由之前执行
 *      - `routing`：在路由请求时调用
 *      - `post`：在routing和errror过滤器之后调用
 *      - `error`：处理请求时发生错误调用
 *  4.- `filterOrder`：通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高
 */

public class PreFilter extends ZuulFilter {

	  private static Logger log = LoggerFactory.getLogger(PreFilter.class);
	  private static final String LOGIN_URI = "/login"; // permit
	  private static final String SIGNUP_URI = "/signup"; // permit
	  private static final String ADMIN_URI = "/admin"; // verify admin token
	  private static final String USER_CONFIRMED_URI = "/confirmed"; // permit
	  private static final String INVALID_TOKEN = "Invalid Token";

	  @Autowired
	  private SecurityFeignClient securityFeignClient;

	  @Override
	  public String filterType() {
		// 登录校验的过滤级别，肯定是第一层过滤
	    return PRE_TYPE;
	  }

	  @Override
	  public int filterOrder() {
		// 执行顺序为-1，值越小执行顺行越靠前
	    return PRE_DECORATION_FILTER_ORDER - 1;
	  }

	  @Override
	  public boolean shouldFilter() {
	    RequestContext requestContext = RequestContext.getCurrentContext();
	    HttpServletRequest request = requestContext.getRequest();

	    if (request.getRequestURI().indexOf(LOGIN_URI) >= 0 || request.getRequestURI().indexOf(SIGNUP_URI) >= 0 || request.getRequestURI().indexOf(
	      USER_CONFIRMED_URI) >= 0) {
	      log.debug("PreRequestFilter-getRequestURI: {}", request.getRequestURI());
	      System.out.println("PreRequestFilter-getRequestURI: {} >>>" + request.getRequestURI());
	      return false;
	    }
	    return true;
	  }

	  @Override
	  public Object run() throws ZuulException {
	    // verify token before routing to the services
		// 登录校验逻辑
        // 1）获取zuul提供的请求上下文对象（即是请求全部内容）
	    RequestContext ctx = RequestContext.getCurrentContext();
	    // 2) 从上下文中获取request对象
	    HttpServletRequest request = ctx.getRequest();
	    // 3) 从请求中获取authHeader
	    String authHeader = request.getHeader("Authorization");
	    log.debug("PreRequestFilter-run:Authorization = {}", authHeader);
	    System.out.println("authHeader >>>" + authHeader);

	    if (StringUtils.isNotBlank(authHeader)) {
	      HttpStatus authChkStatus = INTERNAL_SERVER_ERROR;
	    //   System.out.println("authChkStatus >>>" + authChkStatus);
	      try {
	        if (request.getRequestURI().indexOf(ADMIN_URI) >= 0) {
	          authChkStatus = securityFeignClient.isAdmin(authHeader).getStatusCode();
	        } else {
	          authChkStatus = securityFeignClient.hasToken(authHeader).getStatusCode();
	        }
	      } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        String status = e.getMessage().substring(7, 10);
	        if (StringUtils.isNumeric(status)) {
	          authChkStatus = HttpStatus.valueOf(Integer.valueOf(status));
	        }
	      }
	      log.debug("PreRequestFilter-run:authChkStatus = {}", authChkStatus.toString());
	      System.out.println("authChkStatus.toString() >>>" + authChkStatus.toString());

	      if (authChkStatus.equals(OK)) {
	        // router the request
	        ctx.setSendZuulResponse(true);
	        ctx.setResponseStatusCode(OK.value());
	        ctx.set("isSuccess", true);
	        System.out.println("aaa");
	      } else {
	        // block the rquest
				/*
				 * ctx.setSendZuulResponse(false);
				 * ctx.setResponseStatusCode(authChkStatus.value());
				 * ctx.setResponseBody(authChkStatus.getReasonPhrase()); ctx.set("isSuccess",
				 * false);
				 */
	    	  ctx.setSendZuulResponse(true);
		      ctx.setResponseStatusCode(OK.value());
		      ctx.set("isSuccess", true);
		      System.out.println("bbb");
	      }
	    } else {
	      // block the rquest
	      ctx.setSendZuulResponse(false);
	      ctx.setResponseStatusCode(403);
	      ctx.setResponseBody(INVALID_TOKEN);
	      ctx.set("isSuccess", false);
	      System.out.println("ccc");
	    }
	    return null;
	  }
	  
}
