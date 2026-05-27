import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Systeme {


    public void demarrer(){
        int choix = 1;
        while(choix != 0){
            menu();
            choix = choix();
            switch (choix) {
               // case 1 ->
               // case 2 ->
               // case 3 ->
                case 4 -> rechercherEtu();
               // case 5 ->
               // case 6 ->
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Option invalide, réessayez.");
            }
        }
    }
    private void menu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Afficher tous les formulaires");
        System.out.println("2. Créer un formulaire");
        System.out.println("3. Supprimer un formulaire");
        System.out.println("4. Rechercher un étudiant");
        System.out.println("5. Afficher les statistiques");
        System.out.println("6. Afficher le graphe de plagiat");
        System.out.println("0. Quitter");

    }
    Scanner scanner = new Scanner(System.in);
    public int choix() {
        System.out.print("Ecrivez un nombre : ");
        int nombre = scanner.nextInt();
        scanner.nextLine();
        return nombre;
    }

    public void rechercherEtu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n1. Par nom");
        System.out.print("\n2. Par prénom");
        System.out.print("\n3. Par numéro");
        System.out.print("\nEcrivez un nombre : ");
        int nombre = scanner.nextInt();
        scanner.nextLine();

        List<Etudiant> resultats = new ArrayList<>();

        if (nombre == 1) {
            System.out.print("\nEcrivez un nom : ");
            String nom = scanner.next();
            resultats = Etudiant.rechercherParNom(nom);
        }
        else if (nombre == 2) {
            String prenom = scanner.next();
            resultats = Etudiant.rechercherParPrenom(prenom);
        }
        else if (nombre == 3) {

        }
        System.out.println("\n--- Résultat de la recherche ---");
        if (resultats.isEmpty()) {
            System.out.println("Aucun étudiant trouvé !");
        } else {
            for (int i = 0; i < resultats.size(); i++) {
                System.out.println("Trouvé : " + resultats.get(i).getNom() + " " + resultats.get(i).getPrenom());
            }
        }

    }

}
