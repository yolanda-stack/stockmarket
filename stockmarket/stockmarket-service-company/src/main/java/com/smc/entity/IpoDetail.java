package com.smc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ipo_detail")
public class IpoDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "company_name")
    private String companyname;
    
    @Column(name = "stock_exchange")
    private String stockexchange;

    @Column(name = "price_per_share")
    private String pricepershare;

    @Column(name = "total_shares")
    private Integer totalshares;

    @Column(name = "open_date")
    private Date opendate;

    @Column(name = "remarks")
    private String remarks;


    public IpoDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getStockexchange() {
        return stockexchange;
    }

    public void setStockexchange(String stockexchange) {
        this.stockexchange = stockexchange;
    }

    public String getPricepershare() {
        return pricepershare;
    }

    public void setPricepershare(String pricepershare) {
        this.pricepershare = pricepershare;
    }

    public Integer getTotalshares() {
        return totalshares;
    }

    public void setTotalshares(Integer totalshares) {
        this.totalshares = totalshares;
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
