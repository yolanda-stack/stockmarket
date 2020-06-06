package com.smc.service;

import com.smc.entity.Exchanges;
import com.smc.utils.CommonResult;

public interface ExchangesService {
	
	CommonResult findAll();
	CommonResult findExchangesById(Integer id);
	CommonResult updateExchangesById(Exchanges exchanges);
	CommonResult save(Exchanges exchanges);

}
