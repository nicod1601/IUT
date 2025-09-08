
/**
 * Classe Caisse
 *
 * Exercice 5
 *
 * groupe    : 2
 * auteurs   : Ethan Damestoy, Alexandre Freret, Alexis Constantin, Lucas EL MAKNASSI, Nicolas Delpech
 *
 * créée le : 18/12/2024 19H15
 * Version 1
 */

public class Caisse
{

	private int ligCaisse;
	private int colCaisse;
	
	private Platforme plt;


	public Caisse(int lig, int col, Platforme plt)
	{
		this.ligCaisse = lig;
		this.colCaisse = col;
		
		this.plt      = plt;
	}

	public int getNbLig    () { return   this.plt.getNbLignes(); }
	public int getNbCol    () { return this.plt.getNbColonnes(); }

	public int getCaisseLig() { return this.ligCaisse; }
	public int getCaisseCol() { return this.colCaisse; }


	public boolean estDansLeVide(int lig, int col)
	{
		boolean enDessous;
		boolean surLaCase;

		int     futurLig ;
		
		futurLig = lig + 1;
		
		if(futurLig > this.getNbLig()-1) futurLig = 0;
		
		enDessous = this.plt.getCase(futurLig, col ) == ' ' || this.plt.getCase(futurLig, col) == '#';
		surLaCase = this.plt.getCase(lig     , col ) != '#' || this.plt.getCase(lig     , col ) != '=';

		return enDessous && surLaCase;
	}


	public void tomber()
	{
		try
		{
			Thread.sleep(200);
			this.deplacerCaisse('S'); 
		} catch (Exception e) { e.printStackTrace(); }
	}



	public void deplacerCaisse(char dir)
	{
		int futurLig = this.getCaisseLig() + this.deltaLig(dir);
		int futurCol = this.getCaisseCol() + this.deltaCol(dir);


		while(this.estDansLeVide(futurLig, futurCol)  )
		{
			futurLig = this.ligCaisse + 1 ;
			switch (dir) 
			{
				case 'E' ->futurCol = this.colCaisse + 1;
				case 'O' ->futurCol = this.colCaisse - 1;
				default -> 
				{
					futurLig = this.ligCaisse;
					futurCol = this.colCaisse;
				}
			}
			
		}

		if( futurLig < 0                      ) futurLig = this.getNbLig() -1;
		if( futurLig > this.getNbLig() -1     ) futurLig = 0;

		if( futurCol < 0                      ) futurCol = this.getNbCol() -1;
		if( futurCol > this.getNbCol() -1     ) futurCol = 0;

		if( this.plt.getCase(futurLig, futurCol) != '=' || this.plt.getCase(futurLig, futurCol) != '#' )
		{
			this.ligCaisse = futurLig;
			this.colCaisse = futurCol;

		}
	}

	private int deltaLig(char dir)
	{
		int delta;

		switch (dir)
		{
			case 'N': delta = -1; break;
			case 'S': delta = +1; break;
			default : delta =  0; break;
		}

		return delta;
	}

	private int deltaCol(char dir)
	{
		int delta;

		switch (dir)
		{
			case 'O': delta = -1; break;
			case 'E': delta = +1; break;
			default : delta =  0; break;
		}

		return delta;
	}

}
