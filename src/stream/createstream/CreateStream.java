package stream.createstream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        createStreamByCollection();
        createStreamByObjectArray();
        createRandomStream();
        createRangeStream();
        createStreamByLambda();
        createNullStream();
    }

    private static void createStreamByCollection() {
        System.out.println("[Main.createStreamByCollection]");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> integerStream = list.stream();
        integerStream.forEach(System.out::print);
        System.out.println();
        // Stream의 특징 : stream은 일회성으로 최종연산이 끝난 경우 재생성을해줘야한다.
        integerStream = list.stream();
        integerStream.forEach(System.out::print);
        System.out.println();
    }

    private static void createStreamByObjectArray() {
        System.out.println("[Main.createStreamByObjectArray]");
        // Case 1. 객체 배열
        Stream<String> stringStream = Stream.of("a", "b", "c");
        stringStream.forEach(System.out::print);
        System.out.println();
        // Case 2. 기본형 배열
        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        intStream.forEach(System.out::print);
        // Case 2-1. Integer 배열의 경우 객체 배열로 Stream<Integer>와 같이 생성된다.
        Integer[] intArr = {1, 2, 3, 4, 5};
        Stream<Integer> intStream2 = Arrays.stream(intArr);
    }

    private static void createRandomStream() {
        System.out.println("[Main.createRandomStream]");
        // 난수를 요소로 갖는 스트림 생성 - 무한스트림(초기값 미지정)
        IntStream intRandomStream = new Random().ints(); // 무한 스트림
        intRandomStream.limit(6).forEach(System.out::print);
        System.out.println();
        // 난수를 요소로 갖는 스트림 생성 - 유한스트림(초기값 지정)
        DoubleStream doubleRandomStream = new Random().doubles(5, 0.0, 10.0); // 유한 스트림
        doubleRandomStream.forEach(System.out::print);
        System.out.println();
        // 숫자 범위 지정
        IntStream intRandomStream2 = new Random().ints(1, 10); // 무한 스트림
        intRandomStream2.limit(6).forEach(System.out::print);
        System.out.println();
    }

    private static void createRangeStream() {
        System.out.println("[Main.createRangeStream]");
        // 특정 범위의 정수를 가지는 Stream 생성 - 마지막 미포함
        IntStream intStream1 = IntStream.range(1, 5);
        System.out.print("IntStream.range() : ");
        intStream1.forEach(System.out::print);
        System.out.println();
        // 특정 범위의 정수를 가지는 Stream 생성 - 마지막 포함
        IntStream intStream2 = IntStream.rangeClosed(1, 5);
        System.out.print("IntStream.rangeClosed() : ");
        intStream2.forEach(System.out::print);
        System.out.println();
    }

    private static void createStreamByLambda() {
        System.out.println("[Main.createStreamByLambda]");
        // iterate와 generate 모두 무한 스트림으로 limit()으로 길이의 제한을 줘야함.
        // Case 1. iterate(T seed, UnaryOperator<T> f);
        // seed는 초기값을 의미하며 f는 람다식을 의미
        Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);
        System.out.print("Stream.iterate() : ");
        evenStream.limit(10).forEach(System.out::print);
        System.out.println();
        // Case 2. generate(Supplier<T> s);
        // iterate와 달리 초기값이 없다. (또한, 입력이 없고 출력만 존재)
        System.out.print("Stream.generate() : ");
        Stream<Integer> oneStream = Stream.generate(() -> 1);
        oneStream.limit(7).forEach(System.out::print);
        System.out.println();
    }

    private static void createNullStream() {
        System.out.println("[Main.createNullStream]");
        Stream emptyStream = Stream.empty();
        System.out.println("emptyStream의 크기 : " + emptyStream.count());
    }
}
