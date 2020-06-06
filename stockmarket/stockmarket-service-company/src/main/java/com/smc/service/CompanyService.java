package com.smc.service;

import com.smc.entity.Company;
import com.smc.utils.CommonResult;

public interface CompanyService {
	CommonResult findAll();
	CommonResult findById(Integer id);
    String getByCompanycode(String companycode);
    CommonResult save(Company company);
    CommonResult updateCompanyById(Company company);
//    String deleteByCompanycode(String companycode);
}
