public class Jeu
{
    private String nomJeu   ;
    private int nbJoueurMini;
    private int nbJoueurMaxi;

    private Editeur editeur;

    /*-----------------------*/
    /*      Constructeur     */
    /*-----------------------*/

    public Jeu(String nomJeu, int nbJoueurMini, int nbJoueurMaxi)
    {
        this.nomJeu =nomJeu;
        this.nbJoueurMini = nbJoueurMini;
        this.nbJoueurMaxi = nbJoueurMaxi;

        this.editeur = null;
    }

    public Jeu(Editeur editeur, String nomJeu, int nbJoueurMini, int nbJoueurMaxi)
    {
        this.editeur = editeur;
        this.nomJeu =nomJeu;
        this.nbJoueurMini = nbJoueurMini;
        this.nbJoueurMaxi = nbJoueurMaxi;
        
    }

    /*-----------------------*/
    /*        Methode        */
    /*-----------------------*/

    public Editeur getEditeur()
    {
        return this.editeur;
    }

    public String getNomJeu()
    {
        return this.nomJeu;
    }

    public int nbJoueurMini()
    {
        return this.nbJoueurMini;
    }

    public int nbJoueurMaxi()
    {
        return this.nbJoueurMaxi;
    }

}