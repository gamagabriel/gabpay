package entities;

import entities.builders.PersonBuilder;

import java.time.LocalDate;

public class Person extends User {
    private String userName;
    private String cpf;
    private LocalDate birthDate;

    public Person() {}

    public Person(String id, String ownerName, String email, Long phoneNumber, Double balance, String userName, String cpf, LocalDate birthDate) {
        super(id, ownerName, email, phoneNumber, balance);
        this.userName = userName;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return  super.toString() + ","
                + userName + ","
                + cpf + ","
                + birthDate;
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }
}
