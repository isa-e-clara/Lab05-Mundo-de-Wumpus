package pt.c40task.l05wumpus;

public class Sala {
	private Componente heroi, fedor, brisa, wumpus, buraco, ouro;
	private int x, y;
	
	public Sala(int x, int y) {
		this.x = x;
		this.y = y;
		this.heroi = null;
		this.fedor = null;
		this.brisa = null;
		this.wumpus = null;
		this.buraco = null;
		this.ouro = null;	
	}
	
	public char prioridade() {
		if (buraco != null)
			return 'B';
		else if (wumpus != null)
			return 'W';
		else if (ouro != null) 
			return 'O';
		else if (heroi != null)
			return 'P';
		else if (fedor != null)
			return 'f';
		else if (brisa != null)
			return 'b';
		else
			return '#';
	}
	
	public Componente getFedor() {
		return fedor;
	}

	public Componente getBrisa() {
		return brisa;
	}

	public void setFedor(Componente fedor) {
		this.fedor = fedor;
	}

	public void setWumpus(Componente wumpus) {
		this.wumpus = wumpus;
	}

	public Componente getWumpus() {
		return wumpus;
	}

	public Componente getBuraco() {
		return buraco;
	}

	public Componente getOuro() {
		return ouro;
	}

	public void setOuro(Componente ouro) {
		this.ouro = ouro;
	}

	public void conectaHeroi(Componente heroi) {
        this.heroi = heroi;
    }
	
	public Componente getHeroi() {
		return heroi;
	}
	
	public void setHeroi(Componente heroi) {
		this.heroi = heroi;
	}
	
	public void conectaFedor(Componente fedor) {
        this.fedor = fedor;
    }
	
	public void conectaBrisa(Componente brisa) {
        this.brisa = brisa;
    }
	
	public void conectaWumpus(Componente wumpus) {
        this.wumpus = wumpus;
    }
	
	public void conectaBuraco(Componente buraco) {
        this.buraco = buraco;
    }
	
	public void conectaOuro(Componente ouro) {
        this.ouro = ouro;
    }

	
}
