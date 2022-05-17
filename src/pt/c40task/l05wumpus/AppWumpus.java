package pt.c40task.l05wumpus;

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
      controle.conectaHeroi(montador.getCaverna().getSala(0, 0).getHeroi());

      
      String movements = tk.retrieveMovements();
      System.out.println("=== Movimentos");
      System.out.println(movements);
      
      System.out.println("=== Caverna Intermediaria");

      //tk.writeBoard(partialCave, score, status);


      
      tk.stop();
   }

}
