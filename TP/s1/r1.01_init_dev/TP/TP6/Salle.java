import iut.algo.Clavier;

public class Salle
{
    public static void main(String[] args)
    {
        /*------------*/
        /* Variables  */
        /*------------*/
        int ref;
        int site, type, dep, etage, numSalle;

        String nomSite, nomType, nomDep;
        
        /*--------------*/
        /* Instruction  */
        /*--------------*/

        System.out.print("Entrer une reference : ");
        ref = Clavier.lire_int();

        nomSite = "";
        nomType = "";
        nomDep = "";

        site = ref / 1000000;
        type = (ref / 100000 ) % 10;
        dep = (ref / 1000 ) % 100 ;
        etage = (ref / 100 ) % 10 ;
        numSalle = ref % 100;

        //System.out.println("Salle : " + site + "-" + type + "-" + dep + "-" + etage + "-" + numSalle);

        switch(site)
        {
            case 1 : nomSite = "caucriauville"; break;
            case 2 : nomSite = "frissard"     ; break;
        }

        switch(type)
        {
            case 1 : nomType = "amphi"               ; break;
            case 2 : nomType = "salle TD"            ; break;
            case 3 : nomType = "salle informatique"  ; break;
            case 4 : nomType = "labo de langue"      ; break;
            case 9 : nomType = "spécifique"          ; break;
        }

        switch(dep)
        {
            case 1  : nomDep = "Carrière Sociales"                                 ; break;
            case 2  : nomDep = "Génie Civil"                                       ; break;
            case 3  : nomDep = "Gestion des Entreprises et des Asministrations"    ; break;
            case 4  : nomDep = "Génie Electrique et Informatique Industrielle"     ; break;
            case 5  : nomDep = "Gestion Logistique et Transport"                   ; break;
            case 6  : nomDep = "Génie Mécanique et Productique"                    ; break;
            case 7  : nomDep = "Hygiène et Sécurité"                               ; break;
            case 8  : nomDep = "Information et Communication"                      ; break;
            case 9  : nomDep = "Informatique"                                      ; break;
            case 10 : nomDep = "Technique de Commercialisation"                   ; break;
            case 99 : nomDep = "Non affectée"                                     ; break;
        }

        System.out.println(
            "site        : " + nomSite + "\n" +
            "type        : " + nomType + "\n" +
            "departement : " + nomDep  + "\n" +
            "etage       : " + etage   + "\n" +
            "salle       : " + numSalle
        );
    
    }

}