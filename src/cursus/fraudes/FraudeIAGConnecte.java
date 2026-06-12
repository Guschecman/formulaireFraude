package cursus.fraudes;

import java.time.LocalDate;

/**
 * Classe FraudeIAGConnecte.
 */
public class FraudeIAGConnecte extends FraudeIAG {

    private String adresseIP;

    /**
     * Constructeur de la classe FraudeIAGConnecte.
     * @param dateReleve
     * @param description
     * @param contenu
     * @param nomService
     * @param adresseIP
     */
    public FraudeIAGConnecte(LocalDate dateReleve, String description, String contenu, String nomService, String adresseIP) {
        super(dateReleve, description, contenu, nomService);
        this.adresseIP = adresseIP;
        setType(Type.IAG_CONNECTEE);
    }

    /**
     * Donne l'adresse IP.
     * @return l'adresse.
     */
    public String getAdresseIP() {
        return adresseIP;
    }

    /**
     * @brief Set l'adresse IP.
     * @param adresseIP
     */
    public void setAdresseIP(String adresseIP) {
        this.adresseIP = adresseIP;
    }

    /**
     *@brief Donne les infos sous forme de texte de la fraude.
     */
    @Override
    public void afficher() {
        System.out.println("IAG Connectée " + getDetails()
                + "  Service : " + getNomService()
                + "  IP : " + adresseIP);
    }

}
