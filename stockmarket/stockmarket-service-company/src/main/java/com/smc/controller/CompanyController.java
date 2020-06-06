package com.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smc.entity.Company;
import com.smc.service.CompanyService;
import com.smc.utils.CommonResult;

@RestController
@RequestMapping("/admin/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public CommonResult queryCompanyAll() {
        return companyService.findAll();
    }

    @GetMapping("/list/{id}")
    public CommonResult queryCompanyById(@PathVariable Integer id){
        return companyService.findById(id);
    }

    @PostMapping
    public CommonResult addCompany(@RequestBody Company company){
        return companyService.save(company);
    }
    
   @PutMapping
    public CommonResult editCompanyById(@RequestBody Company company){
        return companyService.updateCompanyById(company);
    }
//    
//    @DeleteMapping("/delete")
//    public CommonResult deleteCompanyById(@PathVariable Integer id){
//        return companyService.delete(company);
//    }

}
