
public class Robot 
{
    private String  couleur;
    private char    nom;
    private int     ligne;
    private char    colonne;

    public Robot(int ligne, char colonne, String couleur, char nom)
    {
        this.ligne   = ligne;
        this.colonne = colonne;
        this.nom     = nom;
        this.couleur = couleur;
    }
    
    public int    getLigne()   {return this.ligne  ;}
    public char   getColonne() {return this.colonne;}
    public int    getNom()     {return this.nom    ;}
    public String getCouleur() {return this.couleur;}
    public int getPoseX(){return 0;}
    public int getPoseY(){return 0;}

    public int setLigne  (int ligne){return this.ligne = ligne;}
    public int setColonne(char col ){return this.colonne = col;}

    public boolean deplacer(String direction)
    {
        if(direction.equals("N") || direction.equals("S") || direction.equals("O") || direction.equals("E") )
        {
            return true;
        }

        return false; 
    }



    public String toString()
    {
        String str = "";

        str = "Lig : " + this.ligne + "\n" +
              "Col : " + this.colonne;

        return str;
    }
}