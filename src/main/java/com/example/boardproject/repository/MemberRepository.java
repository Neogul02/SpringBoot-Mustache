package com.example.boardproject.repository;

import com.example.boardproject.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

/*
    @Override
    List<Member> findAll();
*/
}
