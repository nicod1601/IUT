package jeu.ihm;

import javax.swing.*;

import jeu.Controleur;

public class PanelJeu extends JPanel
{
    private JLabel[][] label;
    private Controleur ctrl;

    public PanelJeu(Controleur ctrl)
    {
        this.setSize(800,800);
        this.ctrl = ctrl;
        /*------------------------*/
        /* Création des coposants */
        /*------------------------*/


        /*------------------------*/
        /* Ajout des coposants    */
        /*------------------------*/

        this.setVisible(true);
    }
}
