import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();


        Fraude f1 = new FraudePapier(date, "Antisèche trouvée", "Formules de maths", Type.PAPIER, "5cm", true);


        ArrayList<Fraude> fraude = new ArrayList<>();
        fraude.add(f1);
            f1.afficher();

            Systeme systeme = new Systeme();
            systeme.demarrer();
        }
    }
