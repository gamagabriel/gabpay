package builders;

import entities.Person;

import java.time.LocalDate;

public class PersonBuilder {

    private String id;
    private String ownerName;
    private String email;
    private Long phoneNumber;
    private Double balance;
    private String userName;
    private String cpf;
    private LocalDate birthDate;

    public PersonBuilder id(String id){
        this.id = id;
        return this;
    }

    public PersonBuilder ownerName(String ownerName){
        this.ownerName = ownerName;
        return this;
    }

    public PersonBuilder email(String email){
        this.email = email;
        return this;
    }

    public PersonBuilder phoneNumber(Long phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PersonBuilder balance(Double balance){
        this.balance = balance;
        return this;
    }

    public PersonBuilder userName(String userName){
        this.userName = userName;
        return this;
    }

    public PersonBuilder cpf(String cpf){
        this.cpf = cpf;
        return this;
    }

    public PersonBuilder birthDate(LocalDate birthDate){
        this.birthDate = birthDate;
        return this;
    }

    public Person build(){
        return new Person(id, ownerName, email, phoneNumber, balance, userName, cpf, birthDate);
    }

}
