import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private String numeroApprenant;
    private String nom;
    private String prenom;
    private Cursus cursus;


    public Etudiant(String numeroApprenant, String nom, String prenom, Cursus cursus) {
        this.numeroApprenant = numeroApprenant;
        this.nom = nom;
        this.prenom = prenom;
        this.cursus = cursus;
    }

    public String getNumeroApprenant() {
        return numeroApprenant;
    }

    public void setNumeroApprenant(String numeroApprenant) {
        this.numeroApprenant = numeroApprenant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Cursus getCursus() {
        return cursus;
    }

    public void setCursus(Cursus cursus) {
        this.cursus = cursus;
    }




    public static List<Etudiant> tousLesEtudiants = new ArrayList<>();

    public static List<Etudiant> rechercherParNom(String nom) {
        List<Etudiant> resultats = new ArrayList<>();
        for (int i = 0; i < tousLesEtudiants.size(); i++) {
            if (tousLesEtudiants.get(i).getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(tousLesEtudiants.get(i));
            }
        }
        return resultats;
    }

    public static List<Etudiant> rechercherParPrenom(String prenom) {
        List<Etudiant> resultats = new ArrayList<>();
        for (int i = 0; i < tousLesEtudiants.size(); i++) {
            if (tousLesEtudiants.get(i).getPrenom().toLowerCase().contains(prenom.toLowerCase())) {
                resultats.add(tousLesEtudiants.get(i));
            }
        }
        return resultats;
    }

    public static List<Etudiant> rechercherNumero(String numero) {
        List<Etudiant> resultats = new ArrayList<>();
        for (int i = 0; i < tousLesEtudiants.size(); i++) {
            if (tousLesEtudiants.get(i).getNumeroApprenant().equalsIgnoreCase(numero)) {
                resultats.add(tousLesEtudiants.get(i));
            }
        }
        return resultats;
    }

}
