package edu2;

/*
isPresent()	값이 있으면 true
ifPresent(Consumer<? super T>)	값이 있을 때만 실행
get()	값 반환 (값이 없으면 예외 발생, 지양)
orElse(T other)	값이 없으면 기본값 반환
orElseGet(Supplier)	값이 없으면 함수 실행 후 반환
orElseThrow()	값이 없으면 예외 발생
map(Function)	값이 있으면 함수 적용 후 Optional 반환
filter(Predicate)	조건을 만족하면 그대로, 아니면 empty 반환
 */

import java.util.Optional;

public class OptionalEx2 {

    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(getName());     //값이 Null일수도 있는 name값을 가져온다.
        System.out.println(name);

        //값이 있으면 출력
        name.ifPresent(n -> System.out.println("이름: " + n));

        //1. 값이 없으면 "기본 이름" 출력
        String result = name.orElse("기본 이름");
        System.out.println(result);

        //2. orElseGet() 사용 - 동적 기본값 제공
        String result2 = name.orElseGet( () -> "default name" );
        System.out.println(result2);

        //3. 값이 없을때 예외 던지기
        try{
            name.orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));
        } catch (IllegalArgumentException e) {
            System.out.println("예외발생: " + e.getMessage());
        }
    }

    public static String getName(){
        //return "홍길동";
        //return "HongGilDong";
        return null;
    }
}