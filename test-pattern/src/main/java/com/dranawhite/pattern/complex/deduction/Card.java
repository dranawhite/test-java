package com.dranawhite.pattern.complex.deduction;

/**
 * IC卡
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public class Card {

    private String No;
    /**
     * 卡内固定交易金额
     */
    private int steadyMoney;
    /**
     * 卡内自由交易金额
     */
    private int freeMoney;

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public int getSteadyMoney() {
        return steadyMoney;
    }

    public void setSteadyMoney(int steadyMoney) {
        this.steadyMoney = steadyMoney;
    }

    public int getFreeMoney() {
        return freeMoney;
    }

    public void setFreeMoney(int freeMoney) {
        this.freeMoney = freeMoney;
    }
}
