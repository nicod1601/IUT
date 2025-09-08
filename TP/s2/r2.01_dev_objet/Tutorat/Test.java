import metier.Train;
import metier.Boite;
public class Test
{
    public static void main(String[] a)
    {
        Boite boite;
        Train train = new Train();
        // test erreur du Factory
        System.out.println ( "test1 : " + Boite.creerBoite ( "Rouge", 45 ) );
        System.out.println ( "test2 : " + Boite.creerBoite ( "Rouge", 0 ) );
        System.out.println ( "test3 : " + Boite.creerBoite ( "Turquoise", 10 ) );
        System.out.println () ;
        // Ajout de Boite dans le train logistique :
        boite = Boite.creerBoite ( "Bleu", 8 );
        if (boite != null ) System.out.println ( "ajout 1 : " + train.ajouterBoite (boite) );
        boite = Boite.creerBoite ( "Orange", 9 );
        if (boite != null ) System.out.println ( "ajout 2 : " + train.ajouterBoite (boite) );
        boite = Boite.creerBoite ( "Bleu", 7 );
        if (boite != null ) System.out.println ( "ajout 3 : " + train.ajouterBoite (boite) );
        boite = Boite.creerBoite ( "Vert", 8 );
        if (boite != null ) System.out.println ( "ajout 4 : " + train.ajouterBoite (boite) );
        boite = Boite.creerBoite ( "Vert", 3 );
        if (boite != null ) System.out.println ( "ajout 5 : " + train.ajouterBoite (boite) );
        boite = Boite.creerBoite ( "Bleu", 2 );
        if (boite != null ) System.out.println ( "ajout 6 : " + train.ajouterBoite (boite) );
        boite = Boite.creerBoite ( "Orange", 1 );
        if (boite != null ) System.out.println ( "ajout 7 : " + train.ajouterBoite (boite) );
        boite = Boite.creerBoite ( "Mauve", 7 );
        if (boite != null ) System.out.println ( "ajout 8 : " + train.ajouterBoite (boite) );
        boite = Boite.creerBoite ( "Rouge", 4 );
        if (boite != null ) System.out.println ( "ajout 9 : " + train.ajouterBoite (boite) );
        boite = Boite.creerBoite ( "Jaune", 35 );
        if (boite != null ) System.out.println ( "ajout 10 : " + train.ajouterBoite (boite) );
    }
}