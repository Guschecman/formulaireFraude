package cursus.fraudes;

import java.time.LocalDate;

/**
 * @brief Classe FraudeIAG.
 */
public class FraudeIAG extends Fraude {

    private String nomService;

    /**
     * @brief Constructeur de FraudeIAG.
     * @param dateReleve
     * @param description
     * @param contenu
     * @param nomService
     */
    public FraudeIAG(LocalDate dateReleve, String description, String contenu, String nomService) {
        super.setDateReleve(dateReleve);
        super.setDescription(description);
        super.setContenu(contenu);
        this.nomService = nomService;
        setType(Type.IAG);
    }

    /**
     * @brief Donne le nom du service.
     * @return Le nom du service.
     */
    public String getNomService() {
        return nomService;
    }

    /**
     * @brief Set le nom du service.
     * @param nomService
     */
    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    /**
     * Donne les infos sous forme de texte de la fraude.
     */
    @Override
    public void afficher() {
        System.out.println("IAG : " + getDetails()
                + " Service : " + nomService);
    }
}
