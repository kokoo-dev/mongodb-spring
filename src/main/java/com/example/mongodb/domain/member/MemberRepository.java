package com.example.mongodb.domain.member;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<MemberDoc, Long> {
}
