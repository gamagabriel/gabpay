package application;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import services.PersonService;
import services.StoreService;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Locale.setDefault(Locale.US);
		PersonService ps = new PersonService();
		StoreService ss = new StoreService();
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
			StoreMenu.mainMenu(sc, ss);
			break;
		}

		sc.close();
	}

}
