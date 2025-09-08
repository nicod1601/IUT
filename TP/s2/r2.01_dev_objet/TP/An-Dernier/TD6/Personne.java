public class Personne
{
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String toString()
    {
        String srt = "";

        if(this.prenom == null)
        {
            srt += "nom : " + this.nom;
        }
        else
        {
            srt += String.format("%-7s","prenom :" + this.prenom) + " " + "nom :" + this.nom;
        }
        return srt;

    }
}