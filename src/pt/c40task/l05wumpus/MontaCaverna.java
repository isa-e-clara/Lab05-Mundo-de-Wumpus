package pt.c40task.l05wumpus;

public class MontaCaverna {
	private String[][] commands;
	private Caverna caverna;
	
	public MontaCaverna(String[][] commands) {
		this.commands = commands;
		caverna = new Caverna();
	}
	
	public Caverna getCaverna() {
		return caverna;
	}
	
	/*Adiciona o fedor nas celulas adjacentes ao Wumpus ou a brisa nas celulas 
	 * adjacentes ao Buraco, apenas se for uma sala possivel  */
	public void adicionaAoRedor(int x, int y, char tipo) {
		adicionarComponente(x+1, y, tipo);
		adicionarComponente(x-1, y, tipo);
		adicionarComponente(x, y+1, tipo);
		adicionarComponente(x, y-1, tipo);
	}
	
	public void adicionarComponente(int x, int y, char tipo) {
		Componente componente = null;
		if(tipo != '_') {
			if (tipo == 'P') { 
				if(x == 0 && y == 0) { //heroi sempre começa na posição inicial
					componente = new Heroi(x, y);
					caverna.setnHeroi(caverna.getnHeroi() + 1);
				} else {
					System.out.println("Erro: heroi nao esta na posicao inicial!");
					System.exit(1);
				}
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
				componente.conectaCaverna(caverna);
				componente.getCaverna().conectaComponenteSala(x, y, componente);
			}
		}
		
	}
	
	public boolean estaValido() {
		return caverna.cavernaValida();
	}
	
	public void montar() {
		char tipo;
		int x, y;
		for (int i=0 ; i < commands.length ; i++) {
			x = Integer.parseInt(commands[i][0]) - 1; //subtraindo 1 para seguir os indices da matriz em java
			y = Integer.parseInt(commands[i][1]) - 1;
			tipo = commands[i][2].charAt(0); 
			adicionarComponente(x, y, tipo);
		}	
	}
	
}
