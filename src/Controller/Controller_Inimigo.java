package Controller;

import Model.Inimigo;

public class Controller_Inimigo {
	
	private Inimigo inimigo;
	
	
	public void criarInimigo(String nome, int vida, int forca) {
		
		inimigo = new Inimigo(nome, vida, forca);
		
	}
	
}