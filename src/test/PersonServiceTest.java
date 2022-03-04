package test;


import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entities.Person;
import repositories.PersonRepository;
import services.PersonService;

public class PersonServiceTest {

    private PersonService service;
    private PersonRepository repository;

    @BeforeAll
    public void instantiateService(){
        service = new PersonService();
        repository = PersonRepository.factory();
    }

    @Test
    public void findAllTest(){

        List<Person> list = repository.findAll();
        for (Person person: list) {
            printPerson(person);

        }
    }

    private void printPerson(Person person){
        System.out.println("ID: " + person.getId());
        System.out.println("NAME: " + person.getOwnerName());
        System.out.println("EMAIL: " + person.getEmail());
        System.out.println("CPF:" + person.getCpf());
        System.out.println("USERNAME: " + person.getUserName());
        System.out.println();
    }


}
