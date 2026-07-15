package Controller;

import Model.Heroi;
import Model.Tela_Status;

public class Controller_Tela {
	
	private Tela_Status status;
	
	
	public Controller_Tela(Heroi heroi) {
		
		this.status = new Tela_Status(heroi);
	}
	
	public Tela_Status getStatus() {
		return status;
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

}
