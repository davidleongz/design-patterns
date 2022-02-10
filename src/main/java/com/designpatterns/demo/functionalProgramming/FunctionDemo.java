package com.designpatterns.demo.functionalProgramming;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
public class FunctionDemo {

    public static void main(String[] args) {

        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());

        log.info("Value: {}", value);

        Integer valueWithMethodReference = nameMap.computeIfAbsent("John", String::length);
        log.info("Value with method reference: {}", valueWithMethodReference);


        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        log.info("Value applied: {}", quoteIntToString.apply(5));


        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);

        log.info("Map1: {}", salaries);

        salaries.replaceAll((name, oldValue) ->
                name.equals("Susy") ? oldValue : oldValue + 10000);

        log.info("Map2: {}", salaries);
    }
}
