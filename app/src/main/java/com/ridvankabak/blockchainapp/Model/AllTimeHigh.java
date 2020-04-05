
package com.ridvankabak.blockchainapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllTimeHigh {

    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
