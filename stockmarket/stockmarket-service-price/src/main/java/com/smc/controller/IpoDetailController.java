package com.smc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smc.entity.IpoDetail;
import com.smc.service.IpoDetailService;
import com.smc.utils.CommonResult;

@CrossOrigin
@RestController
@RequestMapping("/IpoDetail")
public class IpoDetailController {
	
	@Autowired
	private IpoDetailService IpoDetailService;
	
	@GetMapping("/list")
    public CommonResult queryIpoDetailAll() {
        return IpoDetailService.findAll();
    }
	
	@GetMapping("/list/{id}")
    public CommonResult queryIpoDetailById(@PathVariable Integer id){
        return IpoDetailService.findIpoDetailById(id);
    }
	
	@PostMapping
    public CommonResult updateIpoDetail(@RequestBody IpoDetail IpoDetail){
        return IpoDetailService.updateIpoDetailById(IpoDetail);
    }

}
