package pt.c40task.l05wumpus;

public class ControleJogo {
	private Componente heroi;
	private int pontuacao;
	private String player;
	private char status;
	
	public ControleJogo(String player) {
		this.player = player;
		pontuacao = 0;
		status = 'x';
	}
	
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
	
	public void imprime(String player) {
		char[][] matriz = heroi.getCaverna().getMatriz();
		for (int i=0; i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++)
				System.out.printf("%c ", matriz[i][j]);
			System.out.println();
		}
		
		System.out.println("Player: " + player);
		System.out.println("Score: " + String.valueOf(pontuacao));
		if (status == 'w')
			System.out.println("Parabens! Voce ganhou :)");
		else if (status == 'n')
			System.out.println("Ops... Nao foi dessa vez. Voce perdeu :(");
		else if (status == 'q')
			System.out.println("Volte sempre!");
		else 
			System.out.println("Continue em frente!");
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
    		
    		int pontuacaoTemporaria = heroi.getCaverna().moverHeroi(antigoX, antigoY ,novoX, novoY);
    		// prestar atencao nas pontuacoes
    		if (pontuacaoTemporaria == 975)
    			status = 'w';
    		else if (pontuacaoTemporaria == -1015 || pontuacaoTemporaria == -1115) {
    			status = 'n';
    			heroi.setExiste();
    		}
        	pontuacao += pontuacaoTemporaria;
        	
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



