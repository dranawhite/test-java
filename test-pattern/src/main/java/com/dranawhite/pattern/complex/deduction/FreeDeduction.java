package com.dranawhite.pattern.complex.deduction;

/**
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public class FreeDeduction implements IDeduction {

    @Override
    public boolean exec(Card card, Trade trade) {
        card.setFreeMoney(card.getFreeMoney() - trade.getMount());
        return true;
    }
}
