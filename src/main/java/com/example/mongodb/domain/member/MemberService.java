package com.example.mongodb.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<MemberDoc> selectAllMember(){
        return memberRepository.findAll();
    }

    public Optional<MemberDoc> selectMemberById(Long id){
        return memberRepository.findById(id);
    }
}
