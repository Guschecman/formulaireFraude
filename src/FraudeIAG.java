import java.time.LocalDate;

public class FraudeIAG extends Fraude {

    private String nomService;

    public FraudeIAG(LocalDate dateReleve, String description, String contenu, Type type, String nomService) {
        super(dateReleve, description, contenu, type);
        this.nomService = nomService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    @Override
    public void afficher() {
        System.out.println("IAG : " + getDetails()
                + " Service : " + nomService);
    }
}
