public class Carte 
{
    private static int nbCartes = 0;
    
    private String  nom;
    private String type;
    private int niv;
    private int num;
    private int att;
    private int heal;
    private int def;
    
    public Carte(String nom, String type,int niv, int att, int heal, int def)
    {
        this.nom = nom;
        this.type = type;
        this.niv = niv;
        this.att = att;
        this.heal = heal;
        this.def = def;
        this.num = nbCartes;
        nbCartes++;
    }

    public String getNom (){return this.nom  ;}
    public String getType(){return this.type ;}
    public int getAtt    (){return this.att  ;}
    public int getHeal   (){return this.heal ;}
    public int getDef    (){return this.def  ;}
    public int getNum    (){return this.num  ;}
    public int getNiveau (){return this.niv  ;}

    public static Carte[] creerPioche()
    {
        Carte[] pioche = new Carte[16];

        pioche [0] = new Carte("Flamme"      , "Rouge" ,1, 30, 0 , 0);
        pioche [1] = new Carte("Arbre de vie", "Vert"  ,1, 0 , 50, 0);
        pioche [2] = new Carte("Epine"       , "Rouge" ,1, 20, 0 , 0);
        pioche [3] = new Carte("Bouclier"    , "Bleu"  ,1, 0, 0 , 30);
        pioche [4] = new Carte("Flamme"      , "Rouge" ,1, 30, 0 , 0);
        pioche [5] = new Carte("Arbre de vie", "Vert"  ,1, 0 , 50, 0);
        pioche [6] = new Carte("Epine"       , "Rouge" ,1, 20, 0 , 0);
        pioche [7] = new Carte("Bouclier"    , "Bleu"  ,1, 0, 0 , 30);
        pioche [8] = new Carte("Flamme"      , "Rouge" ,1, 30, 0 , 0);
        pioche [9] = new Carte("Arbre de vie", "Vert"  ,1, 0 , 50, 0);
        pioche[10] = new Carte("Epine"       , "Rouge" ,1, 20, 0 , 0);
        pioche[11] = new Carte("Bouclier"    , "Bleu"  ,1, 0, 0 , 30);
        pioche[12] = new Carte("Flamme"      , "Rouge" ,1, 30, 0 , 0);
        pioche[13] = new Carte("Arbre de vie", "Vert"  ,1, 0 , 50, 0);
        pioche[14] = new Carte("Epine"       , "Rouge" ,1, 20, 0 , 0);
        pioche[15] = new Carte("Bouclier"    , "Bleu"  ,1, 0, 0 , 30);

        return pioche;
    }

    /*public Carte fusionner(Carte c1, Carte c2)
    {
        Carte nvCarte;

        if(c1.getNiveau() == c2.getNiveau() && c1.getType().equals(c2.getType()))
        {
            nvCarte = new Carte(c1.getNom(), c1.getType(), 2, c1.getAtt(), c1.getHeal(), c1.getDef());
            c1 = c2 = null;

            return nvCarte;
        }
        return null;
    }*/

    public static Carte[] melangerPioche(Carte[] pioche)
    {
        for(int cpt = 0; cpt < pioche.length; cpt++)
        {
            int piocheAleatoire = (int) Math.floor(Math.random() * pioche.length);

            Carte temp = pioche[cpt];
            pioche[cpt] = pioche[piocheAleatoire];
            pioche[piocheAleatoire] = temp;
        }

        return pioche;

    }

    public String toString()
    {
        return " Carte : " + this.num            + "\n" +
               "         Nom     : " + this.nom  + "\n" +
               "         Type    : " + this.type + "\n" +
               "         Attaque : " + this.att  + "\n" +
               "         Heal    : " + this.heal + "\n" +
               "         Defense : " + this.def  ;
    }
}