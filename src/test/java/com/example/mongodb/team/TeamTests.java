package com.example.mongodb.team;

import com.example.mongodb.domain.member.MemberDoc;
import com.example.mongodb.domain.member.MemberService;
import com.example.mongodb.domain.team.TeamDoc;
import com.example.mongodb.domain.team.TeamService;
import com.example.mongodb.domain.teammember.TeamMemberDoc;
import com.example.mongodb.domain.teammember.TeamMemberService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TeamTests {
    Logger logger = LoggerFactory.getLogger(TeamTests.class);

    @Autowired
    TeamService teamService;

    @Autowired
    MemberService memberService;

    @Autowired
    TeamMemberService teamMemberService;

    @Test
    public void testSelectAllTeamReference(){
        List<TeamDoc> teamList = teamService.selectAllTeam();

        for(TeamDoc teamDoc : teamList){
            logger.info(teamDoc.getTeamName() + " " + teamDoc.getEvent());
            for(Long memberId : teamDoc.getMembers()){
                Optional<MemberDoc> member = memberService.selectMemberById(memberId);
                logger.info(member.get().getMemberName());
            }
        }
    }

    @Test
    public void testSelectAllTeamEmbed(){
        List<TeamMemberDoc> teamList = teamMemberService.selectAllTeamMember();

        for(TeamMemberDoc teamMember : teamList){
            logger.info(teamMember.getTeamName() + " " + teamMember.getEvent());

            for(MemberDoc member : teamMember.getMembers()){
                logger.info(member.getMemberName());
            }
        }
    }
}
