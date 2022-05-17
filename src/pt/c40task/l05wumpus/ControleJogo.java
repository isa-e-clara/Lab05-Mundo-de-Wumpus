package pt.c40task.l05wumpus;

public class ControleJogo {
	private Componente heroi;
	private int pontuacao = 0;
	private String player;
	private char status;
	//matriz que vai sendo revelada de acordo com a movimentação do heroi
	private char[][] tabuleiro = {{'p', '-', '-', '-'}, 
			   				      {'-', '-', '-', '-'},
			   				      {'-', '-', '-', '-'},
			   				      {'-', '-', '-', '-'}};
	
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
            novoX++;
        else if(move == 'a')
            novoX--;
        else if(move == 'w')
            novoY--;
        else //(move == 's')
            novoY++;
        
        if(heroi.getCaverna().ehValida(novoX, novoY)) {
        	heroi.getCaverna().moverHeroi();
        	pontuacao -= 15; //- 15 pontos para cada movimento do herói na caverna;
        }
	}
	
	public void acao(char letra) {
		if(letra == 'd' || letra == 'a' || letra == 'w' || letra == 's')
			mover(letra);
		else if(letra == 'k') //o heroi equipa a flecha
			heroi.getCaverna().equipar();
		else if(letra == 'c') //o heroi captura o ouro
			heroi.getCaverna().capturarOuro(heroi.getX(), heroi.getY());
		//else if(letra == 'q') //o usuario sai do jogo  -> colocar essa parte no AppWumpus.java
			//tk.writeBoard(tabuleiro, pontuacao, "Volte sempre!");  
	}
}
