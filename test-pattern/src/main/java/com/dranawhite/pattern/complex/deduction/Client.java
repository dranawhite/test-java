package com.dranawhite.pattern.complex.deduction;

/**
 * 场景类
 *
 * @author dranawhite 2017/11/1
 * @version 1.0
 */
public class Client {

    private static Card initCard() {
        Card card = new Card();
        card.setNo("");
        card.setFreeMoney(0);
        card.setSteadyMoney(0);
        return card;
    }

    private static Trade initTrade() {
        Trade trade = new Trade();
        trade.setMount(0);
        trade.setTradeNo("");
        return trade;
    }

    public static void main(String[] args) {

        Card card = initCard();
        boolean flag = true;
        while (flag) {
            Trade trade = initTrade();
            DeductionFacade.deduct(card, trade);
        }
    }
}
