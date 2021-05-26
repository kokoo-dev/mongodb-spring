package com.example.mongodb.domain.team;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("team")
@Data
public class TeamDoc {
    @Id
    private Long _id;
    private String teamName;
    private String event;
    private ArrayList<Long> members;
}
