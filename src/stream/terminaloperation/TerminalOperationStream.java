package stream.terminaloperation;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperationStream {
    public static void main(String[] args) {
        forEachOrdered();
        matchOperation();
        findOperation();
        reduce();
    }

    private static void forEachOrdered() {
        System.out.println("[forEach]");
        // forEach()
        System.out.print("병렬 Stream forEach : ");
        IntStream.rangeClosed(1, 9).parallel().forEach(number -> System.out.print(number + " "));
        System.out.println();
        // forEachOrdered()
        System.out.print("병렬 Stream forEachOrdered : ");
        IntStream.rangeClosed(1, 9).parallel().forEachOrdered(number -> System.out.print(number + " "));
        System.out.println();
    }

    private static void matchOperation() {
        System.out.println("[matchOperation]");
        System.out.println("조건 : Stream의 값 중 8보다 큰 정수가 있는지");
        IntStream intStream = IntStream.rangeClosed(1, 9);
        boolean result = intStream.anyMatch(number -> number > 8);
        System.out.println("anyMatch : " + result);

        intStream = IntStream.rangeClosed(1, 9);
        result = intStream.allMatch(number -> number > 8);
        System.out.println("allMatch : " + result);

        intStream = IntStream.rangeClosed(1, 9);
        result = intStream.noneMatch(number -> number > 8);
        System.out.println("noneMatch : " + result);
    }

    private static void findOperation() {
        System.out.println("[findOperation]");
        IntStream intStream = IntStream.rangeClosed(1, 9);
        OptionalInt optionalInt = intStream.filter(number -> number >= 3).findFirst();
        System.out.println("findFirst() : " + optionalInt.getAsInt());
        IntStream intStream2 = IntStream.rangeClosed(1, 9);
        OptionalInt optionalInt2 = intStream2.parallel().filter(number -> number >= 3).findAny();
        System.out.println("findAny() : " + optionalInt2.getAsInt());
    }

    private static void reduce() {
        System.out.println("[reduce]");
        String[] stringArray = {"Java", "Python", "C++", "C", "Kotlin", "Javascript"};
        // reduce(초기값, 연산) 형식
        // Case 1. 초기값 있을 경우
        Stream<String> stringStream1 = Stream.of(stringArray);
        IntStream stringLengthStream1 = stringStream1.mapToInt(String::length);
        int sum = stringLengthStream1.reduce(0, (a, b) -> a + b);
        System.out.println("문자열 길이의 합 : " + sum);
        // Case 2. 초기값 없을 경우
        Stream<String> stringStream2 = Stream.of(stringArray);
        IntStream stringLengthStream2 = stringStream2.mapToInt(String::length);
        OptionalInt max = stringLengthStream2.reduce(Integer::max);
        System.out.println("최대 길이 : " + max.getAsInt());
    }
}
