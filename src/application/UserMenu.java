package application;

public abstract class UserMenu {

    public static void options(){
        System.out.println("O que deseja fazer?\n");
        System.out.println("(1) Criar conta");
        System.out.println("(2) Buscar conta");
        System.out.println("(3) Listar todas as contas");
        System.out.println("(4) Deletar uma conta");
        System.out.println("(5) Para sair");
        System.out.println();
        System.out.print("Número: ");
    }
}
