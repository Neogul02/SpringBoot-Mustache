package edu2;

import java.util.Optional;

public class OptionalEx3 {

    public static void main(String[] args) {
        Person personWithEmail = new Person("Charlie", 28, "charlie@example.com");
        Person personWithoutEmail = new Person("Dana", 35, null);

        // 1. map() 사용해서 도메인 추출
        String domain = Optional.ofNullable(personWithEmail.getEmail())
                .map(email -> email.substring(email.indexOf("@") + 1))
                .orElse("이메일 없음");
        System.out.println(personWithEmail.getName() + "'s email domain: " + domain);

        // 2. orElse() 사용 - 기본값 제공
        String email1 = Optional.ofNullable(personWithoutEmail.getEmail())
                .orElse("no-email@default.com");
        System.out.println(personWithoutEmail.getName() + "'s email: " + email1);

        // 3. orElseGet() 사용 - 동적 기본값 제공
        String email2 = Optional.ofNullable(personWithoutEmail.getEmail())
                .orElseGet(() -> generateDefaultEmail(personWithoutEmail));
        System.out.println(personWithoutEmail.getName() + "'s generated email: " + email2);

        // 4. orElseThrow() 사용 - 예외 던지기
        try {
            String email3 = Optional.ofNullable(personWithoutEmail.getEmail())
                    .orElseThrow(() -> new IllegalArgumentException("이메일이 없습니다."));
            System.out.println("This line won't be printed.");
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    public static String generateDefaultEmail(Person person) {
        return person.getName().toLowerCase() + "@default.com";
    }
}
