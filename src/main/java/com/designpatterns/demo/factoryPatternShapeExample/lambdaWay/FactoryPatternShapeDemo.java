package com.designpatterns.demo.factoryPatternShapeExample.lambdaWay;

import java.util.function.Supplier;

public class FactoryPatternShapeDemo {

    public static void main(String[] args) {

        Supplier<ShapeFactory> shapeFactory =  ShapeFactory::new;

        shapeFactory.get().getShape("circle").draw();

        shapeFactory.get().getShape("rectangle").draw();

    }
}
