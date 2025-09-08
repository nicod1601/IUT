package metier;
public class Train
{
    private Chariot tete;
    private Chariot queue;

    public Train () { this.tete = this.queue = null; }

    public boolean estVide() { return this.tete == null && this.queue == null; }
    public int ajouterBoite(Boite b)
    {
        Chariot tmp;
        int ret=0;

        if ( b.getMasse() > Chariot.CHARGE_MAXI ) return -1;

        if ( this.estVide() )
        {
            ret = 1;
        }
        else
        {
            if ( this.queue.getNbBoite() == Chariot.NB_BOITE_MAXI ) ret = 2;
            if ( this.queue.chargeActuelle() + b.getMasse() > Chariot.CHARGE_MAXI ) ret += 3;
        }

        if ( ret == 1 ) this.tete = this.queue = new Chariot();

        if ( ret > 1 )
        {
            tmp = new Chariot();
            this.queue.setSvt ( tmp );
            tmp.setPrc ( this.queue );
            this.queue = tmp;
        }

        this.queue.ajouterBoite (b);

        return ret;
    }

    public Boite enleverBoite()
    {
        Boite b;
        
        if ( this.estVide() ) return null;

        b = this.tete.enleverBoite();

        if ( this.tete.getNbBoite() == 0 )
        {
            this.tete = this.tete.getSvt();
            if (this.tete == null) this.queue = null;
        }
        
        return b;
    }
    
}