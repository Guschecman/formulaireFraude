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
               // case 4 ->
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
}
