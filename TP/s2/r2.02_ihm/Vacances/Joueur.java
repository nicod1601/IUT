public class Joueur
{
    private int cote;

    public Joueur(int cote)
    {
        this.cote = cote;
    }

    public int getCote(){ return this.cote;}

    public String toString()
    {
        String sRet ="";

        for(int cpt =0; cpt < this.cote; cpt++)
            sRet += "-".repeat(this.cote) + "\n";

        return sRet;
    }

    public static void main(String[] args)
    {
        Joueur j;

        j = new Joueur(4);

        System.out.println(j);
    }
}