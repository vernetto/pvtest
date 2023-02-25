package com.example.pvtest;

import java.util.*;
import java.util.function.*;

/**
 * https://www.baeldung.com/java-8-functional-interfaces
 */

public class OptionalMapper {

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

        // Operator
        List<String> names2 = Arrays.asList("bob", "josh", "megan");
        UnaryOperator<String> stringUnaryOperator = name -> name.toUpperCase();
        names2.replaceAll(stringUnaryOperator);
        // Operator again
        List<String> names3 = Arrays.asList("bob", "josh", "megan");
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        names3.replaceAll(toUpperCase);


        // BinaryOperator
        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        BinaryOperator<Integer> integerBinaryOperator = (i1, i2) -> i1 + i2;
        int sum = values.stream().reduce(0, integerBinaryOperator);


        // Supplier
        Supplier pluto = () -> "pluto";
        System.out.println("supplier " + pluto.get());


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


