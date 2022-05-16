package pt.c40task.l05wumpus;

public class Componente {
	protected int x, y;
	protected boolean temArtefato, existe;
	protected char tipo; 
	protected Caverna caverna;
	
	public Componente(int x, int y, char tipo) {
		this.x = x;
		this.y = y;
		this.tipo = tipo;
		this.existe = true; //se esta criando um componente é pq ele existe (pelo menos ate o momento)
		if(tipo == 'P') //heroi
			this.temArtefato = true; //o jogo começa com o heroi tendo uma flecha
		else
			this.temArtefato = false;
	}
	
	public Caverna getCaverna() {
		return caverna;
	}

	public void conectaCaverna(Caverna caverna) {
		this.caverna = caverna;
	}

	public char getTipo() {
		return tipo;
	}


	//fazer um get tipo que diz qual componente ele é
	//a classe componente nao precisa ter atributo, so os metodos (que recuperam os atributos)
	//boolean existe para wumpus, heroi e ouro
	//boolean tem artefato para a flecha do heroi 
	
}
