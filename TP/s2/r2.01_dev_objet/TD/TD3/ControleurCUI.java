import iut.algo.Clavier;

public class ControleurCUI
{
	private IHMCUI   ihm;
	private DrEureka metier;
	private boolean  finDePartie;

	public ControleurCUI()
	{
		char action;
		int  numTube1, numTube2;

		this.metier      = new DrEureka();
		this.ihm         = new IHMCUI(this);

		do
		{
			this.ihm.afficherPlateau();
			action = ihm.lireAction();

			switch ( action )
			{
				case 'R' :
					numTube1 = ihm.lireTube("retourner le tube");
					this.metier.retourner(numTube1- 1);
					break;

				case 'E' :
					numTube1 = ihm.lireTube("échanger le tube");
					numTube2 = ihm.lireTube("avec le tube");
					this.metier.echanger(numTube1- 1, numTube2- 1);
					break;

				case 'D' :
					numTube1 = ihm.lireTube("déplacer du tube");
					numTube2 = ihm.lireTube("vers le tube");
					this.metier.deplacer(numTube1- 1, numTube2- 1);
					break;

				case 'N' :
					this.metier.niveauSuivant();
					break;
			}

		} while ( action != 'Q');

		this.ihm.finDePartie();
	}

	public String getTube ( char type, int tube )
	{
		return this.metier.getTube(type, tube);
	}

	public int getNiveau ()
	{
		return this.metier.getNiveau();
	}

	public static void main(String[] a)
	{
		new ControleurCUI();
	}
}
