package com.example.boardproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThirdController {

    @GetMapping("/users/{username}")
    @ResponseBody
    public String getUserInfo(@PathVariable String username){
        return "hello, " + username + "!";
    }

    @GetMapping("/sum/{num}")
    @ResponseBody
    public String sum(@PathVariable int num) {
        int result = 0;

        for(int i=0; i < num; i++) {
            result += i+1;
        }

        String html = String.format("<h1>1에서 %d까지의 합은 %d입니다.</h1>", num, result );

        return html;
    }

    @GetMapping("/users/{username}/orders/{orderNo}")
    @ResponseBody
    public String getOrder(@PathVariable String username, @PathVariable int orderNo) {
        return "User Name: " + username + ", Order No:" + orderNo;
    }

    @GetMapping("/posts/{category}/{postId}")
    @ResponseBody
    public String getPostDetails(@PathVariable String category, @PathVariable int postId){
        return "Category: " + category + ", Post Id: " + postId;
    }
}