package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import entities.Person;
import repositories.PersonRepository;
import repositories.RepositoryException;
import services.PersonService;

public abstract class PersonMenu {

	public static void mainMenu(Scanner sc, PersonService ps) {
		char choice = 0;

		while (choice != '6') {
			System.out.println("Criar conta, digite 1");
			System.out.println("Buscar conta por ID, digite 2");
			System.out.println("Buscar conta por username, digite 3");
			System.out.println("Lista de todas as contas, digite 4");
			System.out.println("Deletar conta, digite 5");
			System.out.println("Para sair, digite 6");
			System.out.println();
			System.out.print("Número: ");
			choice = sc.nextLine().charAt(0);

			switch (choice) {
			case '1':
				caseOne(sc, ps);
				break;
			case '2':
				caseTwo(sc, ps);
				break;
			case '3':
				caseThree(sc, ps);
				break;
			case '4':
				caseFour(ps);
				break;
			case '5':
				caseFive(sc, ps);
				break;
			case '6':

				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}

	}
	
	private static void caseOne(Scanner sc, PersonService ps) {
		System.out.print("Digite o seu nome: ");
		String ownerName = sc.nextLine();
		System.out.print("Digite o seu email: ");
		String email = sc.nextLine();
		System.out.print("Digite o seu número de telefone: ");
		Long phoneNumber = sc.nextLong();
		sc.nextLine();
		System.out.print("Digite o seu username: ");
		String userName = sc.nextLine();
		System.out.print("Digite o seu CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Digite sua data de nascimento (dd/MM/yyyy): ");
		String birthdateString = sc.nextLine();
		String[] birthdateVect = birthdateString.split("/");
		LocalDate birthdate = LocalDate.of(Integer.parseInt(birthdateVect[2]), Integer.parseInt(birthdateVect[1]), Integer.parseInt(birthdateVect[0]));
		
		Person person = Person.builder()
				.ownerName(ownerName)
				.email(email)
				.phoneNumber(phoneNumber)
				.balance(0.0)
				.userName(userName)
				.cpf(cpf)
				.birthDate(birthdate)
				.build();

		ps.save(person);
		
		System.out.println("Usuário registrado com sucesso!");
	}

	private static void caseTwo(Scanner sc, PersonService ps) {
		System.out.print("Entre com o ID do user: ");
		String idUser = sc.nextLine();
		Person person = ps.findById(idUser);
		printPerson(person);
	}

	private static void caseThree(Scanner sc, PersonService ps){
		System.out.print("Entre com o username: ");
		String userName = sc.nextLine();
		Person person = ps.findByUserName(userName);
		printPerson(person);
	}

	private static void caseFour(PersonService ps){
		List<Person> personList = ps.findAll();
		for (Person person: personList) {
			printPerson(person);
		}
	}

	private static void caseFive(Scanner sc, PersonService ps){
		System.out.print("Entre com o ID do user a ser excluído: ");
		String idUser = sc.nextLine();

		try{
			ps.deleteById(idUser);
		} catch(RepositoryException e){
			System.out.println("ID do user invalido");
			System.out.println();
			return;
		}
		System.out.println("Usuario ID" + idUser + " removido com sucesso");

	}

	private static void printPerson(Person person){
		System.out.println();
		System.out.println("ID: " + person.getId());
		System.out.println("NAME: " + person.getOwnerName());
		System.out.println("EMAIL: " + person.getEmail());
		System.out.println("CPF:" + person.getCpf());
		System.out.println("USERNAME: " + person.getUserName());
		System.out.println();
	}
}
