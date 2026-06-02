import java.time.LocalDate;
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
                case 2 -> creerFormulaire();
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
            System.out.print("\nEcrivez un prénom : ");
            String prenom = scanner.next();
            resultats = Etudiant.rechercherParPrenom(prenom);
        }
        else if (nombre == 3) {
            System.out.print("\nEcrivez un numéro : ");
            String num = scanner.next();
            resultats = Etudiant.rechercherNumero(num);
        }
        System.out.println("\n--- Résultat de la recherche ---");
        if (resultats.isEmpty()) {
            System.out.println("Aucun étudiant trouvé !");
        } else {
            for (int i = 0; i < resultats.size(); i++) {
                System.out.println("Trouvé : " + resultats.get(i).getNom() + " " + resultats.get(i).getPrenom() + " " + resultats.get(i).getNumeroApprenant());
            }
        }

    }



    public void creerFormulaire(){
        System.out.print("\n========CREATION D'UN FORMULAIRE =======");
        int continuer = 1;
        Formulaire nouveauFormulaire = new Formulaire();
        do {
            System.out.print("Entrez un nom : ");
            String nom = scanner.next();
            List<Etudiant> resultats = Etudiant.rechercherParNom(nom);
            if (resultats.isEmpty()) {
                System.out.print("Aucun étudiant trouvé !");
            }
            Etudiant etudiant = resultats.get(0);

            System.out.println("\nQuel est le type de fraude ?");
            System.out.println("1. Fraude Papier");
            System.out.println("2. Fraude Calculatrice");
            System.out.println("3. Fraude IA Générative (Standard)");
            System.out.println("4. Fraude IA Générative Connectée");
            System.out.print("Votre choix : ");
            int typeFraude = scanner.nextInt();
            Fraude nouvelleFraude = null;
            LocalDate date = LocalDate.now();
            switch (typeFraude) {
                case 1 -> {
                    System.out.print("Dimensions  : ");
                    String dimensions = scanner.nextLine();
                    System.out.print("Est-elle pliée ? (true/false) : ");
                    boolean estPlie = scanner.nextBoolean();
                    System.out.print("Description  : ");
                    String description = scanner.nextLine();
                    System.out.print("Contenu :");
                    String contenu = scanner.nextLine();
                    scanner.nextLine();


                    nouvelleFraude = new FraudePapier(date, description, contenu, Type.PAPIER, dimensions, estPlie);
                }
                case 2 -> {
                    System.out.print("Marque de la calculatrice  : ");
                    String marque = scanner.nextLine();
                    System.out.print("Nom du programme  : ");
                    String programme = scanner.nextLine();
                    System.out.print("Description  : ");
                    String description = scanner.nextLine();
                    System.out.print("Contenu :");
                    String contenu = scanner.nextLine();

                    nouvelleFraude = new FraudeCalculatrice(date, description, contenu, Type.CALCULATRICE, marque, programme);
                }
                case 3 -> {
                    System.out.print("Nom du service d'IA : ");
                    String nomService = scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Contenu : ");
                    String contenu = scanner.nextLine();

                    nouvelleFraude = new FraudeIAG(date, description, contenu, Type.IAG, nomService);
                }
                case 4 -> {
                    System.out.print("Nom du service d'IA : ");
                    String nomService = scanner.nextLine();
                    System.out.print("Adresse IP source : ");
                    String adresseIP = scanner.nextLine();
                    System.out.print("Description  : ");
                    String description = scanner.nextLine();
                    System.out.print("Contenu :");
                    String contenu = scanner.nextLine();


                    nouvelleFraude = new FraudeIAGConnecte(date, description, contenu, Type.IAG_CONNECTEE, nomService, adresseIP);
                }
                default -> {
                    System.out.println("Choix invalide. Annulation de la création.");
                    return;
                }
            }

            nouveauFormulaire.setEtudiants(etudiant);
            nouveauFormulaire.setFraudes(nouvelleFraude);

            System.out.print("\nVoulez-vous ajouter une autre personne avec une fraude différente dans ce formulaire ? (1: Oui, 0: Non) : ");
            continuer = scanner.nextInt();
            scanner.nextLine();

            }while(continuer ==1);

            GestionnaireFormulaire.setFormulaires(nouveauFormulaire);


    }


}
