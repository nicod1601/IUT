import javax.swing.*;
import java.awt.*;

public class FrameMenu {
    public static void main(String[] args) {
        // Création de la frame
        JFrame frame = new JFrame("Frame Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création de la barre d'outils
        JToolBar toolBar = new JToolBar();

        // Ajout de boutons à la barre d'outils
        JButton button1 = new JButton("Nouveau");
        toolBar.add(button1);

        JButton button2 = new JButton("Ouvrir");
        toolBar.add(button2);

        JButton button3 = new JButton("Enregistrer");
        toolBar.add(button3);

        // Ajout de la barre d'outils à la frame
        frame.add(toolBar, BorderLayout.NORTH);

        // Création du menu
        JMenuBar menuBar = new JMenuBar();

        // Ajout de menus au menu bar
        JMenu menuFichier = new JMenu("Fichier");
        menuBar.add(menuFichier);

        JMenuItem menuItemNouveau = new JMenuItem("Nouveau");
        menuFichier.add(menuItemNouveau);

        JMenuItem menuItemOuvrir = new JMenuItem("Ouvrir");
        menuFichier.add(menuItemOuvrir);

        JMenuItem menuItemEnregistrer = new JMenuItem("Enregistrer");
        menuFichier.add(menuItemEnregistrer);

        JMenu menuEdition = new JMenu("Edition");
        menuBar.add(menuEdition);

        JMenuItem menuItemCouper = new JMenuItem("Couper");
        menuEdition.add(menuItemCouper);

        JMenuItem menuItemCopier = new JMenuItem("Copier");
        menuEdition.add(menuItemCopier);

        JMenuItem menuItemColler = new JMenuItem("Coller");
        menuEdition.add(menuItemColler);

        // Ajout du menu bar à la frame
        frame.setJMenuBar(menuBar);

        // Affichage de la frame
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}