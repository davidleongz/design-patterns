package com.designpatterns.demo.functionalProgramming;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {


    }

    public static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }
}
