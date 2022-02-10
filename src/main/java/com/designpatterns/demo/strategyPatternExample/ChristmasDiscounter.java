package com.designpatterns.demo.strategyPatternExample;

import java.math.BigDecimal;

public class ChristmasDiscounter implements Discounter {

    public String getName(){
        return this.getClass().getName();
    }

    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.9));
    }

}
