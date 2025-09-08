import java.awt.*;
import javax.swing.*;

public class PanelID extends JPanel
{
    private JTextField txtNom;
    private JTextField txtPrenom;

    JPanel panelSexe;
    private JRadioButton homme;
    private JRadioButton femme;
    private JRadioButton autre;
    private ButtonGroup groupe;

    JPanel panelBouton;
    private JButton btnValider;
    private JButton btnQuitter;


    public PanelID()
    {
        this.setLayout(new GridLayout(4,1));
        this.setBackground(new Color(30, 30, 30));
        /*--------------------------*/
        /* Création des composants  */
        /*--------------------------*/
        JLabel lblNom    = new JLabel("nom :"    , JLabel.RIGHT);
        JLabel lblPrenom = new JLabel("prénom :" , JLabel.RIGHT);
        JLabel lblSexe   = new JLabel("sexe :"   , JLabel.RIGHT);

        this.styleLabel(lblNom);
        this.styleLabel(lblPrenom);
        this.styleLabel(lblSexe);

        this.txtNom    = new JTextField(10);
        this.txtPrenom = new JTextField(10);

        this.styleTextField(txtNom);
        this.styleTextField(txtPrenom);

        this.panelSexe = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.panelSexe.setBackground(new Color(40, 40, 40));
        this.homme     = new JRadioButton("homme");
        this.femme     = new JRadioButton("femme");
        this.autre     = new JRadioButton("autre");
        this.groupe    = new ButtonGroup();

        this.styleRadioButton(homme);
        this.styleRadioButton(femme);
        this.styleRadioButton(autre);

        panelBouton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBouton.setBackground(new Color(30, 30, 30));
        this.btnValider = new JButton("Valider");
        this.btnQuitter = new JButton("Quitter");

        this.styleButton(btnValider);
        this.styleButton(btnQuitter);



        /*---------------------------*/
        /*   Position des composants */
        /*---------------------------*/
        panelBouton.add(btnQuitter);
        panelBouton.add(btnValider);
        

        this.groupe.add(homme);
        this.groupe.add(femme);
        this.groupe.add(autre);

        panelSexe.add(homme);
        panelSexe.add(femme);
        panelSexe.add(autre);

        this.add(lblNom);
        this.add(txtNom);
        this.add(lblPrenom);
        this.add(txtPrenom);
        this.add(lblSexe);
        this.add(panelSexe);
        this.add(new JLabel());
        this.add(panelBouton);


    }


    private void styleLabel(JLabel label) 
    {
        label.setForeground(Color.YELLOW);
        label.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private void styleTextField(JTextField field)
    {
        field.setBackground(new Color(50, 50, 50));
        field.setForeground(Color.WHITE);
        field.setCaretColor(Color.YELLOW);
        field.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
    }

    private void styleRadioButton(JRadioButton radio)
    {
        radio.setBackground(new Color(50, 50, 50));
        radio.setForeground(Color.YELLOW);
        radio.setFocusPainted(false);
        radio.setFont(new Font("Arial", Font.BOLD, 12));
        radio.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
        radio.setOpaque(true);
    }

    private void styleButton(JButton button)
    {
        button.setBackground(new Color(70, 70, 70));
        button.setForeground(Color.YELLOW);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
        button.setFocusPainted(false);
    }
        
}
