package com.tianxi.viewpageviewpage;

import java.io.Serializable;

/**
 * Created by 甘罗 on 16-8-8.
 */
public class ShopGoods implements Serializable {
    /**
     *  supplierId
     * goodsId
     * goodsName
     * goodsBrand
     * price
     * picture
     * thumbnail
     * goodsNum
     *
     */
    private String goodsBrand;
    private String picture;
    private String thumbnail;
    private String unit;
    //商品Id
    private int goodsId;
    //商品价格
    private long price;
    //商品数量
    private int goodNum;
    //商品名称
    private String goodName;

    public ShopGoods() {
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
