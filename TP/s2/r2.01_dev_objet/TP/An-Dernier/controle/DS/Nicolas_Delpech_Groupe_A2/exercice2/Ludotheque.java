import java.util.Scanner;
import java.io.File;

/**
*@author Delpech Nicolas
*/

public class Ludotheque
{
	private Editeur[] ensEditeur;
	private int       nbEditeur;

	//private Jeu    [] ensJeu;	Décommenter à l'exercice 4
	//private int       nbJeu;

	
	public Ludotheque ()
	{
		this.initEditeur();
		this.initJeu    ();
	}


	private void initEditeur()
	{
		String nomEditeur;
		String ligne;
		Scanner sc=null;
		

		try
		{
			sc = new Scanner ( new File ( "editeur.data" ), "UTF-8" );

			while ( sc.hasNextLine() )
			{
				ligne = sc.nextLine();

				nomEditeur = ligne.substring(1,21); //je selectionne la partie qui me faut pour avoir le nom
				ensEditeur[this.nbEditeur++] = new Editeur (nomEditeur);

				this.nbEditeur += nbEditeur++;

			}
		}
		catch(Exception e){ e.printStackTrace(); }

		sc.close();
	}
	
	private void initJeu()
	{
		/* A Compléter dans l'exercice 4 puis 5*/
	}

	public int getNbEditeur () { return this.nbEditeur; }
	/*public int getNbJeu     () { //return this.nbJeu; Décommenter à l'exercice 4 */ 

	public Editeur getEditeur (int indice)
	{
		/* A compléter dans l'exercice 5 */
		return null;
	}
	
	/*
	public Jeu getJeu (int indice)
	{
		//* A compléter dans l'exercice 4 *
		return null;
	}
	*/


}
