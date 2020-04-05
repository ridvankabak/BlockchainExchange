
package com.ridvankabak.blockchainapp.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coin {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("uuid")
    @Expose
    private String uuid;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("iconType")
    @Expose
    private String iconType;
    @SerializedName("iconUrl")
    @Expose
    private String iconUrl;
    @SerializedName("websiteUrl")
    @Expose
    private String websiteUrl;
    @SerializedName("socials")
    @Expose
    private List<Social> socials = null;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    @SerializedName("confirmedSupply")
    @Expose
    private Boolean confirmedSupply;
    @SerializedName("numberOfMarkets")
    @Expose
    private Integer numberOfMarkets;
    @SerializedName("numberOfExchanges")
    @Expose
    private Integer numberOfExchanges;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("volume")
    @Expose
    private Long volume;
    @SerializedName("marketCap")
    @Expose
    private Long marketCap;
    @SerializedName("price")
    @Expose
    private String price;
    /*
    @SerializedName("circulatingSupply")
    @Expose
    private Integer circulatingSupply;
    @SerializedName("totalSupply")
    @Expose
    private Integer totalSupply;
     */
    @SerializedName("approvedSupply")
    @Expose
    private Boolean approvedSupply;
    @SerializedName("firstSeen")
    @Expose
    private Long firstSeen;
    @SerializedName("change")
    @Expose
    private Double change;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("history")
    @Expose
    private List<String> history = null;
    @SerializedName("allTimeHigh")
    @Expose
    private AllTimeHigh allTimeHigh;
    @SerializedName("penalty")
    @Expose
    private Boolean penalty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<Social> getSocials() {
        return socials;
    }

    public void setSocials(List<Social> socials) {
        this.socials = socials;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Boolean getConfirmedSupply() {
        return confirmedSupply;
    }

    public void setConfirmedSupply(Boolean confirmedSupply) {
        this.confirmedSupply = confirmedSupply;
    }

    public Integer getNumberOfMarkets() {
        return numberOfMarkets;
    }

    public void setNumberOfMarkets(Integer numberOfMarkets) {
        this.numberOfMarkets = numberOfMarkets;
    }

    public Integer getNumberOfExchanges() {
        return numberOfExchanges;
    }

    public void setNumberOfExchanges(Integer numberOfExchanges) {
        this.numberOfExchanges = numberOfExchanges;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
/*
    public Integer getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(Integer circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public Integer getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Integer totalSupply) {
        this.totalSupply = totalSupply;
    }
 */
    public Boolean getApprovedSupply() {
        return approvedSupply;
    }

    public void setApprovedSupply(Boolean approvedSupply) {
        this.approvedSupply = approvedSupply;
    }

    public Long getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(Long firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public AllTimeHigh getAllTimeHigh() {
        return allTimeHigh;
    }

    public void setAllTimeHigh(AllTimeHigh allTimeHigh) {
        this.allTimeHigh = allTimeHigh;
    }

    public Boolean getPenalty() {
        return penalty;
    }

    public void setPenalty(Boolean penalty) {
        this.penalty = penalty;
    }

}
