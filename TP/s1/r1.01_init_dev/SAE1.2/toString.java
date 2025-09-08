public class toString
{
	public static String toString(int[] tab) {
        String sep = "+--------+--------+--------+--------+ . . . . +--------+--------+--------+--------+\n";

        // Affichage des 4 premières valeurs du tableau
        sep += "|";
        for (int cpt1 = 0; cpt1 < 4; cpt1++) {
            sep += String.format(" %-6d |", tab[cpt1]);
        }
        sep += ". . . . |";
        for (int cpt1 = tab.length - 4; cpt1 < tab.length; cpt1++) {
            sep += String.format(" %-6d |", tab[cpt1]);
        }
        sep += "\n";

        // Ligne séparatrice horizontale après l'affichage des valeurs
        sep += "+--------+--------+--------+--------+ . . . . +--------+--------+--------+--------+\n";

        // Affichage des indices du tableau
        sep += "|";
        for (int cpt2 = 0; cpt2 < tab.length; cpt2++) {
            sep += String.format("%-5d |", cpt2);
        }
        sep += "\n";

        return sep;
    }
}








