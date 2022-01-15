package optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();

        System.out.println("empty : " + empty.isPresent());
        // System.out.println(empty.isEmpty()); // isEmpty() 메서드는  Java 11버전부터 제공
        Optional<String> string = Optional.of("Hello");
        System.out.println("string : " + string.isPresent());

        // Optional<String> emptyString = Optional.of(null); // NullPointerException 발생
        Optional<String> emptyString = Optional.ofNullable(null);  
        String orElse1 = emptyString.orElse("world");
        System.out.println(orElse1);

        String orElse2 =  string.orElse("world");
        System.out.println(orElse2);
    }
}
