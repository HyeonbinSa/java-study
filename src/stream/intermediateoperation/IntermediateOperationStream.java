package stream.intermediateoperation;

import sun.jvm.hotspot.utilities.IntArray;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationStream {
    public static void main(String[] args) {
        skip();
        limit();
        skipAndLimit();
        distinct();
        filter();
        sorted();
    }

    private static void skip() {
        System.out.print("중간 연산 skip() : ");
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.skip(5).forEach(System.out::print);
        System.out.println();
    }

    private static void limit() {
        System.out.print("중간 연산 limit() : ");
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.limit(7).forEach(System.out::print);
        System.out.println();
    }

    private static void skipAndLimit() {
        System.out.print("중간 연산 skip().limit() : ");
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.skip(3).limit(5).forEach(System.out::print);
        System.out.println();
    }

    private static void distinct() {
        System.out.print("중간 연산 distinct() : ");
        IntStream intStream = IntStream.of(1, 1, 1, 2, 2, 2, 3, 4, 3, 2, 5, 6);
        intStream.distinct().forEach(System.out::print);
        System.out.println();
    }

    private static void filter() {
        System.out.print("중간 연산 filter() : ");
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.filter(n -> n % 2 == 0).forEach(System.out::print);
        System.out.println();
    }

    private static void sorted() {
        // 기본 정렬 : 인자값 없음.
        System.out.print("중간 연산 sorted() : ");
        Stream<String> strStream = Stream.of("Z", "apple", "Google", "wed", "Downer", "cherry", "BANANA");
        strStream.sorted().forEach(str -> System.out.print(str + " "));
        System.out.println();

        // 정렬 기준 존재
        System.out.print("중간 연산 sorted(comparator) : ");
        strStream = Stream.of("Z", "apple", "Google", "wed", "Downer", "cherry", "BANANA");
        strStream.sorted(Comparator.comparing(String::length)).forEach(str -> System.out.print(str + " "));
        System.out.println();
    }
}
