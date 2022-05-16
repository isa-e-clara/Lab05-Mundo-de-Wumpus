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
	
	public void adicionarComponente(int x, int y, char tipo) {
		Componente componente = null;
		if (tipo == 'P') 
			componente = new Heroi(x, y);
		else if(tipo == 'B')
			componente = new Buraco(x, y);
		else if(tipo == 'f')
			componente = new Fedor(x, y);
		else if(tipo == 'W')
			componente = new Wumpus(x, y);
		else if(tipo == 'b')
			componente = new Brisa(x, y);
		else
			componente = new Ouro(x, y);
				
				
		if (caverna.ehValida(x,y) && x == 1 && y == 1) { //nao entendi esse && x == 1 && y == 1
			caverna.alteraMatriz(x-1, y-1, tipo);
			componente.conectaCaverna(caverna);
			componente.getCaverna().conectaComponenteSala(x, y, componente);
		}
		
		//Os Componentes primários (buraco e wumpus) que possuem componentes secundários associados a eles (brisa e fedor), são responsáveis por criar objetos referentes a esses componentes
		
		//contar quantos wumpus, buracos e ouros aparecem e ver se esta dentro do pedido. Isso n fica melhor no montaCaverna?
		//adicionar fedor e brisa tbm
		//fazer um if para ver qual é a letra
		//passar para a sala o componente dela (se houver) -> fiz a função conectaComponenteSala, ajuda nisso
	}
	
	public void montar() {
		for (int i=0 ; i<commands.length ; i++) {
			x = Integer.parseInt(commands[i].substring(0, 1));
			y = Integer.parseInt(commands[i].substring(2, 3));
			tipo = commands[i].charAt(4);
			adicionarComponente(x, y, tipo);
		}	
	}
	
}
