package com.example.mongodb.domain.teammember;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamMemberRepository extends MongoRepository<TeamMemberDoc, Long> {
}