
package com.ridvankabak.blockchainapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("order")
    @Expose
    private String order;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("totalMarkets")
    @Expose
    private Integer totalMarkets;
    @SerializedName("totalExchanges")
    @Expose
    private Integer totalExchanges;
    @SerializedName("totalMarketCap")
    @Expose
    private Double totalMarketCap;
    @SerializedName("total24hVolume")
    @Expose
    private Double total24hVolume;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Integer getTotalMarkets() {
        return totalMarkets;
    }

    public void setTotalMarkets(Integer totalMarkets) {
        this.totalMarkets = totalMarkets;
    }

    public Integer getTotalExchanges() {
        return totalExchanges;
    }

    public void setTotalExchanges(Integer totalExchanges) {
        this.totalExchanges = totalExchanges;
    }

    public Double getTotalMarketCap() {
        return totalMarketCap;
    }

    public void setTotalMarketCap(Double totalMarketCap) {
        this.totalMarketCap = totalMarketCap;
    }

    public Double getTotal24hVolume() {
        return total24hVolume;
    }

    public void setTotal24hVolume(Double total24hVolume) {
        this.total24hVolume = total24hVolume;
    }

}
