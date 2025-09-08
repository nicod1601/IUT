public class Carre extends Rectangle
{
    public Carre(int x) 
    { 
        super(x, x); 
    }

    public boolean setLargeur(int largeur)
    {
        return super.setLongueur(largeur);
    }

    public boolean setLongueur(int longueur)
    {
        return super.setLargeur(longueur);
    }

    public String toString()
    {
        return "Carre " ;
    }
}
