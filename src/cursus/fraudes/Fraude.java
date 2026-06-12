package cursus.fraudes;

import java.time.LocalDate;

/**
 * @brief Classe Fraude.
 */
public abstract class Fraude {
    private LocalDate dateReleve;
    private String description;
    private String contenu;
    private Type type;

    /**
     * @brief Constructeur de la classe Fraude.
     */
    /*public Fraude(LocalDate dateReleve, String description, String contenu, Type type) {
        this.dateReleve = dateReleve;
        this.description = description;
        this.contenu = contenu;
        this.type = type;
    }*/

    /**
     * @brief Donne la date de la fraude.
     * @return la date.
     */
    public LocalDate getDateReleve() {
        return dateReleve;
    }


    /**
     * @brief Set la date de la fraude.
     * @param dateReleve
     */
    public void setDateReleve(LocalDate dateReleve) {
        this.dateReleve = dateReleve;
    }

    /**
     * @brief Donne la description de la fraude.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @brief Set la description.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @brief Donne le contenu de la fraude.
     * @return contenu.
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * @brief set le contenu de la fraude.
     * @param contenu
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * @brief Donne le type de fraude.
     * @return le type.
     */
    public Type getType() {
        return type;
    }

    /**
     * @brief Set le type de fraude.
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @brief Fonction d'affichage
     */
    public abstract void afficher();

    /**
     * @brief donne les details sous forme de texte.
     * @return les infos.
     */
    public String getDetails() {
        return "Type : " + type
                + "  Date : " + dateReleve
                + "  Description : " + description
                + "  Contenu : " + contenu;
    }
}
