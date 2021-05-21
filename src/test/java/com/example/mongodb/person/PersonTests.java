package com.example.mongodb.person;

import com.example.mongodb.domain.person.PersonDoc;
import com.example.mongodb.domain.person.PersonService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PersonTests {
    Logger logger = LoggerFactory.getLogger(PersonTests.class);

    @Autowired
    PersonService personService;

    @Test
    public void testSelectPerson(){
        String _id = "60a74970f114367ba856b175";
        PersonDoc personDoc = personService.getPerson(_id);
        assertEquals("HongKilDong", personDoc.getName());
    }

    @Test
    public void testSelectPersonList(){
        int age = 25;
        int expected = 2;

        List<PersonDoc> personDocList = personService.getPersonList(age);

        for(PersonDoc personDoc : personDocList){
            logger.info(personDoc.get_id() + " " + personDoc.getName() + " " + personDoc.getAge());
        }

        assertEquals(expected, personDocList.size());
    }

    @Test
    public void testInsertPerson(){
        PersonDoc personDoc = new PersonDoc();
        personDoc.setAge(21);
        personDoc.setName("KangKilDong");

        PersonDoc result = personService.insertPerson(personDoc);
        logger.info("result :: " + result.get_id() + " " + result.getName() + " " + result.getAge());
    }

    @Test
    public void testSelectPersonByRepo(){
        String _id = "60a74970f114367ba856b175";
        PersonDoc personDoc = personService.getPersonByRepo(_id);
        assertEquals("HongKilDong", personDoc.getName());
    }

    @Test
    public void testSelectPersonListByRepo(){
        int age = 25;
        int expected = 2;

        List<PersonDoc> personDocList = personService.getPersonListByRepo(age);

        for(PersonDoc personDoc : personDocList){
            logger.info(personDoc.get_id() + " " + personDoc.getName() + " " + personDoc.getAge());
        }

        assertEquals(expected, personDocList.size());
    }

    @Test
    public void testInsertPersonByRepo(){
        PersonDoc personDoc = new PersonDoc();
        personDoc.setAge(22);
        personDoc.setName("LimKilDong");

        PersonDoc result = personService.insertPerson(personDoc);
        logger.info("result :: " + result.get_id() + " " + result.getName() + " " + result.getAge());
    }
}
