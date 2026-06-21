package Controller;

import Model.Inimigo;

public class Controller_Inimigo {
	
	private Inimigo inimigo;
	
	
	public void criarInimigo(String nome, int vida, int forca) {
		
		inimigo = new Inimigo(nome, vida, forca);
		
	}
	
	public int resultadoAtaque() {
		
		return inimigo.atacar();
	}
	
	public boolean semVida() {
		
		if(inimigo.getVida() <= 0) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}

}
