package com.example.boardproject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@ToString @Slf4j
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    private String title;
    private String content;

    public void logInfo(){
        log.info("id: {}, title: {}, content: {}", id, title, content);
    }

}
