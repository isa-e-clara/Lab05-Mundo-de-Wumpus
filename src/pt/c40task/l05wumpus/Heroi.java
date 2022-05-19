package pt.c40task.l05wumpus;

public class Heroi extends Componente {
	
	public Heroi(int x, int y) {
		super(x, y, 'P');
		super.temArtefato = true;
	}
	//só o heroi usa/tem artefato
	public void usouArtefato() {
		temArtefato = false;
	}

}
