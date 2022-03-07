package repositories;

import entities.Person;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private static final String path = System.getProperty("user.dir") + "/person";

    private void writeAll(List<Person> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Person person : list) {
                bw.write(person.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Person> readAll() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Person> users = new ArrayList<>();

            String line = br.readLine();

            String[] personLine;

            String id;
            String ownerName;
            String email;
            long phoneNumber;
            double balance;
            String userName;
            String cpf;
            LocalDate birthDate;

            while (line != null) {
                personLine = line.split(",");

                id = personLine[0];
                ownerName = personLine[1];
                email = personLine[2];
                phoneNumber = Long.parseLong(personLine[3]);
                balance = Double.parseDouble(personLine[4]);
                userName = personLine[5];
                cpf = personLine[6];
                birthDate = LocalDate.parse(personLine[7]);

                Person person = new Person(id, ownerName, email, phoneNumber, balance, userName, cpf, birthDate);
                users.add(person);

                line = br.readLine();

            }
            return users;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<Person> findAll() {
        return readAll();
    }

    public Person findById(String id) {
        List<Person> users = readAll();
        for (Person person : users) {
            if (person.getId().equals(id)) return person;
        }
        throw new RepositoryException("Store dont found");
    }


    public void saveAll(List<Person> list) {
        List<Person> users = readAll();
        for (Person person : list) {
            if (users.contains(person)) throw new RepositoryException("Person already exists on the data base");
            users.add(person);
        }
        writeAll(users);
    }

    public void save(Person person) {
        List<Person> users = readAll();
        if (users.contains(person)) throw new RepositoryException("Person already exists on the data base");
        users.add(person);
        writeAll(users);
    }

    public void deleteAll() {
        writeAll(new ArrayList<>());
    }

    public void delete(Person person) {
        List<Person> users = readAll();
        if (!users.contains(person)) throw new RepositoryException("Person dont found");
        users.remove(person);
        writeAll(users);
    }

    public void deleteById(String id) {
        List<Person> users = readAll();
        users.remove(findById(id));
        writeAll(users);
    }

    public static PersonRepository factory(){
        return new PersonRepository();
    }

}
