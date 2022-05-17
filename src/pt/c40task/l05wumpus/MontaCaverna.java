package pt.c40task.l05wumpus;

public class MontaCaverna {
	private String[] commands;
	private Caverna caverna;
	int x, y;
	char tipo;
	
	public MontaCaverna(String[] commands) {
		this.commands = commands;
		caverna = new Caverna();
	}
	
	public Caverna getCaverna() {
		return caverna;
	}
	
	public void adicionaAoRedor(int x, int y, char tipo) {
		//chamada para wumpus para adicionar o fedor e pelo buraco para adicionar a brisa
		//tenta adicionar nas 4 células adjacentes
		adicionarComponente(x+1, y, tipo);
		adicionarComponente(x-1, y, tipo);
		adicionarComponente(x, y+1, tipo);
		adicionarComponente(x, y-1, tipo);
	}
	
	public void adicionarComponente(int x, int y, char tipo) {
		Componente componente = null;
		if (tipo == 'P') { 
			if(x == 1 && y == 1) { //heroi sempre começa na posição inicial
				componente = new Heroi(x, y);
				caverna.setnHeroi(caverna.getnHeroi() + 1);
			} else 
				System.out.println("Erro: heroi nao esta na posicao inicial!");
		} else if(tipo == 'B') {
			componente = new Buraco(x, y);
			caverna.setnBuracos(caverna.getnBuracos() + 1);
			adicionaAoRedor(x, y, 'b');
		} else if(tipo == 'f') {
			componente = new Fedor(x, y);
		} else if(tipo == 'W') {
			componente = new Wumpus(x, y);
			caverna.setnWumpus(caverna.getnWumpus() + 1);
			adicionaAoRedor(x, y, 'f');
		} else if(tipo == 'b') {
			componente = new Brisa(x, y);
		} else if (tipo == 'O') {
			componente = new Ouro(x, y);
			caverna.setnOuro(caverna.getnOuro() + 1);
		}		
				
		if (caverna.ehValida(x,y)) { 
			//hierarquia das aparições na matriz
			// Ouro = Buraco = Wumpus > Herói > Fedor > Brisa
			if (caverna.getMatriz()[x][y] != 'W' && caverna.getMatriz()[x][y] != 'O' && caverna.getMatriz()[x][y] != 'B') {
				if (tipo == 'P')
					caverna.alteraMatriz(x, y, tipo);
				else if (tipo == 'f' && caverna.getMatriz()[x][y] != 'P')
					caverna.alteraMatriz(x, y, tipo);
				else if (tipo == 'b' && caverna.getMatriz()[x][y] != 'f' && caverna.getMatriz()[x][y] != 'P')
					caverna.alteraMatriz(x, y, tipo);
			}
			
			componente.conectaCaverna(caverna);
			componente.getCaverna().conectaComponenteSala(x, y, componente);
		}
		
	}
	
	public void montar() {
		for (int i=0 ; i < commands.length ; i++) {
			//amiga eu já coloquei aqui o x e y com o valor -1, acho q vai dar bommmm n precisa mudar mais nada  boaaa
			x = Integer.parseInt(commands[i].substring(0, 1))-1;
			y = Integer.parseInt(commands[i].substring(2, 3))-1;
			tipo = commands[i].charAt(4);
			adicionarComponente(x, y, tipo);
		}	
		//checar se caverna é valida
		//depois temos que parar de rodar o código se nao for
		if (caverna.cavernaValida() == false)
			System.out.println("Caverna Inválida");
	}
	
}
