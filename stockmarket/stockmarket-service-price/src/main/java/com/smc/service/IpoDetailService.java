
package com.smc.service;

import com.smc.entity.IpoDetail;
import com.smc.utils.CommonResult;

public interface IpoDetailService {
	
	CommonResult findAll();
	CommonResult findIpoDetailById(Integer id);
	CommonResult updateIpoDetailById(IpoDetail ipoDetail);

}
