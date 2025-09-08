package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class PanelAppli extends JPanel implements ActionListener
{
    private JPanel  panelMenu;
    private JButton btnDeconnexion;
    private JButton btnParametres;


    private FrameAppli frame;
    private FrameConnexion frameCo;
    private PanelParametre panelParametre;

    public PanelAppli(FrameAppli frame, FrameConnexion frameCo, PanelParametre panelParametre)
    {
        this.setLayout(new BorderLayout());
        this.frame = frame;
        this.frameCo = frameCo;

        this.panelParametre = panelParametre;
        /*--------------------------*/
        /*  Création des composants */
        /*--------------------------*/
        this.panelMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.panelMenu.setBackground(Color.GRAY);

        this.btnDeconnexion = new JButton("Deconnexion");
        this.btnDeconnexion.setBackground(Color.RED);
        this.btnParametres  = new JButton("Parametres" );
        this.btnParametres .setBackground(Color.BLUE);


        /*--------------------------------*/
        /*  Positionnement des composants */
        /*--------------------------------*/
        this.panelMenu.add(this.btnParametres);
        this.panelMenu.add(this.btnDeconnexion);

        this.add(this.panelMenu,BorderLayout.NORTH);
        this.add(this.panelParametre,BorderLayout.CENTER);


        /*----------------------------*/
        /*  Activation des composants */ 
        /*----------------------------*/
        this.btnDeconnexion.addActionListener(this);
        this.btnParametres.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.btnDeconnexion)
        {
            this.frame.setVisible(false);
            this.frameCo.setVisible(true);
        }

        if(e.getSource() == this.btnParametres)
        {
            this.frame.setParametre();
            
        }
    }

}