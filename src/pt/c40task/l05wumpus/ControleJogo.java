package pt.c40task.l05wumpus;

public class ControleJogo {
	private int pontuacao = 0;
	private Caverna caverna;
	private String player;
	private char status;
	
	private char[][] tabuleiro = {{'p', '-', '-', '-'}, 
			   				      {'-', '-', '-', '-'},
			   				      {'-', '-', '-', '-'},
			   				      {'-', '-', '-', '-'}};
	
	public void conecta(Caverna caverna) {
		this.caverna = caverna;
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
	
	//move para a posicao x, y
	public void move(int x, int y, int xAnt, int yAnt) {
		if (caverna.ehValida(x, y)) {
			//adicionar hierarquia de aparicao de componentes
			tabuleiro[x-1][y-1] = (caverna.getMatriz())[x-1][y-1];
		}
		//adicionar hashtag se ja foi visitado e nao tem nenhum componente lá
		//if ()
	}
}
