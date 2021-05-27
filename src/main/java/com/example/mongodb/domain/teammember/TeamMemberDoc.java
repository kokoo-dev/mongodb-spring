package com.example.mongodb.domain.teammember;

import com.example.mongodb.domain.member.MemberDoc;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("team_member")
@Data
public class TeamMemberDoc {
    @Id
    private Long _id;
    private String teamName;
    private String event;
    private ArrayList<MemberDoc> members;
}
