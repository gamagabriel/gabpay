package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner ac = new Scanner(System.in);

		System.out.println("Olá! Bem-vindo ao GabPay!\n");
		System.out.println("Qual conta você deseja acessar?" + "\n1. Personal Account" + "\n2. Store Account\n");
		System.out.print("Digite o número correspondente (1/2): ");
		int num = ac.nextInt();

		switch (num) {
		case 1:
			System.out.println("Personal Account");
			break;
		case 2:
			System.out.println("Store Account");
			break;
		}

		ac.close();
	}

}
