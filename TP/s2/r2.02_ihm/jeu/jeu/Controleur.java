package jeu;

import jeu.metier.*;
import jeu.ihm.*;

public class Controleur
{
    private Plateau metier;
    private FrameJeu ihm;

    public Controleur()
    {
        this.metier = new Plateau(3, 3);
        this.ihm    = new FrameJeu(this);
    }

    public static void main(String[] args)
    {
       new Controleur();
    }
}