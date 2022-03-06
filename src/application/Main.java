package application;

import services.PersonService;
import services.StoreService;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		PersonService ps = new PersonService();
		StoreService ss = new StoreService();
		Scanner sc = new Scanner(System.in);

		System.out.println("Olá! Bem-vindo ao GabPay!\n");
		System.out.println("Qual conta você deseja acessar?" + "\n1. Personal Account" + "\n2. Store Account\n");
		System.out.print("Digite o número correspondente (1/2): ");
		int num = sc.nextInt();
		sc.nextLine();

		switch (num) {
		case 1:
			PersonMenu.mainMenu(sc, ps);
			break;
		case 2:
			StoreMenu.mainMenu(sc, ss);
			break;
		}

		sc.close();
	}

}
