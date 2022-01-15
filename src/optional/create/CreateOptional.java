package optional.create;

import java.util.Optional;

public class CreateOptional {
    public static void main(String[] args) {
        // int[] arr = null; // NullPointerException 발생
        int[] arr = new int[0];
        System.out.println("arr.length : " + arr.length);

        createNullOptionalObject();
    }

    private static void createNullOptionalObject() {
        System.out.println("[CreateOptional.createNullOptionalObject]");
        Optional<String> opt1 = null; // 에러 발생 X, 바람직하지 않은 방법
        Optional<String> opt2 = Optional.empty();
        System.out.println("opt1 : " + opt1);
        System.out.println("opt2 : " + opt2);
        System.out.println();
    }

    private static void createOptionalByOf(){
        System.out.println("[CreateOptional.createOptionalByOf]");
        Optional<String> opt = Optional.of("abc");

    }
}
