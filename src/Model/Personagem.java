package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Personagem {
	
	private final SimpleStringProperty nome;
	private final SimpleDoubleProperty vidaMax;
	private final SimpleDoubleProperty vidaAtual;
	private final SimpleIntegerProperty forca;
	
	
	public Personagem(String nome, int vida, int forca) {
		
		this.nome = new SimpleStringProperty(nome);
		this.vidaMax = new SimpleDoubleProperty(vida);
		this.forca = new SimpleIntegerProperty(forca);
		this.vidaAtual = new SimpleDoubleProperty(vida);
	}
	
	
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public void setVidaMax(int vida) {
		this.vidaMax.set(vida);
	}
	
	public double getVidaMax() {
		return vidaMax.get();
	}
	
	public void setVidaAtual(int vida) {
		this.vidaAtual.set(vida);
	}
	
	public double getVidaAtual() {
		return vidaAtual.get();
	}
	
	
	public void setForca(int forca) {
		this.forca.set(forca);
	}
	
	public int getForca() {
		return forca.get();
	}


	public SimpleStringProperty nomeProperty() {
		return nome;
	}

	public SimpleDoubleProperty vidaMaxProperty() {
		return vidaMax;
	}
	
	public SimpleDoubleProperty vidaAtualProperty() {
		return vidaAtual;
	}

	public SimpleIntegerProperty forcaProperty() {
		return forca;
	}

	

}
