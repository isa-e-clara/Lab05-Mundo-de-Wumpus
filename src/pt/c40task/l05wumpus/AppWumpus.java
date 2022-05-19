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
      
      ControleJogo controle = new ControleJogo(); 
      MontaCaverna montador = new MontaCaverna(cave);
      montador.montar();
      
      if(montador.estaValido()) {
	      controle.conectaHeroi(montador.getCaverna().getSala(0, 0).getHeroi());
	 
	      //String movements = ""; 
	      String movements = tk.retrieveMovements(); //comentar essa linha e descomentar a anterior para jogar interativo
	    
	     if (movements == "") { //modo interativo
		      System.out.println("Digite o nome do jogador: "); //o jogador digita o nome
		      Scanner jogador = new Scanner(System.in);
		      String player =  jogador.nextLine();	
		      controle.setPlayer(player);  
		      
		      //quadro inicial é impresso
		      controle.imprime(); 
		      tk.writeBoard(controle.getHeroi().getCaverna().getMatriz(), controle.getPontuacao(), controle.getStatus());
		      System.out.println("------------------------------------");
		      
		      //comando é lido
		      System.out.println("Digite o comando: ");
		      Scanner entrada = new Scanner(System.in);
		      char comando;
		      comando = entrada.next().charAt(0);
		      
		      while(controle.getStatus()== 'P') { //playing
    			  controle.acao(comando);
    			  controle.imprime();
    			  tk.writeBoard(controle.getHeroi().getCaverna().getMatriz(), controle.getPontuacao(), controle.getStatus());
	    		  System.out.println("------------------------------------");
	    		  
	    		  if(controle.getStatus()== 'P') {
	    			  System.out.println("Digite o comando: ");
	    			  entrada = new Scanner(System.in);
	    			  comando = entrada.next().charAt(0);
	    		  }
		      }
		    	  
	      
	     } else { //lendo do movements.csv
	    	  controle.setPlayer("Alcebiades"); 
	    	  
	    	  //quadro inicial é impresso
	    	  controle.imprime(); 
    		  System.out.println("------------------------------------");
    		  tk.writeBoard(controle.getHeroi().getCaverna().getMatriz(), controle.getPontuacao(), controle.getStatus());
		      
    		  for(int i = 0; i < movements.length(); i++) {
		    	  if(controle.getStatus() == 'P') { //playing
		    		  controle.acao(movements.charAt(i));
		    		  controle.imprime();
		    		  System.out.println("------------------------------------");
		    		  tk.writeBoard(controle.getHeroi().getCaverna().getMatriz(), controle.getPontuacao(), controle.getStatus());
		    	  } else //ganhou, perdeu ou desistiu
		    		  break;
		      }
	      } 
	      
	      
      } 
      
      else
		  System.out.println("Caverna invalida!"); //caverna com menos de dois buracos ou mais de tres ou com mais de um wumpus, heroi ou ouro
      
      tk.stop();
   }

} 

