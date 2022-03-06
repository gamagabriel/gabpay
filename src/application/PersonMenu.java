package application;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import entities.Person;
import repositories.RepositoryException;
import services.PersonService;

public abstract class PersonMenu {

	public static void mainMenu(Scanner sc, PersonService ps) {
		char choice = 0;
		System.out.println("\n---PERSONAL ACCOUNT---");
		while (choice != '5') {
			
			System.out.println("O que deseja fazer?\n");
			System.out.println("Criar conta, digite 1");
			System.out.println("Buscar conta, digite 2");
			System.out.println("Listar todas as contas, digite 3");
			System.out.println("Deletar uma conta, digite 4");
			System.out.println("Para sair, digite 5");
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
				caseThree(ps);
				break;
			case '4':
				caseFour(sc, ps);
				break;
			case '5':

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
		System.out.println("\nQual busca deseja realizar?");
		System.out.println("1. Buscar por ID");
		System.out.println("2. Buscar por @username");
		System.out.println("3. Voltar ao menu");
		System.out.print("\nDigite o número correspondente (1/2): ");
		char num = 0;
		
		while(num != '4') {
			num = sc.nextLine().charAt(0);
			
			switch (num) {
			case '1':
				caseId(sc, ps);
				break;
			case '2':
				caseUserName(sc, ps);
				break;
			case '3':
				mainMenu(sc, ps);
				return;
			default:
				System.out.println("\nOpção inválida");
				caseTwo(sc, ps);
				break;
			}
		}
		
	}

	private static void caseThree(PersonService ps){
		List<Person> personList = ps.findAll();
		for (Person person: personList) {
			printPerson(person);
		}
	}

	private static void caseFour(Scanner sc, PersonService ps){
		try{
			System.out.print("Entre com o ID do user a ser excluído: ");
			String idUser = sc.nextLine();
			ps.deleteById(idUser);
			System.out.println("\nUsuario ID" + idUser + " removido com sucesso\n");
		} catch(RepositoryException e){
			System.out.println("\nO ID digitado é inexistente.\n");
			return;
		}

	}
	
	private static void caseId(Scanner sc, PersonService ps) {
		try {
		System.out.print("Entre com o ID do user: ");
		String idUser = sc.nextLine();
		Person person = ps.findById(idUser);
		printPerson(person);
		} catch (RepositoryException e) {
			System.out.println("\n*ID INVÁLIDO! TENTE NOVAMENTE* \n");
			caseTwo(sc, ps);
		}
	}

	private static void caseUserName(Scanner sc, PersonService ps){
		try{
			System.out.print("Entre com o @username: ");
		String userName = sc.nextLine();
		Person person = ps.findByUserName(userName);
		printPerson(person);
		} catch (NoSuchElementException e) {
			System.out.println("\n*@USERNAME INVÁLIDO! TENTE NOVAMENTE* \n");
			caseTwo(sc, ps);
		}
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
