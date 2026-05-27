import java.time.LocalDate;

public class FraudeCalculatrice extends Fraude{

    private String marque;
    private String programme;

    public FraudeCalculatrice(LocalDate dateReleve, String description, String contenu, Type type, String marque, String programme) {
        super(dateReleve, description, contenu, type);
        this.marque = marque;
        this.programme = programme;
    }

    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getProgramme() {
        return programme;
    }
    public void setProgramme(String programme) {
        this.programme = programme;
    }

    @Override
    public void afficher() {
        System.out.println("Calculatrice " + getDetails()
                + "  Marque : " + marque
                + "  Programme : " + programme);
    }
}
