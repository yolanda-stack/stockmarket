package com.smc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smc.entity.Company;
import com.smc.dao.CompanyDao;
import com.smc.service.CompanyService;
import com.smc.utils.ResponseCode;
import com.smc.utils.CommonResult;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public CommonResult findAll() {
        try {
            List<Company> list = this.companyDao.findAll();
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", list);
        } catch (Exception e) {
            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
    }

    @Override
    public CommonResult findById(Integer id) {
        try {
            Company company = this.companyDao.findById(id);
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", company);
        } catch (Exception e) {
            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }  
    }

    @Override
    public String getByCompanycode(String companycode) {
        return this.companyDao.getByCompanycode(companycode);
    }

    @Override
    public CommonResult save(Company company) {
        try {
            Company _company = this.companyDao.save(company);
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", _company);
        } catch (Exception e) {
            return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }
        
    }

	@Override
	public CommonResult updateCompanyById(Company company) {
		try {
			
            Company oldCompany = this.companyDao.findById(company.getId());
            oldCompany.setCompanyname(company.getCompanyname());
            oldCompany.setCompanycode(company.getCompanycode());
            oldCompany.setTurnover(company.getTurnover());
            oldCompany.setCeo(company.getCeo()); 
            oldCompany.setBoarddirector(company.getBoarddirector());
            oldCompany.setListedinse(company.getListedinse());
            oldCompany.setStockexchanges(company.getStockexchanges());
            oldCompany.setBrief(company.getBrief());
            oldCompany.setStockcode(company.getStockcode());   
            oldCompany.setCompanystatus(company.getCompanystatus());
            this.companyDao.save(oldCompany);
            return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!");
        } catch (Exception e) {
        	return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
        }
	}

}