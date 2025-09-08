package jeu.metier;

public class Joueur
{
    private String nom;
    private int score;
    private int posLig;
    private int posCol;
    
    public Joueur(String nom, int score, int posLig, int posCol)
    {
        this.nom = nom;
        this.score = score;
        this.posLig = posLig;
        this.posCol = posCol;
    }

    public String getNom()
    {
        return nom;
    }

    public int getScore()
    {
        return score;
    }

    public int getPosLig()
    {
        return posLig;
    }

    public int getPosCol()
    {
        return posCol;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public void setPosLig(int posLig)
    {
        this.posLig = posLig;
    }

    public void setPosCol(int posCol)
    {
        this.posCol = posCol;
    }

    public String toString()
    {
        return "Joueur [nom=" + nom + ", score=" + score + ", posLig=" + posLig + ", posCol=" + posCol + "]";
    }
}
