import java.util.*;

class Personnage {
    private static int compteurId = 1; // Numéro séquentiel auto-incrémenté
    private int id;
    private String nom;
    private int pv;

    public Personnage(String nom, int pv) {
        this.id = compteurId++;
        this.nom = nom;
        this.pv = pv;
    }

    @Override
    public String toString() {
        return nom + " (ID: " + id + ", PV: " + pv + ")";
    }
}

class Salle {
    private String nom;
    private List<Personnage> personnages;
    private Salle suivante; // Structure chaînée

    public Salle(String nom) {
        this.nom = nom;
        this.personnages = new ArrayList<>();
        this.suivante = null;
    }

    public void ajouterPersonnage(Personnage personnage) {
        personnages.add(personnage);
    }

    public void setSuivante(Salle suivante) {
        this.suivante = suivante;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Salle " + nom + " | Personnages: ");
        if (personnages.isEmpty()) {
            sb.append("Personne");
        } else {
            for (Personnage p : personnages) {
                sb.append(p.toString()).append(", ");
            }
            sb.setLength(sb.length() - 2); // Retirer la dernière virgule
        }
        return sb.toString();
    }
}

public class Donjon {
    public static void main(String[] args) {
        Salle salle1 = new Salle("Entrée");
        Salle salle2 = new Salle("Salle du Trésor");
        salle1.setSuivante(salle2); // Structure chaînée

        Personnage perso1 = new Personnage("Guerrier", 100);
        Personnage perso2 = new Personnage("Mage", 80);

        salle1.ajouterPersonnage(perso1);
        salle2.ajouterPersonnage(perso2);

        System.out.println(salle1);
        System.out.println(salle2);
    }
}
