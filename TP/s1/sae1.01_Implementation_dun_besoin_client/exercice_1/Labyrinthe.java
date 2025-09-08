package sae1_1.exercice_1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Labyrinthe
{

	private int      posLig;
	private int      posCol;

	private char[][] grille;


    public Labyrinthe() 
    {
        this.posLig = 3;
        this.posCol = 2;

        try
        {
            Scanner sc = new Scanner ( new FileInputStream( "src/sae1_1/exercice_1/data/grille.data.txt" ), "UTF8" );

            int ligne = 0;
            int colonne = 0;

            while (sc.hasNextLine())
            {
                String currentLine = sc.nextLine();
                ligne++;
                colonne = Math.max(colonne, currentLine.length());
            }

            sc.close();

            this.grille = new char[ligne][colonne];

            sc = new Scanner ( new FileInputStream( "src/sae1_1/exercice_1/data/grille.data.txt" ), "UTF8" );
            for (int i = 0; i < ligne; i++)
            {
                String currentLine = sc.nextLine();
                for (int j = 0; j < currentLine.length(); j++)
                {
                    this.grille[i][j] = currentLine.charAt(j);
                }
                for (int j = currentLine.length(); j < colonne; j++)
                {
                    this.grille[i][j] = ' ';
                }
            }
        }
        catch (Exception e) { e.printStackTrace(); }

    }

    public void deplacer(char dir)
    {

        switch (dir)
        {
            case 'N':
                if (this.posLig-1 < 0 || this.grille[this.posLig-1][this.posCol] == '=') { return; }

                this.grille[this.posLig][this.posCol] = ' ';
                this.posLig--;
                this.grille[this.posLig][this.posCol] = 'O';
                break;
            case 'O':
                if (this.posCol-1 < 0 || this.grille[this.posLig][this.posCol-1] == '=') { return; }

                this.grille[this.posLig][this.posCol] = ' ';
                this.posCol--;
                this.grille[this.posLig][this.posCol] = 'O';
                break;
            case 'S':
                if (this.posLig+1 >= this.grille.length || this.grille[this.posLig+1][this.posCol] == '=') { return; }

                this.grille[this.posLig][this.posCol] = ' ';
                this.posLig++;
                this.grille[this.posLig][this.posCol] = 'O';
                break;
            case 'E':
                if (this.posCol+1 >= this.grille[this.posLig].length || this.grille[this.posLig][this.posCol+1] == '=') { return; }

                this.grille[this.posLig][this.posCol] = ' ';
                this.posCol++;
                this.grille[this.posLig][this.posCol] = 'O';
                break;
            default:
                break;
        }
    }

    public String toString()
    {
        String ligne = "+---";
        for (int i = 1; i < this.grille[0].length; i++)
        {
            ligne += "+---";
        }
        ligne += "+";
        String res = ligne + "\n";

        for (int i = 0; i < this.grille.length; i++)
        {
            res += "|";
            for (int j = 0; j < this.grille[i].length; j++)
            {
                res += " " + this.grille[i][j] + " |";
            }
            res += "\n" + ligne + "\n";
        }
        return res;
    }


}
