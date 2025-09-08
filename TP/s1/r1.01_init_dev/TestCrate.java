import jeu.Carte;

public class TestCrate
{
    public static void main(String[] args) 
    {
        Carte c1 = new Carte(1, "Humain", "Ichigo");
        Carte c2 = new Carte(2, "Schinigami", "Aizen");

        System.out.println(c1);
        System.out.println(c2);
    }
}