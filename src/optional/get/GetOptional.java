package optional.get;

import java.util.Optional;
import java.util.OptionalInt;

public class GetOptional {
    public static void main(String[] args) {
        get();
        orElse();
        orElseGet();
        isPresent();
        ifPresent();
    }

    private static void get() {
        System.out.println("[Optional get() 메서드]");
        Optional<String> opt = Optional.empty();
//        System.out.println("opt : " + opt.get()); //  NoSuchElementException: No value present Exception 발생
        String str = "";
        try {
            str = opt.get();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 발생");
            str = "";
        }
        System.out.println("str : " + str);
        System.out.println();
    }

    private static void orElse() {
        System.out.println("[Optional orElse() 메서드]");
        Optional<String> opt = Optional.empty();
        System.out.println("opt : " + opt.orElse("null Optional 객체"));
        System.out.println();
    }

    private static void orElseGet() {
        System.out.println("[Optional orElseGet() 메서드]");
        Optional<String> opt = Optional.empty();
        System.out.println("opt : " + opt.orElseGet(() -> "Lambda"));
        System.out.println();
    }

    private static void isPresent() {
        System.out.println("[Optional isPresent() 메서드]");
        OptionalInt optZero = OptionalInt.of(0);
        OptionalInt optEmpty = OptionalInt.empty();
        System.out.println("optZero.isPresent() : " + optZero.isPresent());
        System.out.println("optEmpty.isPresent() : " + optEmpty.isPresent());
        System.out.println();
    }

    private static void ifPresent() {
        System.out.println("[Optional ifPresent() 메서드]");
        OptionalInt optInt = OptionalInt.of(142);
        OptionalInt optEmpty = OptionalInt.empty();
        System.out.print("optInt.isPresent() : ");
        optInt.ifPresent(System.out::println);
        System.out.print("optEmpty.isPresent() : ");
        optEmpty.ifPresent(number -> System.out.println(number));
    }
}
