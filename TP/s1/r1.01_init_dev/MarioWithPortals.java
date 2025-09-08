import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class MarioWithPortals extends JPanel implements KeyListener, Runnable {
    private int marioWidth = 20;  // Réduit la largeur de Mario
    private int marioHeight = 25; // Réduit la hauteur de Mario
    private int marioX = 50;
    private int marioY = 300;
    private boolean jumping = false;
    private int jumpVelocity = 0;
    private int gravity = 2;
    private int groundLevel = 300;
    private ArrayList<Rectangle> obstacles = new ArrayList<>();
    private Rectangle portal;
    private int obstacleSpeed = 4;
    private int score = 0;
    private boolean running = true;
    private Random random = new Random();
    private int level = 1;

    public MarioWithPortals() {
        JFrame frame = new JFrame("Mario with Portals");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setResizable(false);
        frame.setVisible(true);

        startLevel(); // Initialiser le premier niveau

        new Thread(this).start(); // Lancer la boucle de jeu
    }

    private void startLevel() {
        // Réinitialiser Mario
        marioX = 50;
        marioY = groundLevel;

        // Réinitialiser les obstacles
        obstacles.clear();
        for (int i = 0; i < 5; i++) {
            obstacles.add(createObstacle(800 + i * 200)); // Espacement initial
        }

        // Créer un portail
        portal = createPortal();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner le fond (change selon le niveau)
        g.setColor(level % 2 == 0 ? Color.LIGHT_GRAY : Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dessiner le sol
        g.setColor(level % 2 == 0 ? Color.DARK_GRAY : Color.GREEN);
        g.fillRect(0, groundLevel + marioHeight, getWidth(), getHeight() - groundLevel);

        // Dessiner Mario
        g.setColor(Color.RED);
        g.fillRect(marioX, marioY, marioWidth, marioHeight);

        // Dessiner les obstacles
        g.setColor(Color.BLACK);
        for (Rectangle obstacle : obstacles) {
            g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
        }

        // Dessiner le portail
        g.setColor(Color.MAGENTA);
        g.fillOval(portal.x, portal.y, portal.width, portal.height);

        // Afficher le score et le niveau
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 30);
        g.drawString("Level: " + level, 20, 60);
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double fps = 60.0; // Cible de 60 images par seconde
        final double ns = 1_000_000_000 / fps;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                updateGame(); // Mettre à jour la logique du jeu
                delta--;
            }

            repaint(); // Redessiner l'écran

            try {
                Thread.sleep(2); // Petite pause pour éviter d'utiliser 100 % du CPU
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateGame() {
        // Déplacement des obstacles
        for (int i = 0; i < obstacles.size(); i++) {
            Rectangle obstacle = obstacles.get(i);
            obstacle.x -= obstacleSpeed;

            // Réinitialiser l'obstacle une fois hors de l'écran
            if (obstacle.x + obstacle.width < 0) {
                obstacles.set(i, createObstacle(getWidth() + random.nextInt(5)));
                score++;
                if (score % 10 == 0) {
                    obstacleSpeed++; // Augmenter la vitesse des obstacles
                }
            }
        }

        // Gestion du saut
        if (jumping) {
            marioY -= jumpVelocity;
            jumpVelocity -= gravity;
            if (marioY >= groundLevel) {
                marioY = groundLevel;
                jumping = false;
                jumpVelocity = 0;
            }
        }

        // Détection de collision avec les obstacles
        for (Rectangle obstacle : obstacles) {
            if (new Rectangle(marioX, marioY, marioWidth, marioHeight).intersects(obstacle)) {
                running = false; // Arrêter le jeu
                JOptionPane.showMessageDialog(this, "Game Over! Score: " + score);
                System.exit(0);
            }
        }

        // Détection d'entrée dans le portail
        if (new Rectangle(marioX, marioY, marioWidth, marioHeight).intersects(portal)) {
            level++;
            JOptionPane.showMessageDialog(this, "Niveau " + level + " atteint !");
            startLevel(); // Passer au niveau suivant
        }
    }

    private Rectangle createObstacle(int startX) {
        int height = 5 + random.nextInt(20); // Hauteur aléatoire entre 30 et 80
        int width = 10 + random.nextInt(5);  // Largeur aléatoire entre 30 et 80
        int y = groundLevel + marioHeight - height;
        return new Rectangle(startX, y, width, height);
    }

    private Rectangle createPortal() {
        int width = 50;
        int height = 100;
        int x = getWidth() - 100; // Position du portail vers la droite de l'écran
        int y = groundLevel - height + marioHeight;
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !jumping) {
            jumping = true;
            jumpVelocity = 18; // Vitesse initiale du saut améliorée
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new MarioWithPortals();
    }
}
