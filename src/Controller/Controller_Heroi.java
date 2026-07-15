package Controller;

import Model.Heroi;
import Model.Item;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class Controller_Heroi {
	
	private Heroi heroi;
	
	public void criarHeroi(String nome, int vida, int forca) {
		
		heroi = new Heroi(nome, vida, forca);
		
	}
	
	public Heroi getHeroi() {
		return heroi;
	}
	
	public SimpleDoubleProperty vidaAtual() {
		return heroi.vidaAtualProperty();
	}
	
	public SimpleDoubleProperty vidaMax() {
		return heroi.vidaMaxProperty();
	}
	
	public SimpleStringProperty nome() {
		return heroi.nomeProperty();
	}
	
	public void adicionarItem(String nome, int quantidade) {
		heroi.adicionarItem(new Item(nome, quantidade));
	}
	
	public ObservableList<Item> getInventario(){
		return heroi.getInventario();
	}
	
	
	
	
	
	
}