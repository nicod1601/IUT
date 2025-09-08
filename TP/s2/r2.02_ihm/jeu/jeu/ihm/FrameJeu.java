package jeu.ihm;

import javax.swing.*;

public class FrameJeu extends JFrame
{
    private JPanel panelJeu;
    private Controleur ctrl;

    public FrameJeu(Controleur ctrl)
    {
        this.setSize(800,800);
        /*------------------------*/
        /* Création des coposants */
        /*------------------------*/
        this.ctrl = ctrl;
        this.panelJeu = new PanelJeu(this.ctrl);

        /*------------------------*/
        /* Ajout des coposants    */
        /*------------------------*/
        this.add(panelJeu);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
