package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
	
	private final SimpleStringProperty nome;
	private final SimpleIntegerProperty unidade;
	
	
	public Item(String nome, int unidade) {
		
		this.nome = new SimpleStringProperty(nome);
		this.unidade = new SimpleIntegerProperty(unidade);
	}


	public String getNome() {
		return nome.get();
	}


	public void setNome(String nome) {
		this.nome.set(nome);
	}


	public int getUnidade() {
		return unidade.get();
	}


	public void setUnidade(int unidade) {
		this.unidade.set(unidade);
	}
	
	public SimpleStringProperty nomeProperty() {
		return nome;
	}
	
	public SimpleIntegerProperty unidadeProperty() {
		return unidade;
	}
	
	
}
