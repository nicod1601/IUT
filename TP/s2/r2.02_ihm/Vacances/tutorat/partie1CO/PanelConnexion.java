package partie1CO;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class PanelConnexion extends JPanel
{
    private JTextField txtNom;
    private JTextField txtPrenom;
    private JButton btnValider;
    private JButton btnEteindre;
    
    private JPanel panelSexe;
    private JRadioButton rbFemme;
    private JRadioButton rbHomme;
    private JRadioButton rbAucun;
    private ButtonGroup groupeSexe;

    private FrameConnexion frameCo;

    public PanelConnexion(FrameConnexion frameCo)
    {
        this.setLayout(new GridLayout(4,2));
        this.frameCo = frameCo;

        this.setBackground(Color.LIGHT_GRAY);
        /*--------------------------*/
        /*  Création des composants */
        /*--------------------------*/
        this.txtNom    = new JTextField(10);
        this.txtPrenom = new JTextField(10);

        this.panelSexe = new JPanel();
        this.panelSexe.setBackground(Color.LIGHT_GRAY);

        this.groupeSexe = new ButtonGroup();
        this.rbFemme = new JRadioButton("Femme");
        this.rbFemme.setOpaque(false);
        this.rbHomme = new JRadioButton("Homme");
        this.rbHomme.setOpaque(false);
        this.rbAucun = new JRadioButton("Aucun");
        this.rbAucun.setOpaque(false);
        this.rbAucun.setSelected(true);

        this.groupeSexe.add(this.rbFemme);
        this.groupeSexe.add(this.rbHomme);
        this.groupeSexe.add(this.rbAucun);

        this.btnValider = new JButton("Valider");
        this.btnValider.setBackground(Color.GREEN);
        //this.btnValider.setEnabled(false);

        this.btnEteindre = new JButton("Eteindre");
        this.btnEteindre.setBackground(Color.RED);

        /*--------------------------------*/
        /*  Positionnement des composants */
        /*--------------------------------*/
        this.panelSexe.add(this.rbFemme);
        this.panelSexe.add(this.rbHomme);
        this.panelSexe.add(this.rbAucun);


        this.add(new JLabel("Nom", JLabel.CENTER));
        this.add(this.txtNom);

        this.add(new JLabel("Prénom", JLabel.CENTER));
        this.add(this.txtPrenom);

        this.add(new JLabel("Sexe", JLabel.CENTER));
        this.add(this.panelSexe);

        this.add(this.btnEteindre);
        this.add(this.btnValider);
    }

}
