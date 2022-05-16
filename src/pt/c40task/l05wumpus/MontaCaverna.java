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
		adicionarComponente (x+1, y, tipo);
		adicionarComponente (x-1, y, tipo);
		adicionarComponente (x, y+1, tipo);
		adicionarComponente (x, y-1, tipo);
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
		else if (tipo == 'O')
			componente = new Ouro(x, y);
				
				
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
			if (tipo == 'W') 
				adicionaAoRedor(x, y, 'f');
		
			else if (tipo == 'B')
				adicionaAoRedor(x, y, 'b');
		}
		
		
		//contar quantos wumpus, buracos e ouros aparecem e ver se esta dentro do pedido. Isso n fica melhor no montaCaverna?
		//fiz aqui mesmo e conferi la no final (na 1 função q vai rodar), ve se concorda
		
		//passar para a sala o componente dela (se houver) -> fiz a função conectaComponenteSala, ajuda nisso
		//braba!!!!!!!!
	}
	
	public void montar() {
		for (int i=0 ; i<commands.length ; i++) {
			//amiga eu já coloquei aqui o x e y com o valor -1, acho q vai dar bommmm n precisa mudar mais nada
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
