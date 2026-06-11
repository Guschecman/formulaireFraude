package cursus;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe Etudiant.
 */
public class Etudiant {
    private String numeroApprenant;
    private String nom;
    private String prenom;
    private Cursus cursus;

    /**
     * @brief Constructeur de la classe Etudiant.
     * @param numeroApprenant
     * @param nom
     * @param prenom
     * @param cursus
     */
    public Etudiant(String numeroApprenant, String nom, String prenom, Cursus cursus) {
        this.numeroApprenant = numeroApprenant;
        this.nom = nom;
        this.prenom = prenom;
        this.cursus = cursus;
    }
    /**
     * @brief Donne le numéro de l'etudiant.
     * @return Le numero.
     */
    public String getNumeroApprenant() {
        return numeroApprenant;
    }

    /**
     * @brief set le numero de l'etudiant
     * @param numeroApprenant
     */
    public void setNumeroApprenant(String numeroApprenant) {
        this.numeroApprenant = numeroApprenant;
    }

    /**
     * @brief donne le nom de l'etudiant.
     * @return le nom.
     */
    public String getNom() {
        return nom;
    }

    /**
     * @brief set le nom de l'etudiant.
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @brief donne le prenom
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @brief set le prenom de l'etudiant
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @brief donne le cursus
     * @return cursus
     */
    public Cursus getCursus() {
        return cursus;
    }

    /**
     * @brief set le cursus de l'etudiant
     * @param cursus
     */
    public void setCursus(Cursus cursus) {
        this.cursus = cursus;
    }




    public static List<Etudiant> tousLesEtudiants = new ArrayList<>();


    /**
     * @brief permet de rechercher un etudiant par son nom.
     * @param nom
     * @return une liste contenant les etudiants de la recherche.
     */
    public static List<Etudiant> rechercherParNom(String nom) {
        List<Etudiant> resultats = new ArrayList<>();
        for (int i = 0; i < tousLesEtudiants.size(); i++) {
            if (tousLesEtudiants.get(i).getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(tousLesEtudiants.get(i));
            }
        }
        return resultats;
    }
    /**
     * @brief permet de rechercher un etudiant par son prenom.
     * @param prenom
     * @return une liste contenant les etudiants de la recherche.
     */
    public static List<Etudiant> rechercherParPrenom(String prenom) {
        List<Etudiant> resultats = new ArrayList<>();
        for (int i = 0; i < tousLesEtudiants.size(); i++) {
            if (tousLesEtudiants.get(i).getPrenom().toLowerCase().contains(prenom.toLowerCase())) {
                resultats.add(tousLesEtudiants.get(i));
            }
        }
        return resultats;
    }
    /**
     * @brief permet de rechercher un etudiant par son numero.
     * @param numero
     * @return une liste contenant les etudiants de la recherche.
     */
    public static List<Etudiant> rechercherNumero(String numero) {
        List<Etudiant> resultats = new ArrayList<>();
        for (int i = 0; i < tousLesEtudiants.size(); i++) {
            if (tousLesEtudiants.get(i).getNumeroApprenant().equalsIgnoreCase(numero)) {
                resultats.add(tousLesEtudiants.get(i));
            }
        }
        return resultats;
    }

    /**
     * @brief permet de donner les infos sous forme de texte.
     * @return les infos sous forme de texte.
     */
    @Override
    public String
    toString() {
        return
                "numeroApprenant='" + numeroApprenant + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cursus=" + cursus ;
    }
}
