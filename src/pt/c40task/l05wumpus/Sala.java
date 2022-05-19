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
	
	//informa qual a letra que deve ser impressa na matriz de acordo com a prioridade de aparição dos componentes
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
		if(ouro == null && buraco == null)
			this.wumpus = wumpus;
		else {
			System.out.println("Nao se pode adicionar esse componente nessa sala!");
			System.exit(1);
		}
    }
	
	public void conectaBuraco(Componente buraco) {
		if(ouro == null && wumpus == null)
			this.buraco = buraco;
		else {
			System.out.println("Nao se pode adicionar esse componente nessa sala!");
			System.exit(1);
		}
    }
	
	public void conectaOuro(Componente ouro) {
		if(buraco == null && wumpus == null)
			this.ouro = ouro;
        else {
        	System.out.println("Nao se pode adicionar esse componente nessa sala!");
        	System.exit(1);
        }
    }
	
}
