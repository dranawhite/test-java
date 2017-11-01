package com.dranawhite.pattern.complex.deduction;

/**
 * 策略工厂
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public class StrategyFactory {

    public static IDeduction getDeduction(StrategyManage strategy) {
        IDeduction deduction = null;
        try {
            deduction = (IDeduction) Class.forName(strategy.getValue()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deduction;
    }
}
