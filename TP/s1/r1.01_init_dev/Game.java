import javax.swing.*;

public class Game extends JFrame 
{
   private int score = 0;
   private int temps = 0;
   private int[][] table = new int[3][3];
   public Game() 
   {
       setTitle("Game");
       setSize(800, 600);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }
   private void generateTable() {
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
               table[i][j] = 0; // Case vide
           }
       }
   }
   public static void main(String[] args) 
   {
       SwingUtilities.invokeLater(() -> {
           Game game = new Game();
           game.setVisible(true);
       });
   }
}
