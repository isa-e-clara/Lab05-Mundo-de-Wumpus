package pt.c40task.l05wumpus;

public class Heroi extends Componente {
	private boolean flecha;
	private boolean vivo;
	
	public Heroi() {
		flecha = true;
	}
	public boolean getFlecha() {
		return flecha;
	}
	public void atirou() {
		flecha = false;
	}
	public boolean getVivo() {
		return vivo;
	}
	public void morreu() {
		vivo = false;
	}
	
}
