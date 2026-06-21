package Model;

public class Item {
	
	private String nome;
	private int unidade;
	
	
	public Item(String nome, int unidade) {
		
		this.nome = nome;
		this.unidade = unidade;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getUnidade() {
		return unidade;
	}


	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}
	
}
