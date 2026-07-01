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
			System.out.println("1 - Criar Produto                    ");
			System.out.println("2 - Listar Todos os produtos         ");
			System.out.println("3 - Buscar produto por ID            ");
			System.out.println("4 - Buscar produtos por nome         ");
			System.out.println("5 - Atualizar cadastro do produto    ");
			System.out.println("6 - Apagar Produto                   ");
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
				System.out.println("\n digite um número inteiro entre 0 e 6");
				teclado.nextLine();
			}

			switch (op) {
			case 1: {
				System.out.println("*************************************");
				System.out.println("CRIAR PRODUTO");
				System.out.println("*************************************");
				cadastrarProduto();
				keyPress();
				break;
			}

			case 2: {
				System.out.println("*************************************");
				System.out.println("LISTAR TODOS OS PRODUTOS");
				System.out.println("*************************************");
				listarProdutos();
				keyPress();
				break;
			}

			case 3: {
				System.out.println("*************************************");
				System.out.println("BUSCAR PRODUTO POR ID");
				System.out.println("*************************************");
				procurarProdutoPorId();
				keyPress();
				break;
			}

			case 4: {
				System.out.println("*************************************");
				System.out.println("BUSCAR PRODUTO POR NOME");
				System.out.println("*************************************");
				listarPorNome();
				keyPress();
				break;
			}

			case 5: {
				System.out.println("*************************************");
				System.out.println("ATUALIZAR CADASTRO DO PRODUTO");
				System.out.println("*************************************");
				atualizarProduto();
				keyPress();
				break;
			}

			case 6: {
				System.out.println("*************************************");
				System.out.println("APAGAR PRODUTO");
				System.out.println("*************************************");
				deletarProduto();
				keyPress();
				break;
			}

			case 0: {
				System.out.println("*************************************");
				System.out.println("SISTEMA FINALIZADO");
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
		System.out.println("https://github.com");
		System.out.println("*********************************************************");
	}

	public static void listarProdutos() {
		System.out.println("\n[Aguardando a Etapa de Collections para carregar a lista de produtos]");
	}

	public static void listarPorNome() {
		System.out.println("Digite o nome da pizza ou parte dele: ");
		String nome = teclado.nextLine();
		System.out.println("\n[Buscando dados locais por nome: " + nome + "]");
	}

	public static void cadastrarProduto() {
		System.out.println("Digite o nome do produto: ");
		String nome = teclado.nextLine();

		System.out.println("Digite o tipo do produto (1 - Pizza | Outros em implementação): ");
		int tipo = teclado.nextInt();

		System.out.println("Digite a quantidade disponível: ");
		int quantidade = teclado.nextInt();

		System.out.println("Digite o preço do produto: ");
		float preco = teclado.nextFloat();
		teclado.nextLine();

		switch (tipo) {
		case 1 -> {
			System.out.println("Digite o sabor da pizza: ");
			String sabor = teclado.nextLine();
			
			System.out.println("\n✅ Dados recebidos no Menu com sucesso!");
			System.out.println("Nome: " + nome + " | Qtd: " + quantidade + " | R$ " + preco + " | Sabor: " + sabor);
		}
		default -> System.out.println("Tipo de produto inválido");
		}
	}

	public static void procurarProdutoPorId() {
		System.out.println("Digite o ID do produto: ");
		int id = teclado.nextInt();
		teclado.nextLine();

		System.out.println("\n[Buscando dados locais pelo ID: " + id + "]");
	}

	public static void deletarProduto() {
		System.out.println("Digite o ID do produto: ");
		int id = teclado.nextInt();
		teclado.nextLine();

		System.out.printf("\nTem certeza que você deseja excluir o produto de ID %d? (S ou N): ", id);
		String confirmacao = teclado.nextLine();

		if (confirmacao.equalsIgnoreCase("s")) {
			System.out.println("\nProduto excluído com sucesso (simulação)!");
		} else {
			System.out.println("\nOperação cancelada!");
		}
	}

	public static void atualizarProduto() {
		System.out.println("Digite o ID do produto: ");
		int id = teclado.nextInt();
		teclado.nextLine();

		System.out.println("Digite o novo nome (Pressione ENTER para manter o valor atual): ");
		String nome = teclado.nextLine();

		System.out.println("Digite a quantidade atualizada (Pressione ENTER para manter o valor atual): ");
		String qtdEntrada = teclado.nextLine();

		System.out.println("Digite o novo valor (Pressione ENTER para manter o valor atual): ");
		String precoEntrada = teclado.nextLine();

		System.out.println("Digite o novo sabor (Pressione ENTER para manter o valor atual): ");
		String sabor = teclado.nextLine();
		
		System.out.println("\n🔄 Dados de atualização recebidos com sucesso no Menu para o ID " + id);
	}
}
