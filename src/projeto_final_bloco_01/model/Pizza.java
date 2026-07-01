package projeto_final_bloco_01.model;

public class Pizza extends Produto {
	
	private String sabor;

	public Pizza(int id, int tipo, String nome, int quantidade, float preco, String sabor) {
		super(id, tipo, nome, quantidade, preco);
		this.sabor = sabor;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Sabor da pizza: " + sabor);
	}
	
	//get e set
	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

}
