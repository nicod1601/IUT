public class Rectangle 
{
    private int largeur;
    private int longueur;

    public Rectangle() 
    {
        this(4,3);
    }

    public Rectangle(int taille1, int taille2)
    {
        if(taille1 < 0){taille1 = -taille1;}
        if(taille2 < 0){taille2 = -taille2;}


        if(taille1 > taille2)
        {
            this.longueur = taille1;
            this.largeur  = taille2;
        }
        else
        {
            this.longueur = taille2;
            this.largeur  = taille1;
        }
    }

    public boolean setLargeur(int largeur) 
    {
        if(this.largeur >= 0 && this.longueur > this.largeur)
        {
            this.largeur = largeur;
            return true;
        }
        return false;
    }

    public boolean setLongueur(int longueur) 
    {
        if(this.longueur >= 0 && this.longueur > this.largeur)
        {
            this.longueur = longueur;
            return true;
        }
        return false;
    }

    public int getLargeur()  { return this.largeur                      ;}
    public int getLongueur() { return this.longueur                     ;}
    public int air()         { return this.largeur * this.longueur      ;}
    public int perimetre()   { return (this.largeur + this.longueur) * 2;}

    public String toString() 
    {
        return "rectangle";
    }
}
