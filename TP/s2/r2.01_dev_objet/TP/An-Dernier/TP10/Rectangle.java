public class Rectangle
{
    private int largeur;
    private int longueur;

    public Rectangle (int taille1, int taille2)
    {
        if(taille1 < taille2)
        {
            this.largeur = taille1;
            this.longueur = taille2;
        }
        else
        {
            this.largeur = taille2;
            this.longueur = taille1;
        }
    }

    public boolean setLargeur(int largeur)
    {
        if(largeur > this.longueur){return false;}
        this.largeur = largeur;
        return true;
    }

    public boolean setLongueur(int longueur)
    {
        if(longueur < this.largeur){return false;}
        this.longueur = longueur;
        return true; 
    }

    public int getLargeur(){return this.largeur;}
    public int getLongueur(){return this.longueur;}

    public int aire()
    {
        return this.largeur * this.longueur;
    }

    public int perimetre()
    {
        return this.largeur*2 + this.longueur*2;
    }

    public String toString()
    {
        return "largeur :"  + this.largeur +'\n'+
               "longueur :" + this.longueur +'\n'+
               "Aire :"     + this.aire()  +'\n'+
               "Perimetre :"+ this.perimetre();
    }

    public static void main(String[] a)
    {
        Rectangle r1 = new Rectangle(15, 9);

        System.out.println(r1.toString());
    }
    
}
