public class PointCouleur extends Point
{
    private int couleur;

    public PointCouleur(int x, int y, char nom)
    {
        this(x, y, nom, 0);
    }
    
    public PointCouleur(int x, int y, char nom, int couleur)
    {
        super(x, y, nom);
        this.couleur = 0;
    }

    public int getCouleur()
    {
        return this.couleur;
    }

    public void setCouleur(int couleur)
    {
        this.couleur = couleur;
    }
    
    public String toString()
    {
        String sRet ="";
        if(this.couleur == 0){ sRet += "noir";  }
        if(this.couleur == 1){ sRet += "blanc"; }
        if(this.couleur == 2){ sRet += "rouge"; }
        if(this.couleur == 3){ sRet += "vert";  }

        return sRet;
    }
}
