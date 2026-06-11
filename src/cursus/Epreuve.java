package cursus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @brief classe Epreuve.
 */
public class Epreuve {
    public static List<Epreuve> toutesLesEpreuves = new ArrayList<>();
    private String ECUE;
    private LocalDate dateHeurePassage;
    private int duree;
    private Modalite modalite;

    /**
     * @brief Constructeur de la classe Epreuve.
     * Il crée une épreuve.
     * @param ECUE
     * @param dateHeurePassage
     * @param duree
     * @param modalite
     */
    public Epreuve(String ECUE, LocalDate dateHeurePassage, int duree, Modalite modalite) {
        this.ECUE = ECUE;
        this.dateHeurePassage = dateHeurePassage;
        this.duree = duree;
        this.modalite = modalite;

    }

    /**
     * @brief Donne la liste des épreuves.
     * @return une liste d'épreuve.
     */
    public static List<Epreuve> getEpreuves() {
        return toutesLesEpreuves;
    }

    /**
     * @brief Donne les modalites;
     * @return les modalites.
     */
    public Modalite getModalite() {
        return modalite;
    }

    /**
     * @brief set la modalite.
     * @param modalite
     */
    public void setModalite(Modalite modalite) {
        this.modalite = modalite;
    }

    /**
     * @brief donne la duree.
     * @return la duree.
     */
    public int getDuree() {
        return duree;
    }

    /**
     * @brief set la duree.
     * @param duree
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * @brief donne la date de passage.
     *
     * @return la date.
     */
    public LocalDate getDateHeurePassage() {
        return dateHeurePassage;
    }

    /**
     * @brief set la date de passage.
     * @param dateHeurePassage
     */
    public void setDateHeurePassage(LocalDate dateHeurePassage) {
        this.dateHeurePassage = dateHeurePassage;
    }

    /**
     * @brief donne le numero ECUE.
     * @return ECUE
     */
    public String getECUE() {
        return ECUE;
    }

    /**
     * @brief set le numero ECUE
     * @param ECUE
     */
    public void setECUE(String ECUE) {
        this.ECUE = ECUE;
    }

    /**
     * @brief permet de recherchee par le numero de l'epreuve.
     * @param numero
     * @return une liste contenant l'epreuve.
     */
    public static List<Epreuve> rechercherNumeroEpreuve(String numero) {
        List<Epreuve> resultats = new ArrayList<>();
        for (int i = 0; i < toutesLesEpreuves.size(); i++) {
            if (toutesLesEpreuves.get(i).getECUE().equalsIgnoreCase(numero)) {
                resultats.add(toutesLesEpreuves.get(i));
            }
        }
        return resultats;
    }

    /**
     * @brief Transforme les infos en texte.
     * @return Une phrase contenant les infos.
     */
    @Override
    public String toString() {
        return
                "ECUE='" + ECUE + '\'' +
                ", dateHeurePassage=" + dateHeurePassage +
                ", duree=" + duree +
                ", modalite=" + modalite ;
    }
}
