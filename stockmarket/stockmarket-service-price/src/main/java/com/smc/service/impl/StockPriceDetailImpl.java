package com.smc.service.impl;

import com.smc.entity.StockPriceDetail;
import com.smc.service.CompanyService;
import com.smc.service.StockPriceDetailService;
import com.smc.dao.StockPriceDetailDao;
import com.smc.utils.CommonResult;

import java.time.LocalDateTime;
import java.util.List;
import com.smc.utils.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName StockPriceService
 * @Description TODO
 * @Author Yolanda
 * @Date 5/11/2020
 * @Version 1.0
 **/
@Service
public class StockPriceDetailImpl  implements StockPriceDetailService{
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StockPriceDetailDao stockPriceDetailDao;
	/**
	 *
	 * @param code
	 * @param start
	 * @param end
	 * @return
	 */
	public CommonResult comparisonSingleCompany(String companycode, LocalDateTime start, LocalDateTime end){
		try {
			List<StockPriceDetail> result= stockPriceDetailDao.findByCompanycodeAndUpdatetsBetween(companycode,start,end);
			return CommonResult.build(200,"Generate single company over different periods of time",result);
		} catch (Exception e){
			logger.error("Fail to generate single company over different periods of time:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

	/**
	 *
	 * @param codes
	 * @param start
	 * @param end
	 * @return
	 */
	/*
	 * public List<StockPriceDetail> comparisonCompanyAndSector(List<String> codes,
	 * LocalDateTime start, LocalDateTime end){ try { List<StockPriceDetail> result=
	 * stockPriceDetailDao.findAllByCompanyCodeInAndDateTimeBetween(codes,start,end);
	 * return result; } catch (Exception e){
	 * logger.error("Fail to query company data:", e); return null; } }
	 */
}
