import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        Systeme systeme = new Systeme();


        Etudiant e1 = new Etudiant("E001", "Dupont", "Jean", Cursus.E1);
        Etudiant e2 = new Etudiant("E002", "Manchec", "Auguste", Cursus.E1);


        Etudiant.tousLesEtudiants.add(e1);
        Etudiant.tousLesEtudiants.add(e2);



        systeme.demarrer();
    }
}