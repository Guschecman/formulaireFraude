import java.time.LocalDate;

public class FraudePapier extends Fraude {

    private String dimensions;
    private boolean estPlie;

    public FraudePapier(LocalDate dateReleve, String description, String contenu, Type type, String dimensions, boolean estPlie) {
        super(dateReleve, description, contenu, type);
        this.dimensions = dimensions;
        this.estPlie = estPlie;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isEstPlie() {
        return estPlie;
    }

    public void setEstPlie(boolean estPlie) {
        this.estPlie = estPlie;
    }

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
