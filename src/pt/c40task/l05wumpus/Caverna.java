package pt.c40task.l05wumpus;

public class Caverna {
	private int nBuracos, nWumpus, nOuro, nHeroi;
	private Sala[][] caverna;
	private Heroi heroi;
	//matriz pronta com todos os elementos da caverna 
	private char[][] matriz = {{'-', '-', '-', '-'}, 
							   {'-', '-', '-', '-'},
							   {'-', '-', '-', '-'},
							   {'-', '-', '-', '-'}};
	
	
	public Caverna () {
		caverna = new Sala[4][4];
		nBuracos = nWumpus = nOuro = nHeroi = 0;
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				caverna[i][j] = new Sala(i, j);
	}
	
	public void conectaComponenteSala(int x, int y, Componente componente) {
		char tipo = componente.getTipo();
		if(tipo == 'P' && x == 1 && y == 1) {//ao inves de varios if da pra criar um metodo pra cada
			if (nHeroi == 0)
			caverna[x][y].conectaHeroi(componente);
			nHeroi ++;
		}
		else if(tipo == 'B') {
			caverna[x][y].conectaBuraco(componente);
			nBuracos++;
		}
		else if(tipo == 'f')
			caverna[x][y].conectaFedor(componente);
		else if(tipo == 'W') {
			caverna[x][y].conectaWumpus(componente);
			nWumpus++;
		}
		else if(tipo == 'b')
			caverna[x][y].conectaBrisa(componente);
		else if(tipo == 'O') {
			caverna[x][y].conectaOuro(componente);
			nOuro++;
		}
	}
	
	public boolean cavernaValida() {
		if ((nBuracos == 2 || nBuracos == 3) && nWumpus == 1 && nOuro == 1 && nHeroi == 1)
			return true;
		return false;
	}
	
	public boolean ehValida(int x, int y) {
		//checa se eh uma posição valida da caverna
		if (x < 4 && x > -1 && y < 4 && y > -1)
			return true;
		return false;
	}

	
	public void alteraMatriz(int i, int j, char tipo) {
			matriz[i][j] = tipo;
	}
	
	public char[][] getMatriz() {
		return matriz;
	}
	
}
