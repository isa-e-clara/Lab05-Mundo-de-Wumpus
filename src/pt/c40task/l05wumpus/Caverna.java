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
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				caverna[i][j] = new Sala(i, j);
	}
	
	public void conectaComponenteSala(int x, int y, Componente componente) {
		char tipo = componente.getTipo();
		if(tipo == 'P') //ao inves de varios if da pra criar um metodo pra cada
			caverna[y][x].conectaHeroi(componente);
		else if(tipo == 'B')
			caverna[y][x].conectaBuraco(componente);
		else if(tipo == 'f')
			caverna[y][x].conectaFedor(componente);
		else if(tipo == 'W')
			caverna[y][x].conectaWumpus(componente);
		else if(tipo == 'b')
			caverna[y][x].conectaBrisa(componente);
		else
			caverna[y][x].conectaOuro(componente);
	}
	
	public boolean ehValida(int x, int y) {
		//checa se eh uma posição valida da caverna
		if (x < 5 && x > 0 && y < 5 && y > 0)
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
