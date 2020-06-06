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

import com.smc.entity.Exchanges;
import com.smc.service.ExchangesService;
import com.smc.utils.CommonResult;

@CrossOrigin
@RestController
@RequestMapping("/Exchanges")
public class ExchangesController {
	
	@Autowired
	private ExchangesService exchangesService;
	
	@GetMapping("/list")
    public CommonResult queryExchangesAll() {
        return exchangesService.findAll();
    }
	
	@GetMapping("/list/{id}")
    public CommonResult queryExchangesById(@PathVariable Integer id){
        return exchangesService.findExchangesById(id);
    }
	
	@PutMapping
    public CommonResult updateExchanges(@RequestBody Exchanges exchanges){
        return exchangesService.updateExchangesById(exchanges);
    }
		
    @PostMapping
    public CommonResult addExchanges(@RequestBody Exchanges exchanges){ 
    	return exchangesService.save(exchanges); }

}

