package cursus;
import systeme.*;
import cursus.fraudes.Fraude;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief Classe Formulaire.
 */
public class Formulaire {
    private static int nbFormulaires = 0;

    private int id;
    private LocalDate dateCreation;
    private LocalDate dateModification;
    private List<Etudiant> etudiants;
    private List<Fraude> fraudes;
    private Epreuve epreuve;
/**
 * @brief Constructeur de la classe Formulaire.
 */
    public Formulaire() {
        nbFormulaires+=1;
        id = nbFormulaires;
        GestionnaireFormulaire.setFormulaires(this);
        dateCreation = LocalDate.now();
        dateModification = LocalDate.now();
        this.etudiants = new ArrayList<>();
        this.fraudes = new ArrayList<>();
    }

    /**
     * @brief Ecriture de toutes les infos du formulaire.
     * @return les informations.
     */
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

    /**
     * @brief Ecriture des infos principales du formulaires.
     * @return les informations.
     */
    public String toStringCourt() {
        return "\nFormulaire{" +
                "id : " + id +
                "\t dateCreation : " + dateCreation +
                "\t dateModification : " + dateModification +
                '}';
    }

    /**
     * @brief donne l'identifiant
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @brief donne le nombre de formulaires
     * @return le nombre de formulaires
     */
    public static int getNbFormulaires() {
        return nbFormulaires;
    }

    /**
     * @brief recupere une liste contenant les etudiants
     * @return etudiants
     */
    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    /**
     * @brief recupere les epreuve
     * @return epreuve
     */
    public Epreuve getEpreuve() {
        return epreuve;
    }

    /**
     * @brief recupere les fraudes
     * @return fraudes
     */
    public List<Fraude> getFraudes() {
        return fraudes;
    }

    /**
     * @brief set un etudiant a un formulaire.
     * @param etudiant
     */
    public void setEtudiants(Etudiant etudiant) {
        this.etudiants.add(etudiant);
        dateModification = LocalDate.now();
    }

    /**
     * @brief set une fraude.
     * @param fraude
     */
    public void setFraudes(Fraude fraude) {
        this.fraudes.add(fraude);
        dateModification = LocalDate.now();
    }

    /**
     * @brief set une epreuve.
     * @param epreuve
     */
    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
        dateModification = LocalDate.now();
    }

    /**
     * @brief set le nombre de formulaires.
     * @param nbFormulaires
     */
    public static void setNbFormulaires(int nbFormulaires) {
        Formulaire.nbFormulaires = nbFormulaires;
    }

}
