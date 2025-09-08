package metier;
public class Chariot
{
    static final int CHARGE_MAXI = 30;
    static final int NB_BOITE_MAXI = 4;

    private Boite[] tabBoite;
    private int nbBoite;

    private Chariot svt;
    private Chariot prc;

    Chariot()
    {
        this.svt = null;
        this.prc = null;
        this.nbBoite = 0;
        this.tabBoite = new Boite[NB_BOITE_MAXI];
    }

    Chariot getSvt () { return this.svt; }
    Chariot getPrc () { return this.prc; }
    void setSvt (Chariot c){ this.svt = c; }
    void setPrc (Chariot c){ this.prc = c; }

    int getNbBoite()
    {
        return this.nbBoite;
    }

    public void ajouterBoite(Boite boite)
    {
        this.tabBoite[this.nbBoite++] = boite;
    }

    public Boite enleverBoite()
    {
        if ( this.nbBoite == 0 ) return null;

        return this.tabBoite[--this.nbBoite];
    }

    public int chargeActuelle()
    {
        int charge = 0;

        for ( int cpt=0; cpt < nbBoite; cpt++ )
            charge += this.tabBoite[cpt].getMasse();
            
        return charge;
    }
}