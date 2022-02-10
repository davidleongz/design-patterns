package com.designpatterns.demo.strategyPatternExample;

import java.math.BigDecimal;

public class StrategyPatternDemo {

    public static void main(String[] args) {

        DiscounterContext context = new DiscounterContext(BigDecimal.valueOf(100D));
        System.out.println("Enter month number between 1 and 12");
        int month = Integer.parseInt(args[0]);
        System.out.println("Month ="+month);
        Discounter strategy = context.getStrategy(month);
        context.applyStrategy(strategy);
    }
}
