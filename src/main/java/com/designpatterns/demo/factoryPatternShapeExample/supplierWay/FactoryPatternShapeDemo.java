package com.designpatterns.demo.factoryPatternShapeExample.supplierWay;

import java.util.function.Supplier;

public class FactoryPatternShapeDemo {

    public static void main(String[] args) {

        Supplier<ShapeFactory> shapeFactory =  ShapeFactory::new;

        shapeFactory.get().getShape("circle").calculateArea();

        shapeFactory.get().getShape("rectangle").calculateArea();

    }
}
