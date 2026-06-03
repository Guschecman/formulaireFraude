import java.time.LocalDate;

public class FraudePapier extends Fraude {

    private String dimensions;
    private boolean estPlie;

    public FraudePapier(LocalDate dateReleve, String description, String contenu, String dimensions, boolean estPlie) {
        super.setDateReleve(dateReleve);
        super.setDescription(description);
        super.setContenu(contenu);
        this.dimensions = dimensions;
        this.estPlie = estPlie;
        setType(Type.PAPIER);
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
