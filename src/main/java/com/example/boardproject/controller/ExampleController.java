package com.example.boardproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    //변수
    @GetMapping("/varex")
    public String varex(Model model) {
        model.addAttribute("name", "아이유");

        return "varex";
    }

    //객체
    @GetMapping("/objectex")
    public String objectex(Model model) {

        Person person = new Person("아이유", 25, "서울특별시");

        model.addAttribute("person", person);

        return "objectex";
    }

    //객체2
    @GetMapping("/objectex2")
    public String objectex2(Model model) {

        Person person = new Person("아이유", 25, "서울");
        Person person2 = new Person("아세영", 22, "광주");

        model.addAttribute("person", person);
        model.addAttribute("person2", person2);

        return "objectex2";
    }

    //조건문
    @GetMapping("/conditionex")
    public String conditionex(Model model) {

        boolean loggedIn = false;
        String testStr = "test";
        model.addAttribute("username", "아이유");
        model.addAttribute("loggedIn", testStr);

        return "conditionex";
    }


    //반복문
    @GetMapping("loopex")
    public String loopex(Model model) {

        String[] fruits = {"apple", "banana", "orange"};

        Person[] persons = {
                new Person("아이유", 25, "서울"),
                new Person("유재석", 50, "부산"),
                new Person("안세영", 20, "광주")
        };

        model.addAttribute("fruits", fruits);
        model.addAttribute("persons", persons);

        return "loopex";
    }


    //템플릿화 (Partials)
    @GetMapping("partialex")
    public String partialex(Model model) {

        //3개의 버튼 생성.
        //버튼이 있을경우에만 화면에 표시

        String[] buttons = {"Cancel", "Save", "insert"};
        model.addAttribute("buttons", buttons);
        return "partialex";
    }

    //이스케이프 처리
    @GetMapping("/show-input")
    public String showInput(Model model) {

        String userInput = "<b>안녕하세요! 이 텍스트는 굵게 표시합니다.</b>";
        model.addAttribute("userInput", userInput);

        return "no-escape";
    }

}
