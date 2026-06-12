package systeme;

import cursus.*;
import cursus.fraudes.*;

import java.time.LocalDate;
import java.util.*;
/**
 * @brief Classe Systeme.
 */
public class Systeme {

    /**
     * @brief Lance la boucle principale de notre application.
     */
    public void demarrer() {
        int choix = 1;
        while (choix != 0) {
            menu();
            choix = choix();
            switch (choix) {
                case 1 -> rechercherFormulaire();
                case 2 -> creerFormulaire();
                case 3 -> supprFormulaire();
                case 4 -> rechercherEtu();
                case 5 -> stat();
                case 6 -> graphe();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Option invalide, réessayez.");
            }
        }
    }
    /**
     * @brief Affiche le menu principal textuel dans la console.
    */
    private void menu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Rechercher un formulaire");
        System.out.println("2. Créer un formulaire");
        System.out.println("3. Supprimer un formulaire");
        System.out.println("4. Rechercher un étudiant");
        System.out.println("5. Afficher les statistiques");
        System.out.println("6. Afficher le graphe de plagiat");
        System.out.println("0. Quitter");

    }

    Scanner scanner = new Scanner(System.in);
    /**
     * @brief Utilitaire pour récupérer proprement un entier tapé par l'utilisateur.
     * @return int Le nombre entier saisi par l'utilisateur.
     */
    public int choix() {
        System.out.print("Ecrivez un nombre : ");
        int nombre = scanner.nextInt();
        scanner.nextLine();
        return nombre;
    }
    /**
     * @brief Permet de chercher un étudiant dans la base de données du cursus.
     * * On demande à l'utilisateur s'il veut chercher par nom, prénom ou numéro d'apprenant.
     */
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
        } else if (nombre == 2) {
            System.out.print("\nEcrivez un prénom : ");
            String prenom = scanner.next();
            resultats = Etudiant.rechercherParPrenom(prenom);
        } else if (nombre == 3) {
            System.out.print("\nEcrivez un numéro : ");
            String num = scanner.next();
            resultats = Etudiant.rechercherNumero(num);
        }
        System.out.println("\n--- Résultat de la recherche ---");
        if (resultats.isEmpty()) {
            System.out.println("Aucun étudiant trouvé !");
        } else {
            for (int i = 0; i < resultats.size(); i++) {
                System.out.println(resultats.get(i).getNom() + " " + resultats.get(i).getPrenom() + " " + resultats.get(i).getNumeroApprenant());
            }
        }

    }

    /**
     * @brief Méthode qui gère le formulaire de création d'une fraude.
     * * Déroulement de la méthode :
     * 1. On affiche et on choisit l'épreuve concernée.
     * 2. On entre dans une boucle pour ajouter un ou plusieurs étudiants tricheurs.
     * 3. Pour chaque étudiant, on choisit le type de triche.
     * 4. On remplit les détails spécifiques au type.
     * 5. On ajoute tout ça dans l'objet Formulaire.
     */
    public void creerFormulaire() {
        System.out.println("\n========CREATION D'UN FORMULAIRE =======");
        int continuer = 1;
        Formulaire nouveauFormulaire = new Formulaire();


        List<Epreuve> epreuves = Epreuve.getEpreuves();
        for (int i = 0; i < epreuves.size(); i++) {
            System.out.println(epreuves.get(i).toString());
        }

        System.out.println("\nQuelle épreuve voulez-vous ajouter à ce formulaire ?");
        System.out.println("Tapez le numéro ECUE pour choisir.");
        System.out.println("Votre choix : ");
        String choixEpreuve = scanner.next();
        scanner.nextLine();
        List<Epreuve> resultEpreuves = Epreuve.rechercherNumeroEpreuve(choixEpreuve);
        Epreuve epreuve = resultEpreuves.get(0);
        nouveauFormulaire.setEpreuve(epreuve);

        do {
            System.out.print("\nEntrez un nom : ");
            String nom = scanner.next();
            List<Etudiant> resultats = Etudiant.rechercherParNom(nom);
            if (resultats.isEmpty()) {
                System.out.print("Aucun étudiant trouvé !");
            }
            for (int i = 0; i < resultats.size(); i++) {
                System.out.println(resultats.get(i).toString());
            }

            System.out.println("Entrez le numero apprenant de l'étudiant concerné");
            System.out.println("Votre choix : ");
            String choix = scanner.next();
            scanner.nextLine();
            List<Etudiant> autreResult = Etudiant.rechercherNumero(choix);
            Etudiant etudiant = autreResult.get(0);








            System.out.println("\nQuel est le type de fraude ?");
            System.out.println("1. Fraude Papier");
            System.out.println("2. Fraude Calculatrice");
            System.out.println("3. Fraude IA Générative (Standard)");
            System.out.println("4. Fraude IA Générative Connectée");
            System.out.print("Votre choix : ");
            int typeFraude = scanner.nextInt();
            scanner.nextLine();
            Fraude nouvelleFraude = null;
            LocalDate date = LocalDate.now();
            switch (typeFraude) {
                case 1 -> {
                    System.out.print("Dimensions  : ");
                    String dimensions = scanner.nextLine();
                    System.out.print("Est-elle pliée ? (true/false) : ");
                    boolean estPlie = scanner.nextBoolean();
                    scanner.nextLine();
                    System.out.print("Description  : ");
                    String description = scanner.nextLine();
                    System.out.print("Contenu :");
                    String contenu = scanner.nextLine();
                    scanner.nextLine();


                    nouvelleFraude = new FraudePapier(date, description, contenu, dimensions, estPlie);
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

                    nouvelleFraude = new FraudeCalculatrice(date, description, contenu, marque, programme);
                }
                case 3 -> {
                    System.out.print("Nom du service d'IA : ");
                    String nomService = scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Contenu : ");
                    String contenu = scanner.nextLine();

                    nouvelleFraude = new FraudeIAG(date, description, contenu, nomService);
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


                    nouvelleFraude = new FraudeIAGConnecte(date, description, contenu, nomService, adresseIP);
                }
                default -> {
                    System.out.println("Choix invalide. Annulation de la création.");
                    return;
                }
            }

            nouveauFormulaire.setEtudiants(etudiant);
            nouveauFormulaire.setFraudes(nouvelleFraude);
            Epreuve ep1 = new Epreuve("A1", date, 120, Modalite.TP);
            nouveauFormulaire.setEpreuve(ep1);

            System.out.print("\nVoulez-vous ajouter une autre personne avec une fraude différente dans ce formulaire ? (1: Oui, 0: Non) : ");
            continuer = scanner.nextInt();
            scanner.nextLine();

        } while (continuer == 1);




    }
    /**
     * @brief Supprime un formulaire du système.
     */
    public void supprFormulaire(){
        System.out.print("\n========SUPPRESSION D'UN FORMULAIRE =======");
        System.out.print("\nEntrez un ID : ");
        int idForm = scanner.nextInt();
        GestionnaireFormulaire.suppressionFormulaire(idForm);

    }

    /**
     * @brief Permet de retrouver un ou plusieurs formulaires via des filtres.
     */
    public void rechercherFormulaire(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n1. Par identifiant");
        System.out.print("\n2. Par nom");
        System.out.print("\n3. Par fraude");
        System.out.print("\n4. Par épreuve");
        System.out.print("\nEcrivez un nombre : ");
        int nombre = scanner.nextInt();
        scanner.nextLine();
        List<Formulaire> forms = new ArrayList<>();

        switch (nombre) {
            case 1 :
                System.out.print("\nEcrivez l'identifiant : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println(GestionnaireFormulaire.getFormulairesParId(id).toStringLong());
                break;
            case 2 :
                System.out.print("\nEcrivez le nom : ");
                String nom = scanner.nextLine();
                scanner.nextLine();
                forms = GestionnaireFormulaire.getFormulairesParEtudiant(nom);
                for (Formulaire form : forms) {
                    System.out.println(form.toStringCourt());
                }
                break;
            case 3 :
                System.out.println("\nQuel est le type de fraude ?");
                System.out.println("1. Fraude Papier");
                System.out.println("2. Fraude Calculatrice");
                System.out.println("3. Fraude IA Générative (Standard)");
                System.out.println("4. Fraude IA Générative Connectée");
                System.out.print("Votre choix : ");
                int typeFraude = scanner.nextInt();
                scanner.nextLine();
                switch(typeFraude){
                    case 1 -> forms = GestionnaireFormulaire.getFormulairesParFraude(Type.PAPIER);
                    case 2 -> forms = GestionnaireFormulaire.getFormulairesParFraude(Type.CALCULATRICE);
                    case 3 -> forms = GestionnaireFormulaire.getFormulairesParFraude(Type.IAG);
                    case 4 -> forms = GestionnaireFormulaire.getFormulairesParFraude(Type.IAG_CONNECTEE);
                }
                for (Formulaire form : forms) {
                    System.out.println(form.toStringCourt());
                }
                break;
            case 4 :
                System.out.print("\nEcrivez le code ECUE : ");
                String ecue = scanner.nextLine();
                scanner.nextLine();
                forms = GestionnaireFormulaire.getFormulairesParEpreuve(ecue);
                for (Formulaire form : forms) {
                    System.out.println(form.toStringCourt());
                }
                break;
            default :
                System.out.println("Option invalide, réessayez.");
        }
    }
    /**
     * @brief Calcule et affiche les statistiques de triche du système.
     */
    public void stat() {
        int faire = 0;
        do {
            System.out.println("\n======== STATISTIQUES =======");
            System.out.println("Quelles statistiques voulez-vous connaitre ? ");
            System.out.println("1. Nombre total de formulaires");
            System.out.println("2. Nombre d'étudiants distincts concernés");
            System.out.println("3. Nombre total de fraude enregistrées");
            System.out.println("4. Moyenne du nombre de fraudes par formulaire et écart-type");
            System.out.println("0. Quitter");
            System.out.println("\nVotre choix : ");
            int nombre = scanner.nextInt();

            switch (nombre) {
                case 1:
                    System.out.println("Nombre total de formulaires : " + Formulaire.getNbFormulaires());
                    break;
                case 2:
                    int totalEtudiants = 0;
                    List<String> listeID = new ArrayList<>();
                    for (int i = 0; i < GestionnaireFormulaire.getFormulaires().size(); i++) {
                        Formulaire f = GestionnaireFormulaire.getFormulaires().get(i);
                        for (int j = 0; j < f.getEtudiants().size(); j++) {
                            Etudiant etuTest = f.getEtudiants().get(j);
                            String idEtu = etuTest.getNumeroApprenant();

                            if (!listeID.contains(idEtu)) {
                                totalEtudiants++;
                                listeID.add(idEtu);

                            }
                        }
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
                case 4:
                    int totalFormulaires = 0;
                    int totalFraude = 0;
                    float moyennes = 0;
                    int fraude = 0;
                    double ecarttype = 0;

                    //MOYENNE
                    for (int i = 0; i < GestionnaireFormulaire.getFormulaires().size(); i++) {
                        Formulaire f = GestionnaireFormulaire.getFormulaires().get(i);
                        totalFraude += f.getFraudes().size();
                        totalFormulaires = GestionnaireFormulaire.getFormulaires().size();
                        moyennes = (float) totalFraude / totalFormulaires;
                    }

                    //ECART-TYPE
                    float ecart2 = 0;
                    float ecart = 0;
                    for (int i = 0; i < GestionnaireFormulaire.getFormulaires().size(); i++) {
                        Formulaire f = GestionnaireFormulaire.getFormulaires().get(i);
                        int fraude2 = f.getFraudes().size();
                        ecart = (float) fraude2 - moyennes;
                        ecart2 += (ecart * ecart);
                    }
                    ecarttype = Math.sqrt(ecart2 / (totalFormulaires - 1));
                    System.out.println("Moyenne : " + moyennes);
                    System.out.println("Ecart-type : " + ecarttype);
                    break;
                case 0:
                    faire = 1;
                    break;
            }

        }while(faire == 0);
        }
    /**
     * @brief Génère et affiche une liste de connections pour repérer la triche en groupe.
     */
        public void graphe(){
        Map<String, Set<String>> graphe = new HashMap<>();

        for (int i = 0; i < GestionnaireFormulaire.getFormulaires().size(); i++) {
            Formulaire f = GestionnaireFormulaire.getFormulaires().get(i);

            for (int j = 0; j < f.getEtudiants().size(); j++) {
                Etudiant etuTest = f.getEtudiants().get(j);

                if(!graphe.containsKey(etuTest.getNom())){
                    graphe.put(etuTest.getNom(), new HashSet<>());
                }
            }
        }
            for (int i = 0; i < GestionnaireFormulaire.getFormulaires().size(); i++) {
                Formulaire f2 = GestionnaireFormulaire.getFormulaires().get(i);
                List<Etudiant> listeEtu = f2.getEtudiants();


                for (int j = 0; j < listeEtu.size(); j++) {
                    String etuA = listeEtu.get(j).getNom();

                    for (int k = j + 1; k < listeEtu.size(); k++) {
                        String etuB = listeEtu.get(k).getNom();
                        graphe.get(etuA).add(etuB);
                        graphe.get(etuB).add(etuA);
                    }

                }
            }
            System.out.println("\n===== PLAGIAT POTENTIEL =====");
            if (graphe.isEmpty()) {
                System.out.println("Le graphe est vide.");
            } else {

                List<String> tousLesNoms = new ArrayList<>(graphe.keySet());

                for (int i = 0; i < tousLesNoms.size(); i++) {
                    String nomEtudiant = tousLesNoms.get(i);
                    Set<String> sesVoisins = graphe.get(nomEtudiant);

                    System.out.print(nomEtudiant + " -> ");
                    if (sesVoisins.isEmpty()) {
                        System.out.println("Aucun lien");
                    } else {
                        System.out.println(sesVoisins);
                    }
                }
            }
        }
    }



