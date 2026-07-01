package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private static final Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int op = 0;

		do {
			System.out.println("                                     ");
			System.out.println("      PIZZARIA ONLINE                ");
			System.out.println("                                     ");
			System.out.println("*************************************");
			System.out.println("                                     ");
			System.out.println("1 - Cadastrar Produto                ");
			System.out.println("2 - Listar todos os Produtos         ");
			System.out.println("3 - Listar Produto pelo ID           ");
			System.out.println("4 - Atualizar Produto                ");
			System.out.println("5 - Deletar Produto                  ");
			System.out.println("0 - Sair                             ");
			System.out.println("                                     ");
			System.out.println("*************************************");
			System.out.println("                                     ");
			System.out.println("Entre com a opção desejada:          ");

			try {
				op = teclado.nextInt();
				teclado.nextLine();
			} catch (InputMismatchException e) {
				op = -1;
				System.out.println("\n digite um número entre 0 e 5");
				teclado.nextLine();
			}

			switch (op) {
			case 1: {
				System.out.println("*************************************");
				System.out.println("CADASTRAR PRODUTO");
				System.out.println("*************************************");
				keyPress();
				break;
			}

			case 2: {
				System.out.println("*************************************");
				System.out.println("LISTAR TODOS OS PRODUTOS");
				System.out.println("*************************************");
				keyPress();
				break;
			}

			case 3: {
				System.out.println("*************************************");
				System.out.println("LISTAR PRODUTO PELO ID");
				System.out.println("*************************************");
				keyPress();
				break;
			}

			case 4: {
				System.out.println("*************************************");
				System.out.println("ATUALIZAR PRODUTO");
				System.out.println("*************************************");
				keyPress();
				break;
			}

			case 5: {
				System.out.println("*************************************");
				System.out.println("DELETAR PRODUTO");
				System.out.println("*************************************");
				keyPress();
				break;
			}

			case 0: {
				System.out.println("*************************************");
				System.out.println("SISTEMA ENCERRADO");
				System.out.println("*************************************");
				sobre();
				break;
			}

			default:
				System.out.println("*************************************");
				System.out.println("Comando inválido");
				System.out.println("*************************************");
				break;
			}

		} while (op != 0);

	}

	public static void keyPress() {
		System.out.println("\n\nPressione Enter para continuar...");
		teclado.nextLine();
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto: Pizzaria Online");
		System.out.println("Desenvolvido por: Gabriel José");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("https://github.com/gaab98/");
		System.out.println("*********************************************************");
	}
}
