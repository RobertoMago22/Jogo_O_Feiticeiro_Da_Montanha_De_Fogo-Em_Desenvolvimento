package Controller;

import Model.Heroi;
import Model.Item;

public class Controller_Heroi {
	
	private Heroi heroi;
	
	public void criarHeroi(String nome, int vida, int forca) {
		
		heroi = new Heroi(nome, vida, forca);
		
	}
	
	public int resultadoAtaque() {
		
		return heroi.atacar();
	}
	
	public boolean semVida() {
		
		if(heroi.getVida() <= 0) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}
	
	public void adicionarItem(String nome, int unidade) {
		
		Item item = new Item(nome, unidade);
		
		heroi.adicionarItem(item);
		
	}
	
	public void excluirItem(Item item) {
		
		//heroi.excluirItem(item);
		
	}
	
	public boolean usarMoedas(int valor) {
		
		if(heroi.getInventario().get(0).getUnidade() >= valor) {
			
			int moeda = heroi.getInventario().get(0).getUnidade() - valor;
			
			heroi.getInventario().get(0).setUnidade(moeda);
			
			return true;
		}
		
		else {
			
			return false;
			
		}
		
	}
	
	

}
