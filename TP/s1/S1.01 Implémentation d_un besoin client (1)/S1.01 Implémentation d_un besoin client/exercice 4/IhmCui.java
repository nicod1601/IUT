import iut.algo.Clavier;


public class IhmCui
{
	private Controleur ctrl;

	public IhmCui( Controleur ctrl )
	{
		this.ctrl = ctrl;
	}


	public void afficherGrille()
	{
		String ligne = "+---";
		for (int cpt = 1; cpt < this.ctrl.getNbLignes(); cpt++)
		{
			ligne += "+---";
		}

		ligne += "+";
		String res = ligne + "\n";

		for (int cptLig = 0; cptLig < this.ctrl.getNbLignes(); cptLig++)
		{
			res += "|";
			for (int cptCol = 0; cptCol < this.ctrl.getNbColonnes(); cptCol++)
			{
				res += " " + this.ctrl.getCase(cptLig, cptCol) + " |";
			}
			res += "\n" + ligne + "\n";
		}

		System.out.println(res);
	}

	public char saisirDirection()
	{
		char dir ;

		System.out.print("Entrer une direction : ");
		dir = Clavier.lire_char();

		return dir;
	}

}