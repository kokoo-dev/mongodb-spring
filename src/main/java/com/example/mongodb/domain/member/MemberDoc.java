package com.example.mongodb.domain.member;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("member")
@Data
public class MemberDoc {
    @Id
    private Long _id;
    private String memberName;
}
