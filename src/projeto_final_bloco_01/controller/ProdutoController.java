package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.Repository;

public class ProdutoController implements Repository {

	private List<Produto> listaProdutos = new ArrayList<Produto>();
	private int id = 0;

	// CRUD
	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
			System.out.println("");
			System.out.println("***************************************");
			System.out.println("");
		}
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.printf("O produto %d foi criado com sucesso!\n", produto.getId());
	}

	@Override
	public void procurarPorId(int id) {
		Optional<Produto> produto = localizarPorCodigo(id);

		if (produto.isPresent()) {
			produto.get().visualizar();
		} else {
			System.out.printf("\n O produto %d não foi encontrado!", id);
		}
	}

	@Override
	public void atualizar(Produto produto) {
		Optional<Produto> buscaProduto = localizarPorCodigo(produto.getId());

		if (buscaProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
			System.out.printf("O produto %d foi atualizado com sucesso!", produto.getId());
		} else {
			System.out.printf("\nO produto %d não foi encontrado!", produto.getId());
		}
	}

	@Override
	public void deletar(int id) {
		Optional<Produto> produto = localizarPorCodigo(id);

		if (produto.isPresent()) {
			if (listaProdutos.remove(produto.get())) {
				System.out.printf("O produto %d foi excluído com sucesso!", id);
			}
		} else {
			System.out.printf("\nO produto %d não foi encontrado!", id);
		}
	}

	@Override
	public void listarPorNome(String nome) {
		List<Produto> listaProdutosNomes = listaProdutos.stream()
				.filter(produto -> produto.getNome().toUpperCase().contains(nome.toUpperCase()))
				.collect(Collectors.toList());

		if (listaProdutosNomes.isEmpty()) {
			System.out.println("\nNenhum produto foi encontrado.");
		} else {
			listaProdutosNomes.forEach(produto -> produto.visualizar());
			System.out.println("*************************************");
		}
	}

	public int gerarId() {
		return ++id;
	}

	public Optional<Produto> localizarPorCodigo(int id) {
		for (var produto : listaProdutos) {
			if (produto.getId() == id)
				return Optional.of(produto);
		}
		return Optional.empty();
	}
}
