import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author Delpech Nicolas
 * Carte
 * @date 17/01/2025
 */

public class Carte
{
	private int[][] ensHauteurs;
	
	public Carte(String fichier)
	{
		int ligne   = 0;
		int colonne = 0;
		String line;
		int chiffre;
		
		
		try
		{
			Scanner sc = new Scanner(new FileInputStream(fichier), "UTF-8");

			while (sc.hasNextLine())
			{
				line = sc.nextLine();
				ligne++;
				colonne = Math.max(colonne, line.length());
			}
			sc.close();
			
			this.ensHauteurs = new int[ligne][colonne];
			
			sc = new Scanner(new FileInputStream(fichier), "UTF-8");
			
			for(int lig = 0; lig < this.ensHauteurs.length; lig ++)
			{
				line = sc.nextLine();
				
				for(int col = 0; col < this.ensHauteurs[0].length; col++)
				{
					chiffre = line.charAt(col) - 32;
					if ( chiffre != 0)
					{
						chiffre -= 16;
					}
					this.ensHauteurs[lig][col] = chiffre;
				}
			}
			
			} catch (Exception e) { e.printStackTrace(); }
	}
	public int getNbLigne  (){ return this.ensHauteurs.length   ;}
	public int getNbColonne(){ return this.ensHauteurs[0].length;}
	
	public int getVal(int lig, int col)
	{
		for(int ligne = 0; ligne < this.ensHauteurs.length; ligne++)
		{
			for(int colonne = 0; colonne < this.ensHauteurs[0].length; colonne++)
			{
				if( lig == ligne && col == colonne )
				{
					return this.ensHauteurs[lig][col];
				}
			}
		}
		return 0;
	}
	
	public int hauteurMax()
	{
		int max;
		max = this.ensHauteurs[0][0];
		
		for(int ligne = 0; ligne < this.ensHauteurs.length; ligne++)
		{
			for(int colonne = 0; colonne < this.ensHauteurs[0].length; colonne++)
			{
				if(max < this.ensHauteurs[ligne][colonne] )
				{
					max = this.ensHauteurs[ligne][colonne];
				}
				else
				{
					max = max;
				}
			}
		}
		
		return max;
	}
	
	public void niveler()
	{
		int cpt = 0;
		while(cpt < this.hauteurMax())
		{
			for(int lig = 0; lig < this.ensHauteurs.length; lig++)
			{
				for(int col = 0; col < this.ensHauteurs[0].length; col++)
				{
					if( this.getVal(lig, col) != 0)
					{
						if(this.ensHauteurs[lig - 1 ][col] == 0)
							this.ensHauteurs[lig - 1 ][col] = this.getVal(lig, col) - 1;
							
						if(this.ensHauteurs[lig][col - 1] == 0)
							this.ensHauteurs[lig][col - 1] = this.getVal(lig, col) - 1;
							
						if(this.ensHauteurs[lig + 1 ][col] == 0)
							this.ensHauteurs[lig + 1 ][col] = this.getVal(lig, col) - 1;
							
						if(this.ensHauteurs[lig][col + 1] == 0)
							this.ensHauteurs[lig][col + 1] = this.getVal(lig, col) - 1;
							
						if(this.ensHauteurs[lig - 1][col - 1] == 0)
							this.ensHauteurs[lig - 1][col - 1] = this.getVal(lig, col) - 1;
							
						if(this.ensHauteurs[lig + 1][col + 1] == 0)
							this.ensHauteurs[lig + 1][col + 1] = this.getVal(lig, col) - 1;
							
						if(this.ensHauteurs[lig - 1][col + 1] == 0)
							this.ensHauteurs[lig - 1][col + 1] = this.getVal(lig, col) - 1;
						
						if(this.ensHauteurs[lig + 1][col - 1] == 0)
							this.ensHauteurs[lig + 1][col - 1] = this.getVal(lig, col) - 1;
					}
				}
			}
			cpt++;
		}
	}
	
	
	
	public String toString()
	{
		String sRet ="";
		
		sRet += "+" + "---------------------------------------"+ "+ \n";
		
		for(int lig = 0; lig < this.ensHauteurs.length; lig++)
		{
			
			
			for(int col = 0; col < this.ensHauteurs[0].length; col++)
			{
				if(col == 0)
				{
					sRet += "|";
				}
				
				if ( this.getVal(lig, col) == 0)
				{
					sRet += " ";
				}
				else
				{
					sRet += this.getVal(lig, col);
				}
				
			}
			sRet += "| \n";
		}
		sRet += "+" + "---------------------------------------"+ "+ \n";
		
		return sRet;
	}
}

