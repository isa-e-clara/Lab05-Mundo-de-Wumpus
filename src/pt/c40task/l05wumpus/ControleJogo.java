package pt.c40task.l05wumpus;

public class ControleJogo {
	private Componente heroi;
	private int pontuacao = 0;
	private String player;
	private char status;
	//matriz que vai sendo revelada de acordo com a movimentação do heroi
	
	
    public void conectaHeroi(Componente heroi) {
        this.heroi = heroi;
    }
	
	public void setPlayer (String player) {
		this.player = player;
	}
	
	public String getPlayer () {
		return player;
	}
	
	public void setStatus (char status) {
		this.status = status;
	}
	
	public char getstatus () {
		return status;
	}
	
	public void mover(char move) {
		int novoX = heroi.getX(), novoY = heroi.getY();
        if(move == 'd')
            novoY++;
        else if(move == 'a')
            novoY--;
        else if(move == 'w')
            novoX--;
        else //(move == 's')
            novoX++;
        
        if(heroi.getCaverna().ehValida(novoX, novoY)) {
        	int antigoX = heroi.getX(), antigoY = heroi.getY();
        	heroi.getCaverna().getSala(heroi.getX(), heroi.getY()).setHeroi(null);
        	heroi.setX(novoX);
    		heroi.setX(novoY);
    		
    		heroi.getCaverna().getSala(heroi.getX(), heroi.getY()).setHeroi(heroi);
    		
        	heroi.getCaverna().moverHeroi(antigoX, antigoY ,novoX, novoY);;
        	pontuacao -= 15; //- 15 pontos para cada movimento do herói na caverna;
        }
	}
	
	public void acao(char letra) {
		if(letra == 'd' || letra == 'a' || letra == 'w' || letra == 's')
			mover(letra);
		else if(letra == 'k') //o heroi equipa a flecha
			heroi.getCaverna().equipar(heroi.getX(), heroi.getY());
		else if(letra == 'c') //o heroi captura o ouro
			heroi.getCaverna().capturarOuro(heroi.getX(), heroi.getY());
		else
			System.out.println("Esse controle nao eh valido :(");
		//else if(letra == 'q') //o usuario sai do jogo  -> colocar essa parte no AppWumpus.java
			//tk.writeBoard(tabuleiro, pontuacao, "Volte sempre!");  
	}
}
