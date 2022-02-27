package test;

import entities.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.PersonRepository;
import services.PersonService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
