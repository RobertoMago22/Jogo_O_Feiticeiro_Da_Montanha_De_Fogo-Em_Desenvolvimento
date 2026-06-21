package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heroi {
	
	private String nome;
	private int vida;
	private int forca;
	private List<Item> inventario;
	
	
	public Heroi(String nome, int vida, int forca) {
		this.nome = nome;
		this.vida = vida;
		this.forca = forca;
		
		inventario = new ArrayList<>();
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public int getForca() {
		return forca;
	}


	public void setForca(int forca) {
		this.forca = forca;
	}
	
	
	public List<Item> getInventario() {
		return inventario;
	}


	public void setInventario(List<Item> inventario) {
		this.inventario = inventario;
	}
	
	
	public void adicionarItem(Item item) {
		
		inventario.add(item);
		
	}
	
	//Verificar
	public void excluirItem(String nome) {
		
		for(Item item : inventario) {
			
			if(item.getNome().equals(nome)) {
				
				inventario.remove(item);
				break;
				
			}
			
		}
		
	}

	
	public void perdeVida() {
		this.vida -= 2;
	}
	
	
	public int atacar() {
		
		Random random = new Random();
		
		int sorte = random.nextInt();
		
		return sorte;
	}
	
	

}
