package edu2;

import java.util.Optional;

/*
Optional 클래스: 어떤 타입을 감싸고 있는 Wrapper 클래스
public final class Optional<T> {
     private final T value
     ...
}

null인 객체를 handling할때는 NullPointException이 발생
NullPointException을 막기위해서는 코드상에 if문을 사용하여
null인지에 대한 여부를 확인해야함 => 코드가 지저분해지기 때문에
null을 감쌀수있는 Optional 클래스를 사용하여
그 안에 있는 여러 메소드를 통해, null일 경우에 처리할수 있는 코드를 간결하게 한다.

1. NullPointException 방지
2. null 체크 코드 간결화
3. 함수형 스타일의 프로그래밍 가능(map, filter, isPresent 등)
 */

/*
1. Optional 생성 방법
 */

public class OptionalEx {

    public static void main(String[] args) {

        //1. 값이 존재하는 Optional 생성
        //만약 value가 null이면 NullPointerException 발생
        Optional<String> optionalWithValue = Optional.of("Hello");
        System.out.println(optionalWithValue);

        //2. 값이 null일수도 있는 Optional 객체 생성. 값이 null이면 비어있는 Optional을 반환
        //null을 허용하는 Optional 생성 (값이 null일  수 있음)
        Optional<String> optioanlNullable = Optional.ofNullable(null);
        System.out.println(optioanlNullable);

        //3. 비어있는 Optional 생성
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);
    }
}
