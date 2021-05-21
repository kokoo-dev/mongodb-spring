package com.example.mongodb.domain.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PersonRepository personRepository;

    public PersonDoc getPerson(String _id){
        PersonDoc personDoc = mongoTemplate.findById(_id,PersonDoc.class);
        return Optional.ofNullable(personDoc).orElseThrow(() -> new RestClientException(HttpStatus.NOT_FOUND.toString()));
    }

    public List<PersonDoc> getPersonList(int age){
        Query query = new Query().addCriteria(Criteria.where("age").is(age));
        return mongoTemplate.find(query, PersonDoc.class);
    }

    public PersonDoc insertPerson(PersonDoc personDoc){
        return mongoTemplate.insert(personDoc);
    }


    public PersonDoc getPersonByRepo(String _id){
        return personRepository.findById(_id).orElseThrow(() -> new RestClientException(HttpStatus.NOT_FOUND.toString()));
    }

    public List<PersonDoc> getPersonListByRepo(int age){
        return personRepository.findByAge(age);
    }

    public PersonDoc insertPersonByRepo(PersonDoc personDoc){
        return personRepository.insert(personDoc);
    }
}
