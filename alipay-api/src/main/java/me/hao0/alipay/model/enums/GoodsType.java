package me.hao0.alipay.model.enums;

/**
 * 商品类型
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 3/1/16
 * @since 1.0.4
 */
public enum GoodsType {

    /**
     * 虚拟物品
     */
    VIRTUAL("0"),

    /**
     * 实物
     */
    REAL("1");

    private String value;

    private GoodsType(String value){
        this.value = value;
    }

    public String value(){
        return value;
    }
}
