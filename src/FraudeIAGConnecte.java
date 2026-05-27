import java.time.LocalDate;

public class FraudeIAGConnecte extends FraudeIAG {

    private String adresseIP;

    public FraudeIAGConnecte(LocalDate dateReleve, String description, String contenu, Type type, String nomService, String adresseIP) {
        super(dateReleve, description, contenu, type, nomService);
        this.adresseIP = adresseIP;
        setType(Type.IAG_CONNECTEE);
    }

    public String getAdresseIP() {
        return adresseIP;
    }

    public void setAdresseIP(String adresseIP) {
        this.adresseIP = adresseIP;
    }

    @Override
    public void afficher() {
        System.out.println("IAG Connectée " + getDetails()
                + "  Service : " + getNomService()
                + "  IP : " + adresseIP);
    }

}
