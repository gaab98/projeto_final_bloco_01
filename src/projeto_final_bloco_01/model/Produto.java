package projeto_final_bloco_01.model;

public abstract class Produto {
	
	private int id;
	private int tipo;
	private String nome;
	private int quantidade;
	private float preco;
	
	public Produto(int id, int tipo, String nome, int quantidade, float preco) {
		this.id = id;
		this.tipo = tipo;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public void visualizar() {
		
		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Pizza";
			break;
		}
		
		System.out.println("ID: " + this.id);
		System.out.println("Nome: " + this.nome);
		System.out.println("Tipo: " + tipo);
		System.out.println("Quantidade: " + this.quantidade);
		System.out.printf("Preço: R$ %.2f\n", this.preco);

	}
	
	//GET E SET
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}

}
