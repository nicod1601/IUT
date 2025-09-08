import java.util.ArrayList;

interface ICalculBase {
    Double moyenne();
    Double min();
    Double max();
}

interface ICalcul extends ICalculBase {
    Double somme();
}

class Etudiant implements ICalcul {
    private String nom;
    private String prenom;
    private ArrayList<Double> ensNote;

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.ensNote = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void ajouterNote(Double note) {
        ensNote.add(note);
    }

    public Double somme() {
        return ensNote.stream().mapToDouble(Double::doubleValue).sum();
    }

    public Double moyenne() {
        return ensNote.isEmpty() ? 0.0 : somme() / ensNote.size();
    }

    public Double min() {
        return ensNote.isEmpty() ? 0.0 : ensNote.stream().min(Double::compareTo).orElse(0.0);
    }

    public Double max() {
        return ensNote.isEmpty() ? 0.0 : ensNote.stream().max(Double::compareTo).orElse(0.0);
    }
}

class Groupe implements ICalculBase {
    private char nom;
    private ArrayList<Etudiant> ensEtudiant;

    public Groupe(char nom) {
        this.nom = nom;
        this.ensEtudiant = new ArrayList<>();
    }

    public char getNom() {
        return nom;
    }

    public void ajouterEtudiant(Etudiant e) {
        ensEtudiant.add(e);
    }

    public Etudiant getEtudiant(int indice) {
        return (indice >= 0 && indice < ensEtudiant.size()) ? ensEtudiant.get(indice) : null;
    }

    public Double moyenne() {
        return ensEtudiant.stream().mapToDouble(Etudiant::moyenne).average().orElse(0.0);
    }

    public Double min() {
        return ensEtudiant.stream().mapToDouble(Etudiant::moyenne).min().orElse(0.0);
    }

    public Double max() {
        return ensEtudiant.stream().mapToDouble(Etudiant::moyenne).max().orElse(0.0);
    }

    public String toString() {
        return nom + " (" + ensEtudiant.size() + " étudiants)";
    }
}

class GroupeSpecial extends Groupe {
    private int annee;

    public GroupeSpecial(char nom, int annee) {
        super(nom);
        this.annee = annee;
    }

    public int getAnnee() {
        return this.annee;
    }

    public String toString() {
        return super.toString() + " - " + annee;
    }
}
