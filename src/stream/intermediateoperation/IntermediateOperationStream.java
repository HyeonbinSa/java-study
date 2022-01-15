package stream.intermediateoperation;

import sun.jvm.hotspot.utilities.IntArray;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationStream {
    public static void main(String[] args) {
        // 중간 연산 1
        skip();
        limit();
        skipAndLimit();
        distinct();
        filter();
        sorted();
        // 중간 연산 2
        map();
        peek();
        flatMap();
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

    private static void map() {
        System.out.print("중간 연산 map() : ");
        File[] fileArray = {new File("Ex1.java"), new File("Ex1")
                , new File("Ex1.bak"), new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(fileArray);

        Stream<String> fileNameStream = fileStream.map(File::getName);
        fileNameStream.forEach(fileName -> System.out.print("[" + fileName + "] "));
        System.out.println();
        // Stream<File> 재생성
        System.out.print("중간 연산 map() - 확장자만 출력 : ");
        fileStream = Stream.of(fileArray);
        fileStream.map(File::getName)
                .filter(fileName -> fileName.indexOf(".") != -1)
                .map(fileName -> fileName.substring(fileName.indexOf(".") + 1))
                .map(String::toUpperCase)
                .distinct()
                .forEach(fileName -> System.out.print("[" + fileName + "] "));
        System.out.println();
    }

    private static void peek() {
        System.out.print("중간 연산 peek() : ");
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.skip(3)
                .peek(num -> System.out.print(num + " "))
                .limit(5)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void flatMap() {
        System.out.println("중간 연산 flatMap()");

        // String[]의 Stream을 map()으로 변환했을 때
        Stream<String[]> stringStream =
                Stream.of(new String[]{"aaa", "bbb", "ccc"}
                        , new String[]{"AAA", "BBB", "CCC"});
        // Stream<Stream<String>> : Stream의 Stream으로 변환이 됨.
        System.out.print("중간 연산 map() : ");
        Stream<Stream<String>> stringStreamStream = stringStream.map(Arrays::stream);
        stringStreamStream.forEach(str -> System.out.print(str + " "));
        System.out.println();

        // Stream<String> : Stream으로 변환이 됨.
        Stream<String[]> stringStream2 =
                Stream.of(new String[]{"aaa", "bbb", "ccc"}
                        , new String[]{"AAA", "BBB", "CCC"});
        System.out.print("중간 연산 flatMap() : ");
        Stream<String> stringStreamByFlatMap = stringStream2.flatMap(Arrays::stream);
        stringStreamByFlatMap.forEach(str -> System.out.print(str + " "));
        System.out.println();
    }
}
