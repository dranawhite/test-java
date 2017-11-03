package com.dranawhite.pattern.complex.deduction;

/**
 * 扣款门面
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public class DeductionFacade {

    public static Card deduct(Card card, Trade trade) {
        //获得消费策略
        StrategyManage reg = getDeducationType(trade);
        //初始化一个消费策略 对象
        IDeduction deduction = StrategyFactory.getDeduction(reg);
        //执行封装
        DeductionContext context = new DeductionContext(deduction);
        //执行扣款
        context.exec(card, trade);
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
