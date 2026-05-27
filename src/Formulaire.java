import java.time.LocalDate;

public class Formulaire {
    private static int nbFormulaires = 0;

    private int id;
    private LocalDate dateCreation;
    private LocalDate dateModification;

    public Formulaire() {
        nbFormulaires+=1;
        id = nbFormulaires;
        dateCreation = LocalDate.now();
        dateModification = LocalDate.now();
    }

    public int getId() {
        return id;
    }
}
