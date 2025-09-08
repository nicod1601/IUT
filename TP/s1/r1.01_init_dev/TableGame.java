import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TableGame extends JFrame {
    private static final int ROWS = 8; // Nombre de lignes
    private static final int COLS = 8; // Nombre de colonnes
    private static final int CELL_SIZE = 60; // Taille des cellules
    private int[][] table = new int[ROWS][COLS]; // Tableau pour stocker l'état des cellules
    private int playerRow = 0, playerCol = 0; // Position initiale du joueur
    private int score = 0; // Score du joueur

    public TableGame()
    {
        setTitle("Table Game");
        setSize(COLS * CELL_SIZE + 50, ROWS * CELL_SIZE + 70);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        generateTable();
        addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyPressed(KeyEvent e) 
            {
                movePlayer(e.getKeyCode());
            }
        });
    }

    private void generateTable() 
    {

        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                if (Math.random() * 1 == 1)
                {
                    table[i][j] = 2; // Obstacle
                } 
                else 
                {
                    table[i][j] = 0; // Case vide
                }
            }
        }

        // S'assurer que la position initiale et finale sont vides
        table[playerRow][playerCol] = 0;
        table[ROWS - 1][COLS - 1] = 0;
    }

    private void movePlayer(int keyCode)
    {
        int newRow = playerRow;
        int newCol = playerCol;

        // Déplacement selon la touche
        switch (keyCode)
        {
            case KeyEvent.VK_UP -> newRow--;
            case KeyEvent.VK_DOWN -> newRow++;
            case KeyEvent.VK_LEFT -> newCol--;
            case KeyEvent.VK_RIGHT -> newCol++;
        }

        // Vérifier les limites
        if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS)
        {
            playerRow = newRow;
            playerCol = newCol;

            // Interactions avec la cellule
            if (table[playerRow][playerCol] == 1) {
                score += 10; // Ramasser des points
                JOptionPane.showMessageDialog(this, "Vous avez ramassé des points !");
            } else if (table[playerRow][playerCol] == 2) {
                score -= 5; // Toucher un obstacle
                JOptionPane.showMessageDialog(this, "Oups ! Vous avez touché un obstacle !");
            }

            // Effacer la cellule après interaction
            table[playerRow][playerCol] = 0;

            // Vérifier la fin du jeu
            if (playerRow == ROWS - 1 && playerCol == COLS - 1) {
                JOptionPane.showMessageDialog(this, "Bravo ! Vous avez terminé avec un score de : " + score);
                resetGame();
            }

            repaint();
        }
    }

    private void resetGame() {
        score = 0;
        playerRow = 0;
        playerCol = 0;
        generateTable();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int x = j * CELL_SIZE + 20;
                int y = i * CELL_SIZE + 50;

                // Couleur de la cellule
                if (table[i][j] == 1) {
                    g.setColor(Color.YELLOW); // Points
                } else if (table[i][j] == 2) {
                    g.setColor(Color.RED); // Obstacle
                } else {
                    g.setColor(Color.WHITE); // Vide
                }
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);

                // Dessiner le joueur
                if (i == playerRow && j == playerCol) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x + 10, y + 10, CELL_SIZE - 20, CELL_SIZE - 20);
                }
            }
        }

        // Afficher le score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 20, 40);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TableGame game = new TableGame();
            game.setVisible(true);
        });
    }
}
