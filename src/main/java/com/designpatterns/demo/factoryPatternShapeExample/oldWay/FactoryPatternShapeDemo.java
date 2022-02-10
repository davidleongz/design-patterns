package com.designpatterns.demo.factoryPatternShapeExample.oldWay;

import com.designpatterns.demo.factoryPatternShapeExample.Shape;

public class FactoryPatternShapeDemo {


    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.calculateArea();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.calculateArea();
    }
}
