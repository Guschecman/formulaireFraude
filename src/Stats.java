import java.util.List;
import java.util.Scanner;

public class Stats {
    public void Stat(){
        Scanner scanner = null;
        System.out.print("\n======== STATISTIQUES =======");
        System.out.print("\nQuelles statistiques voulez-vous connaitre ? ");
        System.out.println("1. Nombre total de formulaires");
        System.out.println("2. Nombre d'étudiants distincts concernés");
        System.out.println("3. Nombre total de fraude enregistrées");
        System.out.println("4. Moyenne du nombre de fraudes par formulaire et écart-type");
        System.out.print("Votre choix : ");
        int nombre = scanner.nextInt();

        switch (nombre){
            case 1:
                System.out.println("Nombre total de formulaires : "+ Formulaire.getNbFormulaires());
                break;
            case 2:
                int totalEtudiants = 0;
                for (int i = 0; i < GestionnaireFormulaire.getFormulaires().size(); i++) {
                    Formulaire f = GestionnaireFormulaire.getFormulaires().get(i);
                    totalEtudiants += f.getEtudiants().size();
                }
                System.out.println("Nombre total d'étudiants : " + totalEtudiants);
                break;
            case 3:
                int totalFraudes = 0;
                for (int i = 0; i < GestionnaireFormulaire.getFormulaires().size(); i++) {
                    Formulaire f = GestionnaireFormulaire.getFormulaires().get(i);
                    totalFraudes += f.getFraudes().size();
                }

                System.out.println("Nombre total de fraudes enregistrées : " + totalFraudes);
                break;
        }

    }
}
