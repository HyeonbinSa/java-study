package stream.terminaloperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperationStream {
    private static Student[] students = {new Student("Alice", 11),
            new Student("Brian", 17),
            new Student("Chris", 16),
            new Student("Dalot", 18),
            new Student("Elis", 14)};


    public static void main(String[] args) {
        forEachOrdered();
        matchOperation();
        findOperation();
        reduce();
        collectToCollection();
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
        System.out.println();
    }

    private static void findOperation() {
        System.out.println("[findOperation]");
        IntStream intStream = IntStream.rangeClosed(1, 9);
        OptionalInt optionalInt = intStream.filter(number -> number >= 3).findFirst();
        System.out.println("findFirst() : " + optionalInt.getAsInt());
        IntStream intStream2 = IntStream.rangeClosed(1, 9);
        OptionalInt optionalInt2 = intStream2.parallel().filter(number -> number >= 3).findAny();
        System.out.println("findAny() : " + optionalInt2.getAsInt());
        System.out.println();
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
        System.out.println();
    }

    private static void collectToCollection() {
        Stream<Student> studentStream = Stream.of(students);
        List<String> names = studentStream.map(Student::getName).collect(Collectors.toList());
        System.out.println("학생 이름 목록 : " + names);

        Stream<Student> studentStream2 = Stream.of(students);
        ArrayList<Integer> ageList = studentStream2.map(Student::getAge).collect(Collectors.toCollection(ArrayList::new));
        System.out.println("학생 나이 목록 : " + ageList);

        Stream<Student> studentStream3 = Stream.of(students);
        Map<String, Integer> studentMap = studentStream3.collect(Collectors.toMap(s -> s.getName(), s -> s.getAge()));
        System.out.print("학생 정보 Map : ");
        studentMap.forEach((key, value) -> System.out.print("[" + key + ",  " + value + "] "));
        System.out.println();

        Stream<Student> studentStream4 = Stream.of(students);
        String studentNames = studentStream4.map(Student::getName).collect(Collectors.joining(", ", "[", "]"));
        System.out.println(studentNames);
    }

    private static void collectToArray() {
        Stream<Student> studentStream = Stream.of(students);
        Student[] studentArray = studentStream.toArray(Student[]::new);
        Stream<Student> studentStream2 = Stream.of(students);
        Object[] studentArray2 = studentStream2.toArray();  // Object[]로 반환하기 때문에 Student[] 사용 불가
    }
}
