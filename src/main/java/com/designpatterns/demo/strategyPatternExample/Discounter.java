package com.designpatterns.demo.strategyPatternExample;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public interface Discounter {

    public String getName();

    public BigDecimal applyDiscount(BigDecimal amount);
}