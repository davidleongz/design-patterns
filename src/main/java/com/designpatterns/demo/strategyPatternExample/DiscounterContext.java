package com.designpatterns.demo.strategyPatternExample;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DiscounterContext {

    BigDecimal price;

    Map<String, Discounter> strategyContext = new HashMap<String, Discounter>();

    DiscounterContext(BigDecimal price) {
        this.price = price;
        strategyContext.put(ChristmasDiscounter.class.getName(), new ChristmasDiscounter());
        strategyContext.put(EasterDiscounter.class.getName(), new EasterDiscounter());
    }

    public void applyStrategy(Discounter discounter) {

        System.out.println("Price before offer :" + price);
        BigDecimal finalPrice = discounter.applyDiscount(price);
        System.out.println("Price after offer:" + finalPrice);
    }

    public Discounter getStrategy(int monthNo) {

        if (monthNo < 5 && monthNo > 2) {
            return strategyContext.get(EasterDiscounter.class.getName());
        } else {
            return strategyContext.get(ChristmasDiscounter.class.getName());
        }

    }

}
