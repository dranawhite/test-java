package com.dranawhite.pattern.complex.deduction;

/**
 * 扣款门面
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public class DeductionFacade {

    public static Card deduct(Card card, Trade trade) {
        StrategyManage reg = getDeducationType(trade);    //获得消费策略
        IDeduction deduction = StrategyFactory.getDeduction(reg);   //初始化一个消费策略 对象
        DeductionContext context = new DeductionContext(deduction);    //执行封装
        context.exec(card, trade);    //执行扣款
        return card;

    }

    private static StrategyManage getDeducationType(Trade trade) {
        if (trade.getTradeNo().contains("abc")) {
            return StrategyManage.FreeDeducation;
        } else {
            return StrategyManage.SteadyDeduction;
        }
    }
}
