package com.example.boardproject.dto;


import com.example.boardproject.entity.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Slf4j
public class MemberForm {

    private String email;
    private String password;

    //DTO -> Entity
    public Member toMember(){
        return new Member(email, password);
    }

    public void logInfo(){
        log.info("MemberForm email: {}, password: {}", email, password);
    }
}
