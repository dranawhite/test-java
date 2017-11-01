package com.dranawhite.pattern.complex.deduction;

/**
 * 交易类
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public class Trade {

    private String tradeNo;
    /**
     * 交易金额
     */
    private int mount;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }
}
