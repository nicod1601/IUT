import iut.algo.Clavier;

public class Version2FL
{
    public static void main(String[] args)
    {
        /*-------------- */
        /* Constante     */
        /*-------------- */
        final int TAILLEMAX = 50;
        
        /*-------------- */
        /* Variables     */
        /*-------------- */
        char[] tab = new char[TAILLEMAX];
        int compteur, taille, nbLettre, cpt;
        char cara;
        double proba;
        boolean finPhrase = false; // Variable pour contrôler la fin de la phrase

        /*-------------- */
        /* Instructions  */
        /*-------------- */
        nbLettre = 0;
        taille = 0;
        cpt = 0;
        
        // Lecture de la phrase caractère par caractère
        while (cpt < TAILLEMAX && !finPhrase) // La boucle continue tant que le point n'est pas rencontré
        {
            System.out.print("Entrer une phrase : ");
            tab[cpt] = Clavier.lire_char(); // Lecture du caractère

            if (tab[cpt] == '.') // Détecter la fin de la phrase
            {
                finPhrase = true; // Indiquer que la phrase est terminée
            }
            else
            {
                taille++; // Incrémenter la taille de la phrase seulement si ce n'est pas un point
            }

            cpt++; // Incrémenter l'index
        }

        cara = 'A';
        compteur = 0;

        // Comptage des lettres
        while (cara <= 'Z') 
        {
            for (int cpt1 = 0; cpt1 < taille; cpt1++) 
            {
                if (tab[cpt1] == cara || tab[cpt1] == (cara + 32)) // Vérifie majuscule et minuscule
                {
                    compteur++;
                    nbLettre++;
                }
            }
            proba = (double) compteur / taille * 100; // Utilisation de 'taille' et non 'tab.length'
            if (proba != 0) 
            {
                System.out.println("La lettre " + cara + " est présente " + compteur + " fois, soit " + String.format("%.2f", proba) + "%");
            }
            cara++;
            compteur = 0;
        }

        System.out.println("Taille de la phrase : " + taille);
        System.out.println("Nombre de lettres   : " + nbLettre);
    }
}
