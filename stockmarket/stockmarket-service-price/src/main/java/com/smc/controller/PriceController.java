package com.smc.controller;

import com.smc.entity.Company;
import com.smc.entity.StockPriceDetail;
import com.smc.service.CompanyService;
import com.smc.service.IpoDetailService;
import com.smc.service.StockPriceDetailService;
import com.smc.utils.CommonResult;
import com.smc.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smc.dao.CompanyDao;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

@CrossOrigin
@RestController
@RequestMapping("/generate")
public class PriceController {

	@Autowired
	private StockPriceDetailService stockPriceDetailService;
	@Autowired
	private CompanyService companyService;
	/*
	 * @Autowired private ExchangeService exchangeService;
	 * 
	 * @Autowired private IpoService ipoService;
	 */
	@Autowired
	private CompanyDao companyDao;

	@PostMapping("/comparison/{companyCode}")
	public CommonResult comparisonSingleCom(@PathVariable String companycode, @RequestBody Map params)
			throws Exception {
		LocalDateTime start = LocalDateTime.parse((CharSequence) params.get("start"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		LocalDateTime end = LocalDateTime.parse((CharSequence) params.get("end"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return stockPriceDetailService.comparisonSingleCompany(companycode, start, end);
	}

	/**
	 * 根据company code查找行业平均值
	 * 
	 * @param companyCode
	 * @param params
	 * @return
	 * @throws Exception
	 *//*
		 * @PostMapping("/comparison/sectorAndCompany/{companyCode}") public
		 * CommonResult sectorAndCompany(@PathVariable("companyCode") String
		 * companyCode,
		 * 
		 * @RequestBody Map params) throws Exception { LocalDateTime start =
		 * LocalDateTime.parse((CharSequence) params.get("start"),
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); LocalDateTime end =
		 * LocalDateTime.parse((CharSequence) params.get("end"),
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); Company company =
		 * companyDao.findByCompanyCode(companyCode); List<Company> companyEntityList =
		 * companyService.findComBySector(company.getSectorName()); List<String>
		 * stockCodeList =
		 * companyEntityList.stream().map(Company::getCompanyCode).collect(Collectors.
		 * toList()); List<StockPriceDetail> stockPriceEntities = new ArrayList<>();
		 * stockPriceEntities = (List<StockPriceDetail>)
		 * stockPriceDetailService.comparisonCompanyAndSector(stockCodeList, start,
		 * end); Map<LocalDateTime, List<StockPriceDetail>> group =
		 * stockPriceEntities.stream().collect(Collectors.groupingBy(StockPriceDetail::
		 * getDateTime)); List<SectorDTO> sectorDTOS = new ArrayList<>(); for
		 * (Map.Entry<LocalDateTime, List<StockPriceDetail>> entry : group.entrySet()) {
		 * SectorDTO sectorDTO = new SectorDTO(); BigDecimal sectorPrice =
		 * entry.getValue().stream().map(StockPriceDetail::getCurrentPrice)
		 * .reduce(BigDecimal.ZERO, BigDecimal::add) .divide(new
		 * BigDecimal(entry.getValue().size()), 2, ROUND_HALF_DOWN);
		 * sectorDTO.setLabel(entry.getKey()); sectorDTO.setValue(sectorPrice);
		 * sectorDTOS.add(sectorDTO); } sectorDTOS.sort((o1, o2) ->
		 * o1.getLabel().compareTo(o2.getLabel())); return
		 * CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!", sectorDTOS); }
		 */

}
