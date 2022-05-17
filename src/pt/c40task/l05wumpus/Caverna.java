package pt.c40task.l05wumpus;

public class Caverna {
	private int nBuracos, nWumpus, nOuro, nHeroi;
	private boolean estaEquipada, podeSair;
	private Sala[][] salas;
	private int pontuacao = 0;
	//private Heroi heroi;
	//matriz pronta com todos os elementos da caverna 
	//gabarito, tem todas as posições de todos os componentes, menos do 
	private char[][] matriz = {{'-', '-', '-', '-'}, 
							   {'-', '-', '-', '-'},
							   {'-', '-', '-', '-'},
							   {'-', '-', '-', '-'}};
	//matriz que vau sendo revelada a medida que o jogador joga
	private char[][] tabuleiro = {{'P', '-', '-', '-'}, 
			      				  {'-', '-', '-', '-'},
			      				  {'-', '-', '-', '-'},
			      				  {'-', '-', '-', '-'}};
	
	public Sala getSala(int x, int y) {
		return salas[x][y];
	}
	public int getnBuracos() { 
		return nBuracos;
	}

	public void setnBuracos(int nBuracos) {
		this.nBuracos = nBuracos;
	}

	public int getnWumpus() {
		return nWumpus;
	}

	public void setnWumpus(int nWumpus) {
		this.nWumpus = nWumpus;
	}

	public int getnOuro() {
		return nOuro;
	}

	public void setnOuro(int nOuro) {
		this.nOuro = nOuro;
	}

	public int getnHeroi() {
		return nHeroi;
	}

	public void setnHeroi(int nHeroi) {
		this.nHeroi = nHeroi;
	}
	
	
	public Caverna() {
		salas = new Sala[4][4];
		nBuracos = nWumpus = nOuro = nHeroi = 0;
		estaEquipada = false; //inicialmente a flecha nao esta equipada
		podeSair = false; //o heroi so pode sair da caverna se pegar o ouro
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				salas[i][j] = new Sala(i, j);
	}
	
	public boolean getPodeSair() {
		return podeSair;
	}

	public void setPodeSair(boolean podeSair) {
		this.podeSair = podeSair;
	}

	public void equipar(int x, int y) {
		if (salas[x][y].getHeroi().getArtefato()) {
			estaEquipada = true;
			System.out.println("Flecha equipada!");
		}
		else
			System.out.println("Você já usou sua flecha :(");
	}
	
	
	public void conectaComponenteSala(int x, int y, Componente componente) {
		char tipo = componente.getTipo();
		if(tipo == 'P') {//ao inves de varios if da pra criar um metodo pra cada
			salas[x][y].conectaHeroi(componente);
		} else if(tipo == 'B') {
			salas[x][y].conectaBuraco(componente);
		} else if(tipo == 'f') {
			salas[x][y].conectaFedor(componente);
		} else if(tipo == 'W') {
			salas[x][y].conectaWumpus(componente);
		} else if(tipo == 'b') {
			salas[x][y].conectaBrisa(componente);
		} else if(tipo == 'O') {
			salas[x][y].conectaOuro(componente);
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
	
	public void capturarOuro(int x, int y) { //nao acho q faz mt sentido isso estar na caverna, mas n sabia mais onde por kkkkk
		if(salas[x][y].getOuro() != null) {
			podeSair = true; //se coletar o ouro, o heroi pode sair
			salas[x][y].setOuro(null); //o ouro deixa de existir
			salas[x][y].getOuro().existe = false; //o ouro deixa de existir
			matriz[x][y] = '-';
		}	
	}
	
	public void moverHeroi(int antigoX, int antigoY, int novoX, int novoY) {
		char componenteSalaNova = salas[novoX][novoY].prioridade();
		
		pontuacao -= 15; //- 15 pontos para cada movimento do herói na caverna;

		tabuleiro[antigoX][antigoY] = salas[antigoX][antigoY].prioridade();
		//matar o wumpus aqui ou morrer cair no buraco
		if(componenteSalaNova == 'W') {
			
		} else {
			if(estaEquipada) {
				salas[novoX][novoY].getHeroi().usouArtefato();	
				
			}
				
		}
		
		
		//tabuleiro[novoX][novoY] = 
	}
	
}
