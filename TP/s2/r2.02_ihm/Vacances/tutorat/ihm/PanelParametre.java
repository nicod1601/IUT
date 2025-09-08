package ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelParametre extends JPanel implements ActionListener
{
    private JLabel lblNom;
    private JLabel lblPrenom;
    private JLabel lblSexe;
    private List choixParametre;

    private JPanel panelId;

    private JPanel panelFond;
    private Color[][] tabCoul;
    private JButton[][] tabBouton;

    private FrameAppli frame;

    public PanelParametre(FrameAppli frame)
    {
        this.setLayout(new BorderLayout());
        this.frame = frame;
        /*--------------------------*/
        /*  Création des composants */
        /*--------------------------*/
        this.panelId = new JPanel(new FlowLayout(FlowLayout.LEFT));

        this.lblNom    = new JLabel("");
        this.lblPrenom = new JLabel("");
        this.lblSexe   = new JLabel("");

        /*--------------------*/
        /*Choix des parametre */
        /*--------------------*/
        this.choixParametre = new List();
        this.choixParametre.add("Fond d'écrans");
        this.choixParametre.add("Changer ID");

        /*--------------------*/
        /*Panel Fond d'écrans */
        /*--------------------*/
        this.panelFond = new JPanel(new GridLayout(3,3,5,5));
        this.panelFond.setVisible(false);
        this.tabCoul = new Color[][] { {Color.RED   ,Color.GREEN,Color.BLUE   },
                                       {Color.BLACK ,Color.WHITE,Color.YELLOW },
                                       {Color.ORANGE,Color.BLUE ,Color.MAGENTA} };

        this.tabBouton = new JButton[this.tabCoul.length][this.tabCoul[0].length];

        for(int cpt =0; cpt < this.tabCoul.length; cpt++)
        {
            for(int cpt2 =0; cpt2 < this.tabCoul[cpt].length; cpt2++)
            {
               this.tabBouton[cpt][cpt2] = new JButton("");
               this.tabBouton[cpt][cpt2].setBackground(this.tabCoul[cpt][cpt2]);
               this.tabBouton[cpt][cpt2].setOpaque(true);
            }
            
        }
        

        /*--------------------------------*/
        /*  Positionnement des composants */
        /*--------------------------------*/
        this.panelId.add(this.lblNom);
        this.panelId.add(this.lblPrenom);
        this.panelId.add(this.lblSexe);

        
        for(int cpt =0; cpt < this.tabCoul.length; cpt++)
        {
            for(int cpt2 =0; cpt2 < this.tabCoul[cpt].length; cpt2++)
            {
               this.panelFond.add(this.tabBouton[cpt][cpt2]);
            }
            
        }

        this.add(this.panelId,BorderLayout.NORTH);
        this.add(this.choixParametre,BorderLayout.WEST);
        this.add(this.panelFond,BorderLayout.CENTER);



        /*----------------------------*/
        /*  Activation des composants */ 
        /*----------------------------*/
        this.choixParametre.addActionListener(this);
        
        for(int cpt =0; cpt < this.tabCoul.length; cpt++)
        {
            for(int cpt2 =0; cpt2 < this.tabCoul[cpt].length; cpt2++)
            {
               this.tabBouton[cpt][cpt2].addActionListener(this);
            }
            
        }

        this.setVisible(false);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.choixParametre)
        {
            if(this.choixParametre.getSelectedIndex() == 0)
            {
                System.out.println("Fond d'écrans");
                if(this.panelFond.isVisible() == false)
                {
                    this.panelFond.setVisible(true);
                }
                else
                {
                    this.panelFond.setVisible(false);
                }
            }
            else
            {
                System.out.println("Changer ID");
            }
        }

        for(int cpt =0; cpt < this.tabCoul.length; cpt++)
        {
            for(int cpt2 =0; cpt2 < this.tabCoul[cpt].length; cpt2++)
            {
                if(e.getSource() == this.tabBouton[cpt][cpt2])
                {
                    System.out.println("Couleur : " + this.tabCoul[cpt][cpt2]);
                    this.setBackground(this.tabCoul[cpt][cpt2]);
                }
              
            }
            
        }
    }



    public void setId(String nom, String prenom, String sexe)
    {
        this.lblNom.setText(nom);
        this.lblPrenom.setText(prenom);
        this.lblSexe.setText(sexe);
    }
}
