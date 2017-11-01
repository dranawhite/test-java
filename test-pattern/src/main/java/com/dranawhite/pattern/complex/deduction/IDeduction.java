package com.dranawhite.pattern.complex.deduction;

/**
 * 扣款接口
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public interface IDeduction {

    boolean exec(Card card, Trade trade);
}
