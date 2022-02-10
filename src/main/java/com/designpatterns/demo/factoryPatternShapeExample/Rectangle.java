package com.designpatterns.demo.factoryPatternShapeExample;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
public class Rectangle implements Shape {

    private int height;

    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle() {
        this(2,2);
    }

    @Override
    public BigDecimal calculateArea() {

        BigDecimal area = BigDecimal.ZERO;
        area = BigDecimal.valueOf(height * width);

        log.info("Rectangle area is: {}", area);

        return area;
    }
}
