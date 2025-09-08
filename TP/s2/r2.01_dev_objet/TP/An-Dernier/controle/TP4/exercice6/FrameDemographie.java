
/**
  * Cadre Principal de l'application
  * @author Philippe Le Pivert.
  */

import javax.swing.*;
import java.awt.*;

public class FrameDemographie extends JFrame
{
	PannelDemographie panneauDemographie;

	/** Constructeur */
	public FrameDemographie ( ControleurDemographie ctrl )
	{
		this.panneauDemographie = new PannelDemographie( ctrl );
		this.add ( panneauDemographie, BorderLayout.CENTER );

		this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
	}

	/** Méthode destinée	 à la classe Controleur, lorsqu'elle souhaite rafraichir
	  * l'IHM
	  * ceci déclenche la méthose PaintComponent de notre Pannel                       */
	public void majIHM()
	{
		this.panneauDemographie.maj();
	}

	/** Méthode permettant de fermer la fenêtre GUI */
	public void fermer()
	{
		this.dispose();
	}
}
