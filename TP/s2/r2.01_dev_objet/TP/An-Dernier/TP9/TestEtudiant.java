import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import utilitaire.Etudiant;

public class TestEtudiant
{
    public static void main(String[] a)
    {
        Etudiant etudiant;
        List<Etudiant> lstEtudiant;

        lstEtudiant = new ArrayList<Etudiant>();
        lstEtudiant.add(new Etudiant("Menvussa","Gérard",15));
        lstEtudiant.add(new Etudiant("Judas"   ,"Bricot",14));
        lstEtudiant.add(new Etudiant("Jacques" ,"Ouzzi" ,13));

        System.out.println(lstEtudiant);
        Collection.sort(lstEtudiant);
        System.out.println(lstEtudiant);

        System.out.println("----------------");
        System.out.println("  Exercice 2.2  ");
        System.out.println("----------------");

        System.out.println("\nMethode 1");
        System.out.println(lstEtudiant);

        System.out.println("\nMethode 2");
        for(int cpt=0;cpt<lstEtudiant.size();cpt++)
        {
            System.out.println(lstEtudiant.get(cpt));
        }

        System.out.println("\nMethode 3");
        for(Etudiant etd : lstEtudiant)
        {
            System.out.println(etd);
        }

        System.out.println();

        System.out.println("----------------");
        System.out.println("  Exercice 2.3  ");
        System.out.println("----------------");

        double somme = 0.0;
        double moyenne;

        for(Etudiant etd : lstEtudiant)
        {
            somme += etd.getMoyenne();
        }

        moyenne = somme /lstEtudiant.size();

        System.out.println(String.format("%.2f",moyenne));

        System.out.println();

        System.out.println("----------------");
        System.out.println("  Exercice 2.4  ");
        System.out.println("----------------");

        lstEtudiant.add(0,new Etudiant("Lairbon","Oussama",13));

        for(int cpt=0;cpt<lstEtudiant.size();cpt++)
        {
            System.out.println(lstEtudiant.get(cpt));
        }

        System.out.println();

        System.out.println("----------------");
        System.out.println("  Exercice 2.5  ");
        System.out.println("----------------");

        lstEtudiant.add(2,new Etudiant("Patamob","Alphonse",9));

        for(int cpt=0;cpt<lstEtudiant.size();cpt++)
        {
            System.out.println(lstEtudiant.get(cpt));
        }

        System.out.println();

        System.out.println("----------------");
        System.out.println("  Exercice 2.6  ");
        System.out.println("----------------");

        lstEtudiant.remove(1);

        for(int cpt=0;cpt<lstEtudiant.size();cpt++)
        {
            System.out.println(lstEtudiant.get(cpt));
        }

        System.out.println();

        System.out.println("----------------");
        System.out.println("  Exercice 2.7  ");
        System.out.println("----------------");

        List<Integer> lstNombre = new ArrayList<Integer>();

        for(int cpt=0; cpt<100;cpt++)
        {
            lstNombre.add((int)(Math.random()*21)+10);
        }

        for(int cpt=0;cpt<lstNombre.size();cpt++)
        {
            System.out.print(lstNombre.get(cpt)+" ");
            if((cpt+1)%10==0)System.out.println();
        }

        System.out.println();
        System.out.println(" Sans les 20  ");
        System.out.println();

        while(lstNombre.remove((Integer)20));

        for(int cpt=0;cpt<lstNombre.size();cpt++)
        {
            System.out.print(lstNombre.get(cpt)+" ");
            if((cpt+1)%10==0)System.out.println();
        }

    }
}