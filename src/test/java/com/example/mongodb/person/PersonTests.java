package com.example.mongodb.person;

import com.example.mongodb.domain.person.PersonDoc;
import com.example.mongodb.domain.person.PersonService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
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
        String _id = "60a74978f114367ba856b176";
        PersonDoc personDoc = personService.getPerson(_id);
        assertEquals("HongGilDong", personDoc.getName());
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
        personDoc.setName("KangGilDong");

        PersonDoc result = personService.insertPerson(personDoc);
        logger.info("result :: " + result.get_id() + " " + result.getName() + " " + result.getAge());
    }

    @Test
    public void testUpdatePerson(){
        String _id = "60a74978f114367ba856b176";
        PersonDoc personDoc = personService.getPerson(_id);
        personDoc.setAge(personDoc.getAge() + 1);

        UpdateResult updateResult = personService.updatePerson(personDoc);

        logger.info("result:: " + updateResult.getModifiedCount());
    }

    @Test
    public void testDeletePerson(){
        String name = "KangGilDong";
        PersonDoc personDoc = new PersonDoc();
        personDoc.setName(name);

        DeleteResult deleteResult = personService.deletePerson(personDoc);

        logger.info("result:: " + deleteResult.getDeletedCount());
    }

    @Test
    public void testSelectPersonByRepo(){
        String _id = "60a74978f114367ba856b176";
        PersonDoc personDoc = personService.getPersonByRepo(_id);
        assertEquals("HongGilDong", personDoc.getName());
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
        personDoc.setName("LimGilDong");

        PersonDoc result = personService.insertPersonByRepo(personDoc);
        logger.info("result :: " + result.get_id() + " " + result.getName() + " " + result.getAge());
    }

    @Test
    public void testUpdatePersonByRepo(){
        String _id = "60a74978f114367ba856b176";
        PersonDoc personDoc = personService.getPerson(_id);
        personDoc.setAge(personDoc.getAge() + 1);

        PersonDoc result = personService.updatePersonByRepo(personDoc);

        logger.info("result :: " + result.getAge());
    }

    @Test
    public void testDeletePersonByRepo(){
        String name = "KangGilDong";
        PersonDoc personDoc = new PersonDoc();
        personDoc.setName(name);

        personService.deletePersonByRepo(personDoc);
    }
}
