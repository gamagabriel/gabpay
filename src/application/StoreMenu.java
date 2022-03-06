package application;

import java.lang.ref.Cleaner;
import java.util.List;
import java.util.Scanner;

import entities.Store;
import repositories.RepositoryException;
import services.StoreService;

public class StoreMenu {
	
	public static void mainMenu(Scanner sc, StoreService ss) {
		char choice = 0;
		System.out.println("\n--- STORE ACCOUNT ---");
		
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
				caseOne(sc, ss);
				break;
			case '2':
				caseTwo(sc, ss);
				break;
			case '3':
				caseThree(ss);
				break;
			case '4':
				caseFour(sc, ss);
				break;
			case '5':
				break;

			default:
				System.out.println("Opção inválida");
				break;
			}
		}	
	}
	
	private static void caseOne(Scanner sc, StoreService ss) {
		System.out.print("Digite o seu nome: ");
		String ownerName = sc.nextLine();
		System.out.print("Digite o seu email: ");
		String email = sc.nextLine();
		System.out.print("Digite o seu número de telefone: ");
		Long phoneNumber = sc.nextLong();
		sc.nextLine();
		System.out.print("Digite o nome da loja: ");
		String storeName = sc.nextLine();
		System.out.print("Digite o CNPJ: ");
		String cnpj = sc.nextLine();
		System.out.print("Digite o seu CPF: ");
		String ownerCpf = sc.nextLine();
		
		Store store = Store.builder()
				.ownerName(ownerName)
				.email(email)
				.phoneNumber(phoneNumber)
				.balance(0.0)
				.storeName(storeName)
				.cnpj(cnpj)
				.ownerCpf(ownerCpf)
				.build();
		
		ss.save(store);
		System.out.println("\nLoja cadastrada com sucesso!\n");
	}
	
	private static void caseTwo(Scanner sc, StoreService ss) {
		System.out.println("\nQual busca deseja realizar?");
		System.out.println("1. Buscar por ID");
		System.out.println("2. Buscar por Cnpj");
		System.out.println("3. Voltar ao menu");
		System.out.print("\nDigite o número correspondente (1/2): ");
		char choice = 0;

		while(choice != '4'){
			choice = sc.nextLine().charAt(0);

			switch (choice){
				case '1':
					caseId(sc, ss);
					break;
				case '2':
					caseCnpj(sc, ss);
					break;
				case '3':
					mainMenu(sc, ss);
					break;

			}

		}

	}

	private static void caseThree(StoreService ss) {
		List<Store> list = ss.findAll();
		for(Store store: list) {
			printStore(store);
		}
	}

	private static void caseFour(Scanner sc, StoreService ss){
		try {
			System.out.print("Entre com o ID a ser excluido: ");

			String id = sc.nextLine();
			ss.deleteById(id);
			System.out.println("Store ID " + id + " removida com sucesso");
		} catch (RepositoryException e){
			System.out.println("ID nao encontrado.");
			mainMenu(sc, ss);
		}
	}

	private static void caseId(Scanner sc, StoreService ss){

		try {
			System.out.print("Entre com o ID: ");
			String id = sc.next();
			Store store = ss.findById(id);
			printStore(store);
		} catch(StringIndexOutOfBoundsException e) {
			System.out.println("ID INVALIDO! Tente novamente");
			e.getStackTrace();
			caseTwo(sc, ss);
		}
	}

	private static void caseCnpj(Scanner sc, StoreService ss) {
		try{
			System.out.print("Entre com o CNPJ: ");
			String cnpj = sc.nextLine();
			Store store = ss.findByCnpj(cnpj);
			printStore(store);
		} catch(RepositoryException e){
			e.getStackTrace();
		}

	}

	private static void printStore(Store store){
		System.out.println();
		System.out.println("ID: " + store.getId());
		System.out.println("CNPJ:" + store.getCnpj());
		System.out.println("STORE NAME: " + store.getStoreName());
		System.out.println("OWNER NAME: " + store.getOwnerName());
		System.out.println("EMAIL: " + store.getEmail());
		System.out.println();
	}
}
