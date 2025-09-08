public class Joueur
{
    private static int nbCartes = 0;
    
    private int numCarte;
    private String nom;
    private int pvJoueur;
    private int bouclier;
    private Carte[] mainJoueur;

    public Joueur(String nom, int pvJoueur)
    {
        this.nom = nom;
        this.pvJoueur = pvJoueur;
        this.bouclier = 0;
        this.mainJoueur = new Carte[6];
        this.numCarte = nbCartes;
        nbCartes++;
    }

    /*------------------------*/
    /*      Accesseurs        */
    /*------------------------*/
    public String getNom()        {return this.nom;       }
    public int getPvJoueur()      {return this.pvJoueur;  }
    public int getBouclier()      {return this.bouclier;  }
    public Carte[] getMainJoueur(){return this.mainJoueur;}


    /*------------------------*/
    /*      Modificateur      */
    /*------------------------*/
    public void setPvJoueur(int pvJoueur) {this.pvJoueur = pvJoueur;}
    public void setBlouclier(int bouclier){this.bouclier = bouclier;}
    public void setNom(String nom)        {this.nom = nom;          }

    public void setMainCartes(Carte[] pioche)
    {
        boolean[] cartesTirees = new boolean[pioche.length];
        int cartesAssignees = 0;

        while (cartesAssignees < this.mainJoueur.length)
        {
            int indiceCarte = (int) (Math.random() * pioche.length);

            if (!cartesTirees[indiceCarte])
            {
                this.mainJoueur[cartesAssignees] = pioche[indiceCarte];
                cartesTirees[indiceCarte] = true;
                cartesAssignees++;
            }
        }
        
    }

    public Carte choisirCarte(int indiceCarte)
    {
        Carte carteChoisie;
        carteChoisie = this.mainJoueur[indiceCarte];

        return carteChoisie;
    }

    public void retirerCarte(int indiceCarte)
    {
        this.mainJoueur[indiceCarte] = null;
    }
    
    public void piocherNouvelleCarte(Carte[] pioche)
    {
        for (int i = 0; i < this.mainJoueur.length; i++)
        {
            if (this.mainJoueur[i] == null) 
            {
                for (int j = 0; j < pioche.length; j++)
                {
                    if (pioche[j] != null)
                    { 
                        this.mainJoueur[i] = pioche[j];
                        pioche[j] = null;
                        return;
                    }
                }
            }
        }
    }
    

    public String toString()
    {
        String sRet = "";

        sRet += "Joueur : " + this.nom + "\n";
        sRet += "PV : " + this.pvJoueur + "\n";
        for(int cpt = 0; cpt < this.pvJoueur; cpt++)
        {
            sRet += "| ";
        }
        sRet += "\n";
        sRet += "Bouclier : " + this.bouclier + "\n";
        for(int cpt = 0; cpt < this.bouclier; cpt++)
        {
            sRet += "+ ";
        }
        sRet += "\n";

        return sRet;

    }

}
