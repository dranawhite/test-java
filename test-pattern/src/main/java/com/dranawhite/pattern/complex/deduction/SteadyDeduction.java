package com.dranawhite.pattern.complex.deduction;

/**
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public class SteadyDeduction implements IDeduction {

    @Override
    public boolean exec(Card card, Trade trade) {
        int halfMoney = (int) Math.rint(trade.getMount() / 2.0);
        card.setSteadyMoney(card.getSteadyMoney() - halfMoney);
        card.setFreeMoney(card.getFreeMoney() - halfMoney);
        return true;
    }
}
