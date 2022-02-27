package application;

import java.time.LocalDate;
import java.util.Scanner;

import entities.Person;
import services.PersonService;

public abstract class PersonMenu {

	public static void mainMenu(Scanner sc, PersonService ps) {
		char choice = 0;

		while (choice != '5') {
			System.out.println("Criar conta, digite 1");
			System.out.println("Buscar conta, digite 2");
			System.out.println("Lista de todas as contas, digite 3");
			System.out.println("Deletar conta, digite 4");
			System.out.println("Para sair, digite 5");
			System.out.println();
			System.out.print("Número: ");
			choice = sc.nextLine().charAt(0);

			switch (choice) {
			case '1':
				caseOne(sc, ps);
				break;
			case '2':

				break;
			case '3':

				break;
			case '4':

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
}
