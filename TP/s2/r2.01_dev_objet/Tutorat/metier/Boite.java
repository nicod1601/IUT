package metier;

public class Boite
{
    private static String[] tabCouleur = new String[] {"Rouge", "Orange", "Jaune", "Vert", "Bleu", "Mauve"};
    private static final int MASSE_MIN = 1;
    private static final int MASSE_MAX = 30;

    private static int nbBoites = 0;

    private int numero;
    private String couleur;
    private int masse;

    public static Boite creerBoite(String couleur, int masse)
    {
        if(! Boite.couleurValide(couleur)) return null;
        if(! Boite.masseValide  (masse  )) return null;

        return new Boite(couleur, masse);
    }

    private Boite(String couleur, int masse)
    {
        this.numero = ++nbBoites;
        this.couleur = couleur;
        this.masse = masse;
    }

    public int getNumero()     { return this.numero;  }
    public String getCouleur() { return this.couleur; }
    public int getMasse()      { return this.masse;   }

    private static boolean couleurValide(String couleur)
    {
        for(String c : tabCouleur)
            if(couleur.equals(c)) return true;
        return false;
    }

    private static boolean masseValide(int masse)
    {
        return masse >= MASSE_MIN && masse <= MASSE_MAX;
    }
}