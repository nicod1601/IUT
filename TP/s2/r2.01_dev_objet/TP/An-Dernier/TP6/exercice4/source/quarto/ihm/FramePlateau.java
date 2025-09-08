package quarto.ihm;
import quarto.Controleur;
import javax.swing.*;
import java.awt.*;

/**
  * Fenêtre graphique principale de l'application
  * @author Philippe Le Pivert.
  */
public class FramePlateau extends JFrame
{
	PannelPlateau  panneauPlateau;


	/** Constructeur */
	public FramePlateau(Controleur ctrl)
	{
		this.panneauPlateau  = new PannelPlateau(ctrl);
		add (panneauPlateau,  BorderLayout.CENTER);

		this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
	}


	/** Méthode destinée à la classe Controleur, lorsqu'elle souhaite rafraichir
	  * l'IHM                                                                    */
	public void majIHM()
	{
		panneauPlateau.repaint();
	}


	/** Méthode permettant de fermer la fenêtre GUI */
	public void fermer()
	{
		this.dispose();
	}

}


