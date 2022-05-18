package pt.c40task.l05wumpus;
import java.util.Scanner;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      String cave[][] = tk.retrieveCave();
      
      ControleJogo controle = new ControleJogo("Alcebiades");
      MontaCaverna montador = new MontaCaverna(cave);
      montador.montar();
      if(montador.estaValido()) {
	      controle.conectaHeroi(montador.getCaverna().getSala(0, 0).getHeroi());
	 
	      //String movements = ""; //descomentar essa linha e comentar a próxima para jogar interativo
	      String movements = tk.retrieveMovements();
	    
	     System.out.println(movements);
	     if (movements == "") { //modo interativo
		      System.out.println("Digite o nome do jogador: "); //o jogador digita o nome
		      Scanner jogador = new Scanner(System.in);
		      String player =  jogador.nextLine();	
		      controle.setPlayer(player);  
		      
		      controle.imprime(); //quadro inicial é impresso
		      tk.writeBoard(controle.getHeroi().getCaverna().getMatriz(), controle.getPontuacao(), controle.getStatus());
		      System.out.println("------------------------------------");
		      
		      //comando é lido
		      Scanner entrada = new Scanner(System.in);
		      char comando;
		      comando = entrada.next().charAt(0);
		   
		      while (controle.getStatus()=='x') { 
		    	  if(comando!='q') { //talvez alterar o status? ns se precisa mas acho melhor
		    		  controle.acao(comando);
		    		  controle.imprime();
		    		  tk.writeBoard(controle.getHeroi().getCaverna().getMatriz(), controle.getPontuacao(), controle.getStatus());
		    		  System.out.println("------------------------------------");
		    		  if (controle.getStatus()=='x') {
			    		  entrada = new Scanner(System.in);
			    		  comando = entrada.next().charAt(0);
		    		  }
		    	  }
		    	  else { //quitou o jogo
		    		  controle.imprime();
		    		  tk.writeBoard(controle.getHeroi().getCaverna().getMatriz(), controle.getPontuacao(), controle.getStatus());
		    		  System.out.println("Volte sempre!!!");
		    		  System.out.println("------------------------------------");
		    		  break;
		    	  }
		      }
	      }
	      
	      else { //lendo do movements.csv
	    	  controle.imprime();
		      tk.writeBoard(controle.getHeroi().getCaverna().getMatriz(), controle.getPontuacao(), controle.getStatus());
		      System.out.println("------------------------------------");
		      for(int i = 0; i < movements.length(); i++) {
		    	  if(controle.getStatus() == 'x') {
		    		  controle.acao(movements.charAt(i));
		    		  controle.imprime();
		    		  System.out.println("------------------------------------");
		    		  tk.writeBoard(controle.getHeroi().getCaverna().getMatriz(), controle.getPontuacao(), controle.getStatus());
		    	  } else //se ganhou, perdeu ou desistiu
		    		  break;
		      }
	      } 
	      
	      
      }
      
      else
		  System.out.println("Caverna invalida!");
      
      tk.stop();
   }

}

