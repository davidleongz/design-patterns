package com.designpatterns.demo.factoryPatternShapeExample.oldWay;

import com.designpatterns.demo.factoryPatternShapeExample.Circle;
import com.designpatterns.demo.factoryPatternShapeExample.Rectangle;
import com.designpatterns.demo.factoryPatternShapeExample.Shape;

public class ShapeFactory {

    public Shape getShape(String shapeType){

        if("CIRCLE".equalsIgnoreCase(shapeType)){
            return new Circle();

        } else if("RECTANGLE".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }

        return null;
    }
}
