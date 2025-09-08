import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class TestJSpinnerJTreeJPasswordField {
    public static void main(String[] args) {
        // Création de la frame
        JFrame frame = new JFrame("Test JSpinner, JTree et JPasswordField");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création d'un panel pour le contenu de la frame
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Création d'un JSpinner
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("La valeur du JSpinner est : " + spinner.getValue());
            }
        });
        panel.add(spinner, BorderLayout.NORTH);

        // Création d'un JTree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Racine");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Noeud 1");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Noeud 2");
        DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("Noeud 3");
        root.add(node1);
        root.add(node2);
        root.add(node3);
        JTree tree = new JTree(root);
        panel.add(new JScrollPane(tree), BorderLayout.CENTER);

        // Création d'un JPasswordField
        JPasswordField passwordField = new JPasswordField();
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le mot de passe saisi est : " + new String(passwordField.getPassword()));
            }
        });
        panel.add(passwordField, BorderLayout.SOUTH);

        // Ajout du panel à la frame
        frame.add(panel);

        // Affichage de la frame
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}