package com.smc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

import com.smc.entity.StockPriceDetail;

public interface StockPriceDetailDao extends JpaRepository<StockPriceDetail,Long>{
	    List<StockPriceDetail> findByCompanycodeAndUpdatetsBetween(String companycode, LocalDateTime start, LocalDateTime end);

	/*
	 * StockPriceDetail findFirstByCompanyCodeOrderByDateTimeDesc(String code);
	 */
	/*
	 * List<StockPriceDetail>
	 * findAllByCompanyCodeInAndDateTimeBetween(List<String>code, LocalDateTime
	 * start, LocalDateTime end);
	 */
	
}
