package cursus.fraudes;

import java.time.LocalDate;

/**
 * @brief Classe FraudeCalculatrice
 */
public class FraudeCalculatrice extends Fraude {

    private String marque;
    private String programme;

    public FraudeCalculatrice(LocalDate dateReleve, String description, String contenu, String marque, String programme) {
        super.setDateReleve(dateReleve);
        super.setDescription(description);
        super.setContenu(contenu);
        this.marque = marque;
        this.programme = programme;
        setType(Type.CALCULATRICE);
    }

    /**
     * @brief Donne la marque de la calculatrice.
     * @return la marque.
     */
    public String getMarque() {
        return marque;
    }

    /**
     * @brief Set la marque.
     * @param marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * @brief donne le programme.
     * @return le programme.
     */
    public String getProgramme() {
        return programme;
    }

    /**
     * @brief set le programme.
     * @param programme
     */
    public void setProgramme(String programme) {
        this.programme = programme;
    }

    /**
     * @brief Affiche les infos de la fraude.
     */
    @Override
    public void afficher() {
        System.out.println("Calculatrice " + getDetails()
                + "  Marque : " + marque
                + "  Programme : " + programme);
    }
}
