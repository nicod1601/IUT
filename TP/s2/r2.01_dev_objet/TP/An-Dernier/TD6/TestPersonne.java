import java.io.FileInputStream;
import java.util.Scanner;
//import iut.algo.Decomposeur;
import java.util.List;
import java.util.ArrayList;

public class TestPersonne
{
    public static void main(String[] arg)
    {
        /*Donnée */
        String enregistrement;

        int posVirg;

        List<Personne> lstPersonne;
        /*Instruction */
        lstPersonne = new ArrayList<Personne>();

  

        try
        {
            Scanner sc = new Scanner ( new FileInputStream("liste.data"), "UTF8" );

            while ( sc.hasNextLine() )
            {
                //System.out.println(sc.nextLine());

                enregistrement = sc.nextLine();

                String nom, prenom = null;

                posVirg = enregistrement.indexOf(',');

                //System.out.println(posVirg);

                if (enregistrement.startsWith("n"))
                {
                    if(posVirg == -1)
                    {
                        nom = enregistrement.substring(4, enregistrement.length());
                    }
                    else
                    {
                        nom = enregistrement.substring(4, posVirg);
                        prenom = enregistrement.substring(posVirg+8);
                    }
                    System.out.println("*" +nom+"*"+ prenom +"*");
                }
                else
                {
                    prenom = enregistrement.substring(7,posVirg);
                    nom = enregistrement.substring(posVirg+5);

                    System.out.println(prenom + " " + nom);
                }

                nom = nom.trim();
                if(prenom != null){prenom = prenom.trim();}

                lstPersonne.add(new Personne(nom,prenom));
            }
            sc.close();
        }
        catch(Exception e){ e.printStackTrace();}

        for(Personne p: lstPersonne){System.out.println(p);}

    }
}

