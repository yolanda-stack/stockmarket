package com.smc.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	private static Logger logger = LoggerFactory.getLogger(AccessDeniedHandler.class);
	
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

    logger.debug("AuthenticationEntryPoint: FOUND 401 Unauthorized");
    
		/*
		 * This is invoked when user tries to access a secured REST resource without
		 * supplying any credentials We should just send a 401 Unauthorized response
		 * because there is no 'login page' to redirect to
		 */
    response.sendError(UNAUTHORIZED.value(), UNAUTHORIZED.getReasonPhrase());
    
    }

}