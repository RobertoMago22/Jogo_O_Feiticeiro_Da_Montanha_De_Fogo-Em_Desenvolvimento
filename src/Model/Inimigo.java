package Model;

import java.util.Random;

public class Inimigo extends Personagem {
	
	
	public Inimigo(String nome, int vida, int forca) {
		super(nome, vida, forca);
	}
	
	
	public int atacar() {
		
		Random random = new Random();
		
		int sorte = random.nextInt();
		
		return sorte;
	}
	
	

}