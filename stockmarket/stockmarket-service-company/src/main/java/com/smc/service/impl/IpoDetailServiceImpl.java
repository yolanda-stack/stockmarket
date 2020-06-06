package com.smc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.entity.IpoDetail;
import com.smc.dao.IpoDetailDao;
import com.smc.service.IpoDetailService;
import com.smc.utils.ResponseCode;
import com.smc.utils.CommonResult;

@Service
public class IpoDetailServiceImpl implements IpoDetailService{

	@Autowired
	private IpoDetailDao IpoDetailDao;
	
	@Override
	public CommonResult findAll() {
		
		try {
			List<IpoDetail> list = this.IpoDetailDao.findAll();
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", list);
        } catch (Exception e) {
            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
	}

	@Override
	public CommonResult updateIpoDetailById(IpoDetail IpoDetail) {
		
		try {
			IpoDetail oldIpoDetail = this.IpoDetailDao.findById(IpoDetail.getId());
			oldIpoDetail.setCompanyname(IpoDetail.getCompanyname());
			oldIpoDetail.setStockexchange(IpoDetail.getStockexchange());
			oldIpoDetail.setPricepershare(IpoDetail.getPricepershare());
			oldIpoDetail.setTotalshares(IpoDetail.getTotalshares());
			oldIpoDetail.setRemarks(IpoDetail.getRemarks());
			oldIpoDetail.setOpendate(IpoDetail.getOpendate());		
            this.IpoDetailDao.save(oldIpoDetail);
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!");
        } catch (Exception e) {
            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        } 
	}

	@Override
	public CommonResult findIpoDetailById(Integer id) {
		try {
			IpoDetail IpoDetail = this.IpoDetailDao.findById(id);
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", IpoDetail);
        } catch (Exception e) {
            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
    }

}
