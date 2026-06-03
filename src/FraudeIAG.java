import java.time.LocalDate;

public class FraudeIAG extends Fraude {

    private String nomService;

    public FraudeIAG(LocalDate dateReleve, String description, String contenu, String nomService) {
        super.setDateReleve(dateReleve);
        super.setDescription(description);
        super.setContenu(contenu);
        this.nomService = nomService;
        setType(Type.IAG);
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
