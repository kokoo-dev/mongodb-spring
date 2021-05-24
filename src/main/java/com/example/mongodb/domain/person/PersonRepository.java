package com.example.mongodb.domain.person;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<PersonDoc, String> {
    List<PersonDoc> findByAge(int age);
    void deleteByName(String name);
}
