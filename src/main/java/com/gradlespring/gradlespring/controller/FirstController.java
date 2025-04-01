package com.gradlespring.gradlespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Math.random;


@Controller
public class FirstController {
    @RequestMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("username", "최진형");
        return "greetings";
    }

    @RequestMapping("/bye")
    public String bye(Model model) {
        model.addAttribute("nickname", "감자");
        return "goodbye";
    }

    @GetMapping("/main")
    @ResponseBody
    public String main() {
        return "<h1>메인페이지 입니다.</h1>";
    }

    @GetMapping("/date")
    @ResponseBody
    public String date() {
        LocalDate now = LocalDate.now();
        Integer Year = now.getYear();
        Integer Month = now.getMonthValue();
        Integer Day = now.getDayOfMonth();

        return "<h1>오늘은 " + Year.toString() + "년 " + Month.toString() + "월 " + Day.toString() + "일 입니다.</h1>";

    }

    int cnt = 123;

    @GetMapping("/count")
    @ResponseBody
    public String count() {
        cnt++;
        String cntStr = Integer.toString(cnt);
        String html = "";

        for (int i = 0; i < cntStr.length(); i++) {
            html += String.format("<img src='/number/%c.png' width='100'/>", cntStr.charAt(i));
        }

        return html;
    }

    @GetMapping("/banner")
    @ResponseBody
    public String banner() {
        String html = "";
        String[] banners = {"naver", "daum", "google"};
        String[] links = {"https://naver.com", "https://daum.net", "https://google.com"};

        for (int i = 0; i < banners.length; i++) {
            html += String.format("<div><a href='%s'><img src='/banner/%s.png' width='300' alt='%s'/></a></div>", links[i], banners[i], banners[i]);
        }

        return html;
    }

    @GetMapping("/sum/{num}")
    @ResponseBody
    public String sum(@PathVariable int num) {
        int sum_result = 0;
        for (int i = 0; i <= num; i++) {
            sum_result += i;
        }
        return "<h1>" + "1부터" + num + "까지의 합은 : " + sum_result + "</h1>";

    }

    @GetMapping("/users/{name}/orders/{number}")
    @ResponseBody
    public String users(@PathVariable String name, @PathVariable int number) {
        return "<h1>UserName : " + name + ", Order No." + number + "</h1>";
    }

    @GetMapping("/posts/{category}/{id}")
    @ResponseBody
    public String posts(@PathVariable String category, @PathVariable int id) {
        return "<h1>Category : " + category + ", Post ID : " + id + "</h1>";
    }


}