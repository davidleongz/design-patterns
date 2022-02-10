package com.designpatterns.demo.factoryPatternShapeExample;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
public class Circle implements Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle() {
        this(2);
    }

    @Override
    public BigDecimal calculateArea() {

        BigDecimal area = BigDecimal.ZERO;
        area = BigDecimal.valueOf(2 * Math.PI * radius);

        log.info("Circle area is: {}", area);

        return area;
    }
}
