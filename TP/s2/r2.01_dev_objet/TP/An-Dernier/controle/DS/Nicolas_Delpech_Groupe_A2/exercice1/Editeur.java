/**
*@author Delpech Nicolas
*/

public class Editeur
{
	private static int nbEditeur = 0;

	private int numEditeur          ;
	private String nomEditeur       ;
	

	/*-------------------------*/
	/*      Constructeur       */
	/*-------------------------*/

	public Editeur(String nomEditeur)
	{
		this.nomEditeur = nomEditeur  ;
		this.numEditeur = 1           ;
		this.nbEditeur = ++numEditeur ;
	}

	/*-------------------------*/
	/*         Méthode         */
	/*-------------------------*/
	
	public int getNumEditeur()
	{
		return this.numEditeur;
	}
	
	public String getNomEditeur()
	{
		return this.nomEditeur;
	}

	/**
	 * La méthode toString me permet de faire des teste sur mes Editeurs
	 */
	public String toString()
	{
		String srt = " ";

		srt += this.numEditeur + " " + this.nomEditeur;

		return srt;

	}
}
