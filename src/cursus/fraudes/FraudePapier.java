package cursus.fraudes;

import java.time.LocalDate;

/**
 * @brief Classe FraudePapier.
 */
public class FraudePapier extends Fraude {

    private String dimensions;
    private boolean estPlie;

    /**
     * @brief Constructeur de la classe FraudePapier.
     * @param dateReleve
     * @param description
     * @param contenu
     * @param dimensions
     * @param estPlie
     */
    public FraudePapier(LocalDate dateReleve, String description, String contenu, String dimensions, boolean estPlie) {
        super.setDateReleve(dateReleve);
        super.setDescription(description);
        super.setContenu(contenu);
        this.dimensions = dimensions;
        this.estPlie = estPlie;
        setType(Type.PAPIER);
    }

    /**
     * @brief Donne les dimensions.
     * @return les dimensions.
     */
    public String getDimensions() {
        return dimensions;
    }

    /**
     * @brief Set les dimensions.
     * @param dimensions
     */
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * @brief Donne l'info de si le papier est plie.
     * @return true s'il est plie, false sinon.
     */
    public boolean isEstPlie() {
        return estPlie;
    }

    /**
     * @brief Set le boolean estPlie.
     * @param estPlie
     */
    public void setEstPlie(boolean estPlie) {
        this.estPlie = estPlie;
    }

    /**
     * @brief Donne les infos de la fraude sous forme de texte.
     */
    @Override
    public void afficher() {
        String etatPlie;
        if (estPlie) {
            etatPlie = "oui";
        } else {
            etatPlie = "non";
        }
        System.out.println("Papier " + getDetails()
                + "  Dimensions : " + dimensions
                + "  Plié : " + etatPlie);
    }
}
