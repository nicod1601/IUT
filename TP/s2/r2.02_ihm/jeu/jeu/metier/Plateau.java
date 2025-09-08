package jeu.metier;

public class Plateau 
{
    private int nbLignes;
    private int nbColonnes;

    public Plateau(int nbLignes, int nbColonnes)
    {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
    }

    public String toString()
    {
        String sRet = "";
        for (int i = 0; i < nbLignes; i++)
        {
            sRet += "|";
            for (int j = 0; j < nbColonnes; j++)
            {
                sRet += " " + "|";
            }
            sRet += "\n";
        }
        return sRet;
    }

    public static void main(String[] args)
    {
        Plateau p = new Plateau(3, 3);
        System.out.println(p);
    }
}