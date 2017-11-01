package com.dranawhite.pattern.complex.deduction;

/**
 * 扣款策略封装
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public class DeductionContext {

    private IDeduction deduction;

    public DeductionContext(IDeduction deduction) {
        this.deduction = deduction;
    }

    public boolean exec(Card card, Trade trade) {
        return this.deduction.exec(card, trade);
    }
}
