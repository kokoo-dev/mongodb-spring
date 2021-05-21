package com.example.mongodb.domain.person;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("persons")
@Data
public class PersonDoc {
    @Id
    private String _id;
    private String name;
    private int age;
}
