public class Carte {
    // Attributs privés
    private static int nbcarte = 0; // Attribut statique partagé par toutes les instances
    private int numero;            // Numéro unique de la carte
    private String type;           // Type de la carte
    private String nom;            // Nom de la carte

    // Constructeur
    public Carte(int numero, String type, String nom) {
        this.numero = numero;
        this.type = (type != null) ? type : "Inconnu"; // Validation de type
        this.nom = (nom != null) ? nom : "Sans nom";   // Validation de nom
        Carte.nbcarte++; // Mise à jour de l'attribut statique
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }

    // Méthode toString pour afficher la carte dans un format esthétique
    @Override
    public String toString() {
        String nomFormate = String.format("%-24s", this.nom); // Alignement sur 24 caractères
        String typeFormate = String.format("%-24s", this.type); // Alignement sur 24 caractères

        return " +----------------------------------+ " + "\n" +
               " |                                  | " + "\n" +
               " |   +--------+                     | " + "\n" +
               " |   |        |                     | " + "\n" +
               " |   |        |                     | " + "\n" +
               " |   |        |                     | " + "\n" +
               " |   +--------+                     | " + "\n" +
               " |                                  | " + "\n" +
               " |   Nom  : " + nomFormate + "| " + "\n" +
               " |   Type : " + typeFormate + "| " + "\n" +
               " |                                  | " + "\n" +
               " |                    Numéro : " + String.format("%-1d", this.numero )+ " / " + String.format("%-1d", Carte.nbcarte) + "| " + "\n" +
               " +----------------------------------+ ";
    }
}
