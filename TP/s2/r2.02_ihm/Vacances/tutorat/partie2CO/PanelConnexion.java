package partie2CO;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class PanelConnexion extends JPanel implements ActionListener
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

    private FrameAppli frame;
    private FrameConnexion frameCo;

    public PanelConnexion(FrameAppli frame, FrameConnexion frameCo)
    {
        this.setLayout(new GridLayout(4,2));
        this.frame = frame;
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

        /*----------------------------*/
        /*  Activation des composants */ 
        /*----------------------------*/
        this.txtNom.addActionListener(this);
        this.txtPrenom.addActionListener(this);
        this.btnValider.addActionListener(this);
        this.btnEteindre.addActionListener(this);
    }




    public void actionPerformed(ActionEvent e)
    {
        String nom, prenom, sexe;


        if( (! this.txtNom.getText().equals("") && ! this.txtPrenom.getText().equals("") ) &&( !  this.rbFemme.isSelected() == false || ! this.rbHomme.isSelected() == false || ! this.rbAucun.isSelected() == false ) )
        {
            if(e.getSource() == this.btnValider)
            {
                System.out.println("Nom : "     + this.txtNom.getText()   );
                nom = this.txtNom.getText();
                System.out.println("Prenom : " + this.txtPrenom.getText());
                prenom = this.txtPrenom.getText();
                
                if(this.rbFemme.isSelected() == true)
                {
                    System.out.println("Sexe : " + this.rbFemme.getText());
                    sexe = this.rbFemme.getText();
                }
                else
                {
                    if(this.rbHomme.isSelected() == true)
                    {
                        System.out.println("Sexe : " + this.rbHomme.getText());
                        sexe = this.rbHomme.getText();
                    }
                    else
                    {
                        System.out.println("Sexe : " + this.rbAucun.getText());
                        sexe = this.rbAucun.getText();
                    }
                    
                }

                this.frameCo.setVisible(false);
                this.frame.setVisible(true);
                
                
            }
        }
        if(e.getSource() == this.btnEteindre)
        {
            System.exit(0);
        }
    }

}
