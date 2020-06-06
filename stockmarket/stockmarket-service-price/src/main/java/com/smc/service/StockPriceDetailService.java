package com.smc.service;

import com.smc.entity.StockPriceDetail;
import com.smc.utils.CommonResult;

import java.time.LocalDateTime;
import java.util.List;


public interface StockPriceDetailService {
	CommonResult comparisonSingleCompany(String companycode, LocalDateTime start, LocalDateTime end);
//	List<StockPriceDetail> comparisonCompanyAndSector(List<String> codes, LocalDateTime start, LocalDateTime end);
}
