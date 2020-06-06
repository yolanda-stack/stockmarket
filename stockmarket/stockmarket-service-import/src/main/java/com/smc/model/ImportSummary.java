package com.smc.model;

public class ImportSummary {

    /**
     *  import summary
     */
    private String companyname;

    private String stockexchange;

    private int numofimport;

    private String fromdate;

    private String todate;

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

    public int getNumofimported() {
        return numofimport;
    }

    public void setNumofimported(int numofimport) {
        this.numofimport = numofimport;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

}