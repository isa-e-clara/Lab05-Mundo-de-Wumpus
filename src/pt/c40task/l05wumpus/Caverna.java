package pt.c40task.l05wumpus;

public class Caverna {
	private Sala[][] caverna;
	private Heroi heroi;
	
	public Caverna () {
		this.caverna = new Sala[4][4];
	}
	
	public boolean ehValida(int x, int y) {
		//checa se eh uma posição valida da caverna
		if (x < 5 && x > 0 && y < 5 && y > 0)
			return true;
		else
			return false;
	}
	
	public void monta(int x, int y, char componente) {
		if (componente == 'P') {
			heroi = new Heroi();
			if (ehValida(x,y))
				caverna[x][y].adiciona(heroi);
		}
		//fazer um if para ver qual é a letra
		//passar para a sala o componente dela (se houver)
		//caverna[x][y].addcomponente
	}
}
