package tests;
import figure.Bille;
import figure.couleur.Couleur;
import figure.couleur.CouleurK;

public class TestBille 
{
    public static void main(String[] a)
    {
        /*-------------*/
        /*   Donnée    */
        /*-------------*/
        Bille rouge;
        Bille vert;
        Bille bleu;
        Bille jaune;

        Bille violet;
        Bille cyan;
        Bille blanc;
        Bille noir;

        Bille JO;

        /*--------------*/
        /*  Instruction */
        /*--------------*/

        rouge = new Bille(255, 0, 0);
        System.out.println("Rouge" + rouge.toString());

        vert = new Bille(0, 255, 0);
        System.out.println("Vert" + vert.toString());

        bleu = new Bille(0, 0,255);
        System.out.println("Bleu" + bleu.toString());

        jaune = new Bille(255, 255, 0);
        System.out.println("Jaune" + jaune.toString());

        violet = new Bille(255, 0, 255);
        System.out.println("Violet" + violet.toString());

        cyan = new Bille(0, 255, 255);
        System.out.println("Cyan" + cyan.toString());

        blanc = new Bille(255, 255, 255);
        System.out.println("Blanc" + blanc.toString());

        noir = new Bille(0,0,0);
        System.out.println("Noir" + noir.toString());


    }
}
