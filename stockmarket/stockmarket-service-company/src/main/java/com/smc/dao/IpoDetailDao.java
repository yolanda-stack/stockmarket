package com.smc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smc.entity.IpoDetail;

public interface IpoDetailDao extends JpaRepository<IpoDetail,Long>{
	
	IpoDetail findById(Integer id);
	
}
