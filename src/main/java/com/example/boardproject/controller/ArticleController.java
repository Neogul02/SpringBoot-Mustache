package com.example.boardproject.controller;


import com.example.boardproject.entity.Article;
import com.example.boardproject.dto.ArticleForm;
import com.example.boardproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {
    
    //Repository 객체 생성
    @Autowired
    ArticleRepository articleRepository;

    //입력 Form URL
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    //Form 객체 내용을 받아 DTO에 넣기
    @PostMapping("/articles/create")            // /articles/create
    public String createArticle(ArticleForm articleForm) {

        //로그를 통해 articleForm 내용 확인
        articleForm.logInfo();

        //DTO를 Entity로 변환
        Article article = articleForm.toEntity();
        article.logInfo();

        //repository를 통해 DB로 entity를 저장
        Article saved = articleRepository.save(article);
        saved.logInfo();

        return "redirect:/articles";
    }
    
    //단일 데이터 조회
    @GetMapping("/articles/{id}")
    public String show(@PathVariable("id") Long id, Model model){

        log.info("id: {}", id);

        //db로부터 id가 id인 글을 가져와서 뷰에서 보여주기
        //Optional<Article> article = articleRepository.findById(id);
        Article article = articleRepository.findById(id).orElse(null);      //article이 없을때 기본값으로 null객체 생성

        model.addAttribute("article", article);
        return "articles/show";
    }
    
    
    //article 리스트 출력
    @GetMapping("/articles")
    public String list(Model model) {

        //모든 데이터 가져오기
        List<Article> articleList = articleRepository.findAll();

        //Model에 데이터 등록
        model.addAttribute("articleList", articleList);

        //뷰 페이지 설정
        return "articles/index";
    }

}