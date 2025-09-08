import iut.algo.Clavier;

public class Lettre
{
    public static void main(String[] args)
    {
        /*------------*/
        /* Variables  */
        /*------------*/
        char cara;
        /*--------------*/
        /* Instruction  */
        /*--------------*/

        System.out.print("Entrer une lettre : ");
        cara = Clavier.lire_char();

        while (estLettre(cara))
        {
            System.out.println(cara + " est une lettre");

            System.out.println("Est-ce une voyelle ? : " + estVoyelle(cara));
            System.out.println("Est-ce une consonne ? : " + estConsonne(cara));

            System.out.print("Entrer une lettre : ");
            cara = Clavier.lire_char();
        }
        
    
    }

    public static boolean estVoyelle(char c)
    {
        switch (c) 
        {
            case 'A': return true;
            case 'E': return true;
            case 'I': return true;
            case 'O': return true;
            case 'U': return true;
            case 'Y': return true;
            case 'a': return true;
            case 'e': return true;
            case 'i': return true;
            case 'o': return true;
            case 'u': return true;
            case 'y': return true;
            default: return false;
        }
    }

    public static boolean estConsonne(char c)
    {
        return !estVoyelle(c);
    }

    public static boolean estLettre(char c)
    {
        if(c == '.' || c == ',' || c == '!' || c == '?' || c == ' ')
        {
            return false;
        }
        return estVoyelle(c) || estConsonne(c);
    }


}