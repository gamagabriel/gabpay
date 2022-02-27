package application;

import java.util.Locale;
import java.util.Scanner;

import services.PersonService;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		PersonService ps = new PersonService();
		Scanner sc = new Scanner(System.in);

		System.out.println("Ol�! Bem-vindo ao GabPay!\n");
		System.out.println("Qual conta voc� deseja acessar?" + "\n1. Personal Account" + "\n2. Store Account\n");
		System.out.print("Digite o n�mero correspondente (1/2): ");
		int num = sc.nextInt();
		sc.nextLine();

		switch (num) {
		case 1:
			PersonMenu.mainMenu(sc, ps);
			break;
		case 2:
			System.out.println("Store Account");
			break;
		}

		sc.close();
	}

}
