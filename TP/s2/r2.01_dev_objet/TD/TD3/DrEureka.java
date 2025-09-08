import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DrEureka
{
    /** Les trois tubes Chimiste */
    private Pile[] ensChimiste;

    /** Les trois tubes Objectif */
    private Pile[] ensObjectif;

    /** Le niveau en cours */
    private int niveau;

    public DrEureka()
	{
        this.niveau = 1;
        this.ensObjectif = initObjectif(this.niveau);
        this.ensChimiste = initChimiste();
    }

    /** Retourne sous forme textuelle le contenu d'un tube */
    public String getTube(char type, int numTube) 
	{
        if (type == 'C') return ensChimiste[numTube].toString();
        if (type == 'O') return ensObjectif[numTube].toString();
        return null;
    }

    public int getNiveau() { return this.niveau; }

    /** Retourne (haut/bas) le tube numTube du Chimiste */
    public void retourner(int numTube)
	{
        this.ensChimiste[numTube].retourner();
    }

    /** Echange les tubes num1 et num2 du Chimiste */
    public void echanger(int num1, int num2)
	{
        Pile temp = ensChimiste[num1];
        ensChimiste[num1] = ensChimiste[num2];
        ensChimiste[num2] = temp;
    }

    /** Déplace une bille du tube numSource vers le tube numDest du Chimiste */
    public void deplacer(int numSource, int numDest)
	{
        if (!ensChimiste[numSource].estVide() && !ensChimiste[numDest].estPlein())
		{
            char bille = ensChimiste[numSource].depiler();
            ensChimiste[numDest].empiler(bille);
        }
    }

    public void niveauSuivant()
	{
        this.niveau++;
        if (this.niveau == 6) this.niveau = 1;
        this.ensObjectif = initObjectif(this.niveau);
    }

    private static Pile[] initChimiste()
	{
        Pile[] tubes = new Pile[3];
        tubes[0] = new Pile(4);
        tubes[1] = new Pile(4);
        tubes[2] = new Pile(4);

        tubes[0].empiler('M'); tubes[0].empiler('M');
        tubes[1].empiler('R'); tubes[1].empiler('R');
        tubes[2].empiler('V'); tubes[2].empiler('V');

        return tubes;
    }

    private static Pile[] initObjectif(int numObj)
	{
        Scanner scFic;
        String[] grilleTemp;
        int ligne;
        Pile[] tubes = new Pile[3];
        tubes[0] = new Pile(4);
        tubes[1] = new Pile(4);
        tubes[2] = new Pile(4);

        try
		{
            scFic = new Scanner(new FileInputStream("niveau_" + numObj + ".data"));

            ligne =0;
            while (scFic.hasNextLine() && ligne < 4) 
            {
                ligne ++;
            }
            scFic.close();

            grilleTemp = new String[ligne];

        } catch (FileNotFoundException e) {
            System.out.println("Erreur : fichier de niveau non trouvé.");
            return tubes;
        }

        for (int lig = 3; lig >= 0; lig--)
        {
            for (int col = 0; col < 5; col+=2)
            {
                if (grilleTemp[lig].charAt(col) != '.')
                {
                    tubes[col/2].empiler(grilleTemp[lig].charAt(col));
                }
            }
        }

        return tubes;
    }
}