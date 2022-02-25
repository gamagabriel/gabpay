package entities;

import java.time.LocalDate;
import java.util.Objects;

public class Person extends User {
    private String userName;
    private String cpf;
    private LocalDate birthDate;

    public Person() {}

    public Person(String ownerName, String email, Long phoneNumber, Double balance, String userName, String cpf, LocalDate birthDate) {
        super(ownerName, email, phoneNumber, balance);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return userName.equals(person.userName) && cpf.equals(person.cpf) && birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userName, cpf, birthDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                "} " + super.toString();
    }
}
