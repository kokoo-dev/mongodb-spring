package com.example.mongodb.domain.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    public List<TeamDoc> selectAllTeam(){
        return teamRepository.findAll();
    }
}
