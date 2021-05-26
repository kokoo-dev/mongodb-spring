package com.example.mongodb.domain.team;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<TeamDoc, Long> {
}
