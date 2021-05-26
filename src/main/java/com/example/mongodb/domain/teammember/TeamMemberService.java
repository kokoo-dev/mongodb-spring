package com.example.mongodb.domain.teammember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberService {
    @Autowired
    TeamMemberRepository teamMemberRepository;

    public List<TeamMemberDoc> selectAllTeamMember(){
        return teamMemberRepository.findAll();
    }
}
