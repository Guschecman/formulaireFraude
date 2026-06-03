import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        Systeme systeme = new Systeme();


        Etudiant e1 = new Etudiant("E001", "Dupont", "Jean", Cursus.E1);
        Etudiant e2 = new Etudiant("E002", "Manchec", "Auguste", Cursus.E1);
        Etudiant e3 = new Etudiant("E003", "Manori", "Auguste", Cursus.E1);


        Etudiant.tousLesEtudiants.add(e1);
        Etudiant.tousLesEtudiants.add(e2);
        Etudiant.tousLesEtudiants.add(e3);

        Epreuve ep1 = new Epreuve("A1", date, 120, Modalite.TP);
        Epreuve ep2 = new Epreuve("A2", date, 150, Modalite.TP);
        Epreuve ep3 = new Epreuve("A3", date, 110, Modalite.TP);
        Epreuve ep4 = new Epreuve("A4", date, 130, Modalite.TP);

        Epreuve.toutesLesEpreuves.add(ep1);
        Epreuve.toutesLesEpreuves.add(ep2);
        Epreuve.toutesLesEpreuves.add(ep3);
        Epreuve.toutesLesEpreuves.add(ep4);




        systeme.demarrer();
    }
}