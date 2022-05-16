package pt.c40task.l05wumpus;

public class ControleJogo {
	private int pontuacao = 0;
	private Caverna caverna;
	private String player;
	private char status;
	//matriz que vai sendo revelada de acordo com a movimentação do heroi
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
		//tenho q fazer essa funcao ainda kk kk k kk k  HELP
	}
}
