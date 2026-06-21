package Model;

import java.util.Random;

public class Inimigo {
	
	private String nome;
	private int vida;
	private int forca;
	
	
	public Inimigo(String nome, int vida, int forca) {
		this.nome = nome;
		this.vida = vida;
		this.forca = forca;
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

	
	public void perdeVida() {
		this.vida -= 2;
	}
	
	
	public int atacar() {
		
		Random random = new Random();
		
		int sorte = random.nextInt(1, 13);
		
		return sorte;
		
	}
	

}
