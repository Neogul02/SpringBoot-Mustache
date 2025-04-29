package com.example.boardproject.controller;

import com.example.boardproject.dto.MemberForm;
import com.example.boardproject.entity.Member;
import com.example.boardproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    //form
    @GetMapping("/signup")
    public String signup(){
        return "members/new";
    }

    //회원 등록
    @PostMapping("/join")
    public String join(MemberForm memberForm){
        memberForm.logInfo();

        //dto -> entity
        Member member = memberForm.toMember();
        member.logInfo();

        //save member through repository
        Member saved = memberRepository.save(member);
        saved.logInfo();

        return "redirect:/members";      //members 페이지로 redirect
    }
    
    //1번 member 정보 조회
    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){

        Member member = memberRepository.findById(id).orElse(null);  //member가 없을때 null 객체 생성

        model.addAttribute("member", member);

        return "members/show";
    }

    //member list 조회
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = (List<Member>) memberRepository.findAll();

        model.addAttribute("members", members);

        return "members/index";
    }
}