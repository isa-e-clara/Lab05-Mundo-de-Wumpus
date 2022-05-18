package pt.c40task.l05wumpus;

public class ControleJogo {
	private Componente heroi;
	private int pontuacao;
	private String player;
	private char status;
	
	public ControleJogo() {
		pontuacao = 0;
		status = 'P'; //playing
	}
	
    public void conectaHeroi(Componente heroi) {
        this.heroi = heroi;
    }

	public void setPlayer (String player) {
		this.player = player;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	public String getPlayer () {
		return player;
	}
	
	public void setStatus (char status) {
		this.status = status;
	}
	
	public char getStatus () {
		return status;
	}
	
	public Componente getHeroi() {
		return heroi;
	}

	public void imprime() {
		char[][] matriz = heroi.getCaverna().getMatriz();
		for (int i=0; i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++)
				System.out.printf("%c ", matriz[i][j]);
			System.out.println();
		}
		
		System.out.println("Player: " + player);
		System.out.println("Score: " + String.valueOf(pontuacao));
		if(heroi.temArtefato)
			System.out.println("Quantidade de flechas: 1");
		else
			System.out.println("Quantidade de flechas: 0");
		
		if (status == 'W') //win
			System.out.println("Parabens! Voce ganhou :)");
		else if (status == 'L') //loose
			System.out.println("Ops... Nao foi dessa vez. Voce perdeu :(");
		else if (status == 'Q') //quit
			System.out.println("Volte sempre!!!");
		else //playing
			System.out.println("Continue em frente!");
		
		System.out.println();
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
        
        if(heroi.getCaverna().ehValida(novoX, novoY)) { //se for uma posicao valida da caverna
        	int antigoX = heroi.getX(), antigoY = heroi.getY();
        	heroi.getCaverna().getSala(heroi.getX(), heroi.getY()).setHeroi(null); //tirando o heroi da antiga sala
        	
        	heroi.setX(novoX);
    		heroi.setY(novoY);
    		heroi.getCaverna().getSala(heroi.getX(), heroi.getY()).setHeroi(heroi); //colocando o heroi na sala nova
    		
    		int pontuacaoTemporaria = heroi.getCaverna().moverHeroi(antigoX, antigoY ,novoX, novoY); //movendo o heroi e coletando a pontuacao dessa jogada
    		if (pontuacaoTemporaria == 985 || pontuacaoTemporaria == 885) //1000 (saiu da caverna com o ouro) -15 (se movimentou) -100 (usou a flecha)
    			status = 'W'; //ganhou
    		else if (pontuacaoTemporaria == -1015 || pontuacaoTemporaria == -1115) { //-1000 (morreu) -15 (se movimentou) -100 (usou a flecha)
    			status = 'L'; //perdeu
    			heroi.setExiste();
    		}
        	pontuacao += pontuacaoTemporaria; 
        }
	}
	
	public void acao(char letra) {
		if(letra == 'd' || letra == 'a' || letra == 'w' || letra == 's') //o heroi se movimenta
			mover(letra);
		else if(letra == 'k') //o heroi equipa a flecha
			heroi.getCaverna().equipar(heroi.getX(), heroi.getY());
		else if(letra == 'c') //o heroi captura o ouro
			heroi.getCaverna().capturarOuro(heroi.getX(), heroi.getY());
		else if(letra == 'q') //desistiu do jogo
			status = 'Q';
		else
			System.out.println("Esse controle nao eh valido :(");
	}
}



