import java.util.ArrayList;
import java.util.Scanner;

public class Aquarium {
    
    private ArrayList<Algue> lstAlgues;
    private int nbToures;
    private ArrayList<Poisson> lstPoissons;

    public Aquarium()
    {
        this.nbToures    = 0;
        this.lstAlgues   = new ArrayList<Algue>();
        this.lstPoissons = new ArrayList<Poisson>();
    }

    public void ajouterPoisson(String nom, String sexe) 
    {
        this.lstPoissons.add(new Poisson(nom, sexe));
    }

    public void ajouterAlgue() 
    {
        this.lstAlgues.add(new Algue());
    }

    public void infoPoisson()
    {
        Scanner clavier = new Scanner(System.in);

        System.out.print("Entrez le nom du poisson : ");
        String nom = clavier.nextLine();

        System.out.print("Entrez le sexe du poisson (male/femelle) : ");
        String sexe = clavier.nextLine();

        this.ajouterPoisson(nom, sexe);
    }

    public void passerTemps()
    {
        this.nbToures++;
        this.infoPoisson();
        this.ajouterAlgue();
    }


    public String toString()
    {
        String str = "| ";

        for(int cpt = 0; cpt < this.lstPoissons.size(); cpt++)
        {
            str += this.lstPoissons.get(cpt).getNom() + this.lstPoissons.get(cpt).getSexe() + " | ";
        }

        str += "\n";

        str += "Nombre d'Algues = " + this.lstAlgues.size();

        str += "\n";

        str += "Nombre de Toures = " + this.nbToures;


        return str;

    }

    public static void main(String[] args) 
    {
        Aquarium aqua = new Aquarium();

        int cpt = 0;

        while(cpt < 4)
        {
            aqua.ajouterAlgue();
            aqua.passerTemps();

            cpt++;
        }

        System.out.println(aqua.toString());

    }
}
