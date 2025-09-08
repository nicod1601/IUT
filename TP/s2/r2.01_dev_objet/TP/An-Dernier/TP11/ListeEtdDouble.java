import utilitaire.Etudiant;

public class ListeEtdDouble 
{
    private int taille;
    private CelluleEtdDouble tete;
    private CelluleEtdDouble queue;
    private CelluleEtdDouble curseur;

    private CelluleEtdDouble memoir;

    public ListeEtdDouble()
    {
        this.taille = 0;
        this.tete = null;
        this.queue = null;
        this.curseur = null;
    }

    public void positionneDebut()
    {
        this.curseur = this.tete;
    }

    public void positionneFin()
    {
        this.curseur = this.queue;
    }

    public void suivant()
    {
        if(this.curseur.getSvt() != null)
        {
            this.curseur = this.curseur.getSvt();
        }

        /*if(this.aUnSuivant())
        {
            this.curseur = this.curseur.getSvt();
        }*/
    }

    public void precedent()
    {
        if(this.curseur.getPrc() != null)
        {
            this.curseur = this.curseur.getPrc();
        }
    }

    public boolean estVide()
    {
        return this.tete == null;
    }

    public boolean aUnSuivant()
    {
        return this.curseur != this.queue;

        /*if(this.estVide())return false;
        return this.curseur.getSvt() !=null;*/
    }

    public boolean aUnPrecedent()
    {
        return this.curseur != this.tete;
    }

    public void ajouter(Etudiant e)
    {
        CelluleEtdDouble tmp;

        if(this.estVide())
        {
            tmp = new CelluleEtdDouble(e);

            this.tete = tmp;
            this.queue = tmp;
            this.curseur = tmp;
        }
        else
        {
            tmp = new CelluleEtdDouble(e);

            this.queue.setSvt(tmp);
            tmp.setPrc(tmp);

            this.queue = tmp;
            this.tete = tmp;

            this.taille++;
        }

    }

    public int taille()
    {
        return this.taille;
    }

    public Etudiant consulter()
    {
        return this.curseur.getEtudiant();
    }

    public void ajouterEnTete(Etudiant e)
    {
        CelluleEtdDouble nv = new CelluleEtdDouble(e);;

        if(estVide())
        {
            this.tete = this.queue = this.curseur = nv;
        }
        else
        {
            nv.setSvt(this.tete);
            this.tete.setPrc(nv);
            this.tete = this.curseur = nv;
        }
        this.tete = this.curseur = nv;
        this.taille++;
    }

    public void inserer(Etudiant e)
    {
        CelluleEtdDouble ins;
        if(this.estVide() || this.tete == this.curseur)
        {
            this.ajouterEnTete(e);
        }
        else
        {
            CelluleEtdDouble tmp = new CelluleEtdDouble(e);
            this.curseur.getPrc().setSvt(tmp);
            tmp.setPrc(this.curseur.getPrc());

            tmp.setSvt(this.curseur);
            this.curseur.setPrc(tmp);

            this.curseur = tmp;
            this.taille++;
        }
    }

    public void remplacer(Etudiant e)
    {
        if(! this.estVide())
        {
             this.curseur.setEtudiant(e);
        }
    }

    public void suprimer()
    {
        /*Fase du millieu */
        if(! estVide())
        {
            if(this.tete == this.queue)
            {
                this.tete = this.queue = this.curseur = null;
                this.taille--;
                return;
            }

            if(this.curseur == this.tete)
            {
                this.curseur.getPrc().setSvt(this.curseur.getSvt());
                this.tete = this.curseur = this.curseur.getSvt();
                this.taille--;
                return;
            }

            if(this.curseur == this.queue)
            {
                this.curseur = this.queue = this.curseur.getPrc();
                this.curseur.getPrc().setSvt(null);
                this.taille--;
                return;

            }

            this.curseur.getPrc().setSvt(this.curseur.getSvt());
            this.curseur.getSvt().setPrc(this.curseur.getPrc());
            this.taille--;
            return;
        }
    }

    public void memoriserCurseur()
    {
        this.memoir = this.curseur;
    }



    public String toString()
    {
       String s = this.taille + "[";
    
    
       CelluleEtdDouble tmp = this.tete;
    
       while ( tmp != null )
       {
          s += tmp.getEtudiant().toString();
          tmp = tmp.getSvt();
          if (tmp != null) s += ";";
       }
    
       s += "]\n ";
    
       tmp = tete;
    
       while ( tmp != null )
       {
          s+= String.format ( "%" + tmp.getEtudiant().toString().length() + "s",
                                (tmp == this.curseur)?"/\\ ":" "
                            );
          tmp = tmp.getSvt();
          s += " ";
       }
    
       return s;
    } 
}
