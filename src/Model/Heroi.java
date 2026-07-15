package Model;

import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Heroi extends Personagem {
	
	private final SimpleIntegerProperty moeda;
	private ObservableList <Item> inventario;
	
	
	public Heroi(String nome, int vida, int forca) {
		super(nome, vida, forca);
		
		this.moeda = new SimpleIntegerProperty(10);
		this.inventario = FXCollections.observableArrayList(new Item("Poção de Cura", 5));
		
	}
	
	
	public ObservableList<Item> getInventario() {
		return inventario;
	}


	public void setInventario(ObservableList<Item> inventario) {
		this.inventario = inventario;
	}


	public void setMoeda(int moeda) {
		this.moeda.set(moeda);
	}
	
	public int getMoeda() {
		return moeda.get();
	}
	
	public SimpleIntegerProperty moedaProperty() {
		return moeda;
	}


	public void adicionarItem(Item item) {
		
		inventario.add(item);
	}
	
	//Verificar
	public void excluirItem(Item item) {
				
		inventario.remove(item);		
	}
	
	
	public void usarItem(Item item) {
		
		item.setUnidade(item.getUnidade() - 1);
	}
	
	
	public int atacar() {
		
		Random random = new Random();
		
		int sorte = random.nextInt();
		
		return sorte;
	}
	
	

}
