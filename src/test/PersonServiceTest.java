package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Person;
import repositories.PersonRepository;
import services.PersonService;

public class PersonServiceTest {

    private PersonService service;
    private PersonRepository repository;

    @BeforeEach
    public void instantiateService(){
        service = new PersonService();
        repository = PersonRepository.factory();
    }

    @Test
    public void findAllTest(){
        //given
        List<Person> users;

        //when
        users = service.findAll();

        //then
        assertNotNull(users);
    }


}
