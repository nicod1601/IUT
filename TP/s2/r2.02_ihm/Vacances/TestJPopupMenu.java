import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestJPopupMenu {
    public static void main(String[] args) {
        // Création de la frame principale
        JFrame frame = new JFrame("Test JPopupMenu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création d'un panel pour le contenu de la frame
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Création d'un bouton pour afficher le menu contextuel
        JButton button = new JButton("Cliquez ici pour afficher le menu contextuel");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Création du menu contextuel
                JPopupMenu menu = new JPopupMenu();

                // Création des items du menu
                JMenuItem item1 = new JMenuItem("Item 1");
                item1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Item 1 sélectionné");
                    }
                });
                menu.add(item1);

                JMenuItem item2 = new JMenuItem("Item 2");
                item2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Item 2 sélectionné");
                    }
                });
                menu.add(item2);

                JMenuItem item3 = new JMenuItem("Item 3");
                item3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Item 3 sélectionné");
                    }
                });
                menu.add(item3);

                // Affichage du menu contextuel
                menu.show(button, e.getX(), e.getY());
            }
        });
        panel.add(button);

        // Ajout du panel à la frame principale
        frame.add(panel);

        // Définition de la taille de la frame principale
        frame.setSize(300, 200);

        // Affichage de la frame principale
        frame.setVisible(true);
    }
}