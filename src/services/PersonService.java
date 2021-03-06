package services;

import entities.Person;
import repositories.PersonRepository;
import repositories.RepositoryException;
import utils.IdGenerator;

import java.util.List;
import java.util.NoSuchElementException;

public class PersonService {

    private final PersonRepository repository;

    public PersonService() {
        this.repository = PersonRepository.factory();
    }

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findById(String id){
        return repository.findById(id);
    }

    public Person findByUserName(String userName){
        List<Person> list = repository.findAll();
        for (Person person: list) {
            if (person.getUserName().equals(userName)){
                return person;
            }
        } throw new NoSuchElementException("Username not found");
    }

    public Person save(Person person){
        checkUniqueFields(person);
        checkNullFields(person);
        var id = IdGenerator.getRandomId();
        person.setId(id);
        repository.save(person);
        return findById(id);
    }

    public List<Person> deleteById(String id){
        repository.deleteById(id);
        return null;
    }

    private void checkUniqueFields(Person person){
        var users = findAll();
        for (Person p : users) {
            if (p.getCpf().equals(person.getCpf())) throw new RepositoryException("CPF already exists in the data base");
            if (p.getUserName().equals(person.getUserName())) throw new RepositoryException("User name already exists in the data base");
            if (p.getEmail().equals(person.getEmail())) throw new RepositoryException("Email name already exists in the data base");
            if (p.getPhoneNumber().equals(person.getPhoneNumber())) throw new RepositoryException("Phone number name already exists in the data base");
        }
    }

    private void checkNullFields(Person person){
        if (person.getPhoneNumber() == null) throw new RepositoryException("PhoneNumber can not be null");
        if (person.getEmail() == null) throw new RepositoryException("Email can not be null");
        if (person.getCpf() == null) throw new RepositoryException("CPF can not be null");
        if (person.getUserName() == null) throw new RepositoryException("UserName can not be null");
        if (person.getBirthDate() == null) throw new RepositoryException("BirthDate name can not be null");
        if (person.getOwnerName() == null) throw new RepositoryException("OwnerName can not be null");
        if (person.getBalance() == null) throw new RepositoryException("Balance can not be null");
    }
}
