package com.smc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smc.entity.Exchanges;

public interface ExchangesDao extends JpaRepository<Exchanges,Long>{
	
	Exchanges findById(Integer id);
	
}

