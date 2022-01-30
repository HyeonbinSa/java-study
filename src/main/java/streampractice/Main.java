package streampractice;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();
        // 기존 방식으로 여성만 필터링
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        females.forEach(System.out::println);
        System.out.println("----------------------------------");
        // Stream Filter 를 이용한 방식
        List<Person> streamMales = people.stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .collect(Collectors.toList());
        streamMales.forEach(System.out::println);
        System.out.println("----------------------------------");
        // Stream sort 를 이용한 정렬
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println("----------------------------------");
        // Stream All Match : List 내에 모든 값이 해당 조건을 만족하는지
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 19);

        System.out.println("All People older than 19? " + allMatch);
        System.out.println("----------------------------------");
        // Stream Any Match : List 내에 값이 해당 조건을 있는지
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 50);
        System.out.println("Any Person older than 50? " + anyMatch);
        System.out.println("----------------------------------");
        // Stream None Match : List 내에 조건에 해당하는 값이 하나도 없는지
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getAge() > 100);
        System.out.println("Nobody older than 100? " + noneMatch);
        System.out.println("----------------------------------");
        // Stream max : 최대값을 가진
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        System.out.println("----------------------------------");
        // Stream Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach(((gender, people1) -> {
            System.out.println("[" + gender + "]");
            people1.forEach(System.out::println);
        }));



    }

    private static List<Person> getPeople() {
        return Arrays.asList(
                new Person("James", 20, Gender.MALE),
                new Person("Smith", 17, Gender.MALE),
                new Person("Hellen", 26, Gender.FEMALE),
                new Person("Alex", 52, Gender.MALE),
                new Person("Genny", 16, Gender.FEMALE)
        );
    }
}
