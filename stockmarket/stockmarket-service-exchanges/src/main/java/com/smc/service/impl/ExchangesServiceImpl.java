package com.smc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.entity.Exchanges;
import com.smc.dao.ExchangesDao;
import com.smc.service.ExchangesService;
import com.smc.utils.ResponseCode;
import com.smc.utils.CommonResult;

@Service
public class ExchangesServiceImpl implements ExchangesService{

	@Autowired
	private ExchangesDao exchangesDao;
	
	@Override
	public CommonResult findAll() {
		
		try {
			List<Exchanges> list = this.exchangesDao.findAll();
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", list);
        } catch (Exception e) {
            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
	}

	@Override
	public CommonResult updateExchangesById(Exchanges Exchanges) {
		
		try {
			Exchanges oldExchanges = this.exchangesDao.findById(Exchanges.getId());
			oldExchanges.setStockexchange(Exchanges.getStockexchange());
			oldExchanges.setBrief(Exchanges.getBrief());
			oldExchanges.setAddress(Exchanges.getAddress());
			oldExchanges.setRemarks(Exchanges.getRemarks());		
            this.exchangesDao.save(oldExchanges);
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!");
        } catch (Exception e) {
            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        } 
	}

	@Override
	public CommonResult findExchangesById(Integer id) {
		try {
			Exchanges Exchanges = this.exchangesDao.findById(id);
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", Exchanges);
        } catch (Exception e) {
            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
    }
	
	  @Override
	    public CommonResult save(Exchanges exchanges) {
	        try {
	        	Exchanges _exchanges = this.exchangesDao.save(exchanges);
	            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", _exchanges);
	        } catch (Exception e) {
	            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
	        }
	        
	    }

}

