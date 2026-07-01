package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Pizza;
import projeto_final_bloco_01.model.Produto;

public class Menu {

	private static final Scanner teclado = new Scanner(System.in);
	private static final ProdutoController produtoController = new ProdutoController();

	public static void main(String[] args) {

		int op = 0;

		criarProdutosTeste();

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
				System.out.println("\n digite um número entre 0 e 6");
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
				System.out.println("ATUALIZAR CADASTRO");
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

	public static void criarProdutosTeste() {
		produtoController.cadastrar(
				new Pizza(produtoController.gerarId(), 1, "Pizza Grande Familia", 20, 65.90f, "Calabresa Especial"));
		produtoController.cadastrar(
				new Pizza(produtoController.gerarId(), 1, "Pizza Broto Individual", 15, 35.00f, "Quatro Queijos"));
	}

	public static void listarProdutos() {
		produtoController.listarTodos();
	}

	public static void cadastrarProduto() {
		System.out.println("Digite o nome do produto: ");
		String nome = teclado.nextLine();

		System.out.println("Digite o tipo do produto (1 - Pizza): ");
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

			produtoController.cadastrar(new Pizza(produtoController.gerarId(), tipo, nome, quantidade, preco, sabor));
		}
		default -> System.out.println("Tipo de produto inválido");
		}
	}

	public static void procurarProdutoPorId() {
		System.out.println("Digite o ID do produto: ");
		int id = teclado.nextInt();
		teclado.nextLine();

		produtoController.procurarPorId(id);
	}

	public static void deletarProduto() {
		System.out.println("Digite o ID do produto: ");
		int id = teclado.nextInt();
		teclado.nextLine();

		Optional<Produto> produto = produtoController.localizarPorCodigo(id);

		if (produto.isPresent()) {
			System.out.printf("\nVocê deseja excluir o produto %d? (S ou N)", id);
			String confirmacao = teclado.nextLine();

			if (confirmacao.equalsIgnoreCase("s")) {
				produtoController.deletar(id);
			} else {
				System.out.println("\nOperação cancelada!");
			}
		} else {
			System.out.println("\nO produto não foi encontrado!");
		}
	}

	public static void atualizarProduto() {
		System.out.println("Digite o ID do produto: ");
		int id = teclado.nextInt();
		teclado.nextLine();

		Optional<Produto> produto = produtoController.localizarPorCodigo(id);

		if (produto.isPresent()) {
			int tipo = produto.get().getTipo();
			String nome = produto.get().getNome();
			int quantidade = produto.get().getQuantidade();
			float preco = produto.get().getPreco();
			String entrada;

			System.out.printf(
					"\nNome atual: %s\n" + "Digite o novo nome (Pressione ENTER para manter o valor atual): \n",
					nome);
			entrada = teclado.nextLine();
			nome = entrada.isEmpty() ? nome : entrada;

			System.out.printf(
					"\nQuantidade atual: %d\n"
							+ "Digite a quantidade atualizada (Pressione ENTER para manter o valor atual): \n",
					quantidade);
			entrada = teclado.nextLine();
			quantidade = entrada.isEmpty() ? quantidade : Integer.parseInt(entrada);

			System.out.printf(
					"\nPreço atual: %.2f\n" + "Digite o novo valor (Pressione ENTER para manter o valor atual): \n",
					preco);
			entrada = teclado.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));

			switch (tipo) {
			case 1 -> {
				Pizza pizza = (Pizza) produto.get();
				String sabor = pizza.getSabor();

				System.out.printf(
						"\nSabor atual: %s\n" + "Digite o novo sabor (Pressione ENTER para manter o valor atual): \n",
						sabor);
				entrada = teclado.nextLine();
				sabor = (entrada.isEmpty() ? sabor : entrada);

				produtoController.atualizar(new Pizza(id, tipo, nome, quantidade, preco, sabor));
			}
			}
		} else {
			System.out.printf("\nO produto %d não foi localizado!", id);
		}
	}

	public static void listarPorNome() {
		System.out.println("Digite o nome do produto: ");
		String nome = teclado.nextLine();

		produtoController.listarPorNome(nome);
	}
}

