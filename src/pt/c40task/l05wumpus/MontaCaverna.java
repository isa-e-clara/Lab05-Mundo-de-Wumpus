package pt.c40task.l05wumpus;

public class MontaCaverna {
	private String[] commands;
	private Caverna caverna;
	int x, y;
	char componente;
	
	public MontaCaverna(String[] commands) {
		this.commands = commands;
		caverna = new Caverna();
		for (int i=0 ; i<commands.length ; i++) {
			x = Integer.parseInt(commands[i].substring(0, 1));
			y = Integer.parseInt(commands[i].substring(2, 3));
			componente = commands[i].charAt(4);
			caverna.monta(x,y,componente);
		}
	}
	public Caverna getCaverna() {
		return caverna;
	}
	
	
}
