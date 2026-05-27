import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();

        // Ton code de base pour la fraude
        Fraude f1 = new FraudePapier(date, "Antisèche trouvée", "Formules de maths", Type.PAPIER, "5cm", true);

        ArrayList<Fraude> fraude = new ArrayList<>();
        fraude.add(f1);
        f1.afficher();


        Systeme systeme = new Systeme();


        Etudiant e1 = new Etudiant("E001", "Dupont", "Jean", Cursus.E1);


        Etudiant.tousLesEtudiants.add(e1);


        systeme.demarrer();
    }
}