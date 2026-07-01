package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface Repository {

	// CRUD
	public void listarTodos();

	public void cadastrar(Produto produto);

	public void procurarPorId(int id);

	public void atualizar(Produto produto);

	public void deletar(int id);

	public void listarPorNome(String Nome);

}
