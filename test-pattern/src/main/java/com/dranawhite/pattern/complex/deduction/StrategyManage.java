package com.dranawhite.pattern.complex.deduction;

/**
 * 策略枚举类
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public enum StrategyManage {

    SteadyDeduction("org.apache.java.designpatter.factoryandstrategy.SteadyDeduction"),

    FreeDeducation("org.apache.java.designpatter.factoryandstrategy.FreeDeduction");

    String value = "";

    StrategyManage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
