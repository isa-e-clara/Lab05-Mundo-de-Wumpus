package pt.c40task.l05wumpus;

public class Caverna {
	private int nBuracos, nWumpus, nOuro, nHeroi;
	private Sala[][] caverna;
	private Heroi heroi;
	//matriz que vai sendo revelada a medida que o 
	private char[][] matriz = {{'-', '-', '-', '-'}, 
							   {'-', '-', '-', '-'},
							   {'-', '-', '-', '-'},
							   {'-', '-', '-', '-'}};
	
	
	public Caverna () {
		this.caverna = new Sala[4][4];
	}
	
	public boolean ehValida(int x, int y) {
		//checa se eh uma posição valida da caverna
		if (x < 5 && x > 0 && y < 5 && y > 0)
			return true;
		return false;
	}
	
	public void monta(int x, int y, char componente) {
		if (componente == 'P') {
			heroi = new Heroi();
			if (ehValida(x,y) && x == 1 && y == 1)
				matriz[x-1][y-1] = componente;
				caverna[x-1][y-1].adiciona(heroi);
		}
		//contar quantos wumpus, buracos e ouros aparecem e ver se esta dentro do pedido
		//adicionar fedor e brisa tbm
		//fazer um if para ver qual é a letra
		//passar para a sala o componente dela (se houver)
		//caverna[x][y].addcomponente
	}
	
	public char[][] getMatriz() {
		return matriz;
	}
	
}
