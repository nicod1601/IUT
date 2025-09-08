import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestJDialog {
    public static void main(String[] args) {
        // Création de la frame principale
        JFrame frame = new JFrame("Test JDialog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création d'un bouton pour afficher le dialogue
        JButton button = new JButton("Afficher le dialogue");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Création du dialogue
                JDialog dialog = new JDialog(frame, "Dialogue", true);

                // Création d'un panel pour le contenu du dialogue
                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout());

                // Création d'un label et d'un champ de texte pour demander le nom de l'utilisateur
                JLabel label = new JLabel("Entrez votre nom :");
                JTextField textField = new JTextField(20);
                panel.add(label);
                panel.add(textField);

                // Création d'un bouton pour valider le dialogue
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Récupération du nom de l'utilisateur
                        String name = textField.getText();

                        // Affichage d'un message de bienvenue
                        JOptionPane.showMessageDialog(frame, "Bonjour, " + name + " !");

                        // Fermeture du dialogue
                        dialog.dispose();
                    }
                });
                panel.add(okButton);

                // Ajout du panel au dialogue
                dialog.add(panel);

                // Définition de la taille du dialogue
                dialog.setSize(300, 150);

                // Affichage du dialogue
                dialog.setVisible(true);
            }
        });

        // Ajout du bouton à la frame principale
        frame.add(button);

        // Définition de la taille de la frame principale
        frame.setSize(200, 100);

        // Affichage de la frame principale
        frame.setVisible(true);
    }
}