package com.example.pvtest;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class OptionalMapmer {

    private static Function<String, List<String>> customTargetsProvider;
    public static void main(String[] args) {
        // Predicate and Function
        Predicate<String> p = String::isEmpty;
        Function<String, Boolean> f = String::isEmpty;
        System.out.println("p " + p.test("pippo"));
        System.out.println("f " + f.apply("pippo"));

        // computeIfAbsent
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        System.out.println("value " + value);


        // compose
        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);
        String apply = quoteIntToString.apply(5);
        System.out.println("quoteIntToString " + apply);

        // Consumer
        List<String> names = Arrays.asList("John", "Freddy", "Samuel");
        Consumer<String> stringConsumer = name -> System.out.println("Hello, " + name);
        names.forEach(stringConsumer);

        // BiConsumer
        Map<String, Integer> ages = new HashMap<>();
        ages.put("John", 25);
        ages.put("Freddy", 24);
        ages.put("Samuel", 30);
        BiConsumer<String, Integer> stringIntegerBiConsumer = (name, age) -> System.out.println(name + " is " + age + " years old");
        ages.forEach(stringIntegerBiConsumer);


        // ofNullable
        Optional<Function<String, List<String>>> result = Optional.ofNullable(customTargetsProvider);
        System.out.println("result  " + result);
        // Optional.map
        Optional<List<String>> pippo = result.map(stringListFunction -> stringListFunction.apply("pippo"));
        System.out.println("pippo " +  pippo);
    }

    public static class  MyFunction implements Function {

        @Override
        public Object apply(Object o) {
            return null;
        }

        @Override
        public Function compose(Function before) {
            return Function.super.compose(before);
        }

        @Override
        public Function andThen(Function after) {
            return Function.super.andThen(after);
        }
    }
}


