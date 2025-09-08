import java.io.FileInputStream;
import java.util.Scanner;

public class Carte
{
	private int[][] ensHauteurs;

	public Carte(String fichier)
	{
		String line;
		int ligne;
		int colonne;
		int chiffre;

		ligne = 0;
		colonne = 0;

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
			
			for(int lig = 0; lig < this.ensHauteurs.length ; lig++)
			{
				line = sc.nextLine();

				for(int col = 0; col < this.ensHauteurs[0].length; col++)
				{
					if(line.charAt(col) != ' ')
					{
						this.ensHauteurs[lig][col]  = line.charAt(col) - '0';
					}

					

					/*if(chiffre != 0)
					{
						chiffre -= 16;
					}
					this.ensHauteurs[lig][col] = chiffre;*/
				}
			}
		} catch (Exception e) { e.printStackTrace(); }

	}

	public int getNbLignes(){return this.ensHauteurs.length;}
	public int getNbColonnes(){return this.ensHauteurs[0].length;}

	public int  getVal(int lig, int col)
	{
		return this.ensHauteurs[lig][col];
	}

	public int hauteurMax()
	{
		int max;

		max = this.ensHauteurs[0][0];

		for(int lig = 0; lig < this.ensHauteurs.length ; lig++)
		{
			for(int col = 0; col < this.ensHauteurs[0].length; col++)
			{
				if(max < this.ensHauteurs[lig][col])
				{
					max = this.ensHauteurs[lig][col];
				}
			}
		}

		return max;
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
