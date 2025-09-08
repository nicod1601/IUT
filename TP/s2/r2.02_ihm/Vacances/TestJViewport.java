import javax.swing.*;
import java.awt.*;

public class TestJViewport {
    public static void main(String[] args) {
        // Création de la frame
        JFrame frame = new JFrame("Test JViewport");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création d'un panel pour le contenu de la frame
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Création d'un viewport pour le panel
        JViewport viewport = new JViewport();
        viewport.setView(panel);

        // Création d'un scrollpane pour le viewport
        JScrollPane scrollPane = new JScrollPane(viewport);

        // Ajout du scrollpane à la frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Création de quelques composants pour le panel
        JLabel label1 = new JLabel("Label 1");
        label1.setPreferredSize(new Dimension(100, 20));
        panel.add(label1, BorderLayout.NORTH);

        JLabel label2 = new JLabel("Label 2");
        label2.setPreferredSize(new Dimension(100, 20));
        panel.add(label2, BorderLayout.CENTER);

        JLabel label3 = new JLabel("Label 3");
        label3.setPreferredSize(new Dimension(100, 20));
        panel.add(label3, BorderLayout.SOUTH);

        // Définition de la taille de la frame
        frame.setSize(400, 300);

        // Affichage de la frame
        frame.setVisible(true);
    }
}