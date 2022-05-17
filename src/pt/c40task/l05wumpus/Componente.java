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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void conectaCaverna(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public void usouArtefato() {
		temArtefato = false;
	}
	
	public boolean getArtefato() {
		return temArtefato;
	}
	
	public void setExiste() {
		existe = false;
	}
	
	public boolean getExiste() {
		return existe;
	}

	public char getTipo() {
		return tipo;
	}
	
	//a classe componente nao precisa ter atributo, so os metodos (que recuperam os atributos)
	
}
