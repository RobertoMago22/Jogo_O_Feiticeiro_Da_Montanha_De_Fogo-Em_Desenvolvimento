package Controller;

import Model.DadoAzul;
import Model.DadoHeroi;
import Model.Heroi;
import Model.Item;
import Model.Tela_Button;
import Model.Tela_Imagem;
import Model.Tela_Inventario;
import Model.Tela_Status;
import Model.Tela_Texto;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Controller_Tela {
	
	private Tela_Status status;
	private Tela_Inventario inventario;
	private Tela_Button botoes;
	private Tela_Texto texto;
	private Tela_Imagem imagem;
	private DadoAzul dadoAzul;
	private DadoHeroi dadoHeroi;
	
	
	public Controller_Tela(Heroi heroi, Controller_Heroi controller, Scene scene) {
		
		this.status = new Tela_Status(heroi);
		this.inventario = new Tela_Inventario(heroi);
		this.botoes = new Tela_Button();
		this.texto = new Tela_Texto();
		this.imagem = new Tela_Imagem();
		this.dadoAzul = new DadoAzul(scene);
		this.dadoHeroi = new DadoHeroi(this.dadoAzul, scene);
		verificadorItem(controller);
		pagina(1);
	}
	
	public Tela_Status getStatus() {
		return status;
	}
	
	public Tela_Inventario getInventario() {
		return inventario;
	}
	
	public Tela_Button getButton() {
		return botoes;
	}
	
	public Tela_Texto getTexto() {
		return texto;
	}
	
	public Tela_Imagem getImagem() {
		return imagem;
	}
	
	public DadoHeroi getDadoHeroi() {
		return dadoHeroi;
	}
	
	public void verificadorHp(double vida) {
		
		if(vida >= 60) {
			status.vida60();
		}
		else if(vida >= 30) {
			status.vida30();
		}
		else {
			status.vida();
		}
		
	}
	
	public void verificadorItem(Controller_Heroi controller) {
		
		inventario.getButton().setOnAction(e -> {
			
			Item item = inventario.getTableView().getSelectionModel().getSelectedItem();
			if(item != null) {
				if(item.getUnidade() >= 1) {
					item.setUnidade(item.getUnidade() - 1);
					controller.excluirItem(item);
				}
			}
			
		});
		
	}
	
	public void adicionarButton(int numero) {
		
		botoes.adicionarButton(numero);
	}
	
	public void adicionarTextoButton(String nome1, String nome2) {
		
		botoes.adicionarTexto(nome1, nome2);
	}
	
	public void pagina(int numero) {
		
		botoes.excluirButton();
		
		switch(numero) {
		
			case 1:
				adicionarButton(1);
				adicionarTextoButton("Norte", "Sul");
				adicionarAcaoButton(botoes.getBotao1(), 2);
				adicionarAcaoButton(botoes.getBotao2(), 2);
				texto.trocarTexto(adicionarTexto(1));
				imagem.mudarImagem("/Imagens/Pagina_1.png");
				break;
				
			case 2:
				adicionarButton(1);
				adicionarTextoButton("Leste", "Oeste");
				adicionarAcaoButton(botoes.getBotao1(), 1);
				adicionarAcaoButton(botoes.getBotao2(), 1);
				texto.trocarTexto(adicionarTexto(2));
				imagem.mudarImagem("/Imagens/Pagina_2.png");
				break;
				
				
		}
	}
	
	public void adicionarAcaoButton(Button botao, int numero) {
		
		botao.setOnAction(e -> {
			
			//pagina(numero);
			rolarDadoHeroi();
			
		});
		
		
	}
	
	public String adicionarTexto(int numero) {
		
		String texto = "";
		
		switch(numero) {
		
			case 1:
				texto = "teste de texto 1";
				break;
				
			case 2:
				texto = "teste de texto 2";
				break;
		}
		
		return texto;
	}
	
	public void rolarDadoHeroi() {
		
		int forca = dadoAzul.rolarDado();
		
	}

}
