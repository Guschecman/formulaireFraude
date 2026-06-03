import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Formulaire {
    private static int nbFormulaires = 0;

    private int id;
    private LocalDate dateCreation;
    private LocalDate dateModification;
    private List<Etudiant> etudiants;
    private List<Fraude> fraudes;
    private Epreuve epreuve;

    public Formulaire() {
        nbFormulaires+=1;
        id = nbFormulaires;
        GestionnaireFormulaire.setFormulaires(this);
        dateCreation = LocalDate.now();
        dateModification = LocalDate.now();
        this.etudiants = new ArrayList<>();
        this.fraudes = new ArrayList<>();
    }

    public String toStringLong() {
        return "\nFormulaire{" +
                "id : " + id +
                "\n Date de création : " + dateCreation +
                "\n Date de dernière modification : " + dateModification +
                "\n Etudiant(e)(s) concerné(e)(s) : " + etudiants +
                "\n Fraude(s) observée(s) : " + fraudes +
                "\n Epreuve concernée : " + epreuve +
                '}';
    }

    public String toStringCourt() {
        return "\nFormulaire{" +
                "id : " + id +
                "\t dateCreation : " + dateCreation +
                "\t dateModification : " + dateModification +
                '}';
    }

    public int getId() {
        return id;
    }

    public static int getNbFormulaires() {
        return nbFormulaires;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public List<Fraude> getFraudes() {
        return fraudes;
    }

    public void setEtudiants(Etudiant etudiant) {
        this.etudiants.add(etudiant);
        dateModification = LocalDate.now();
    }

    public void setFraudes(Fraude fraude) {
        this.fraudes.add(fraude);
        dateModification = LocalDate.now();
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
        dateModification = LocalDate.now();
    }

    public static void setNbFormulaires(int nbFormulaires) {
        Formulaire.nbFormulaires = nbFormulaires;
    }
}
