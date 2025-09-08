public class Pile {
    public char[] tabCara;

    // Constructeur
    public Pile() {
        this.tabCara = new char[3];
        for (int cpt = 0; cpt < this.tabCara.length; cpt++) {
            this.tabCara[cpt] = ' ';
        }
    }

    // Méthode pour empiler un caractère
    public void empiler(char c) {

        for (int cpt = this.tabCara.length-1; cpt >= 0; cpt--)
		{
            if (this.tabCara[cpt] == ' ') 
			{
                this.tabCara[cpt] = c;
				c = ' ';
            }
        }
    }

    // Méthode pour enlever le dernier élément empilé
    public void enlever() {
        for (int cpt = 0; cpt < this.tabCara.length; cpt++) {
            if (this.tabCara[cpt] != ' ') {
                this.tabCara[cpt] = ' '; // Supprime le premier élément non vide
                cpt = this.tabCara.length; // Empêche toute autre suppression
            }
        }
    }

    // Méthode pour afficher la pile sous forme de chaîne
    public String toString() {
        String sRet = "";

        for (int cpt = 0; cpt < this.tabCara.length; cpt++) {
            sRet += (this.tabCara.length - cpt) + "| ";
            sRet += this.tabCara[cpt] + " ";
            sRet += "\n";
        }
        return sRet;
    }

    // Méthode principale pour tester
    public static void main(String[] args) {
        Pile pile = new Pile();
        pile.empiler('A');
        pile.empiler('B');
        pile.empiler('C');
        pile.enlever();
        System.out.println(pile.toString());
    }
}
