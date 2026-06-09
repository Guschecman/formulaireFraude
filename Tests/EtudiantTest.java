import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EtudiantTest {

    @Test
    void testConstructeurEtGetters() {
        Etudiant etu = new Etudiant("E008", "Dupont", "Jean", Cursus.E1);

        assertNotNull(etu.getNumeroApprenant(), "Le numéro ne doit pas être nul");
        assertEquals("E008", etu.getNumeroApprenant());
        assertEquals("Dupont", etu.getNom());
        assertEquals("Jean", etu.getPrenom());
        assertEquals(Cursus.E1, etu.getCursus());
    }

    @Test
    void testRechercherParNom() {
        Etudiant etu = new Etudiant("E008", "Dupont", "Jean", Cursus.E1);
        Etudiant.tousLesEtudiants.add(etu);
        List<Etudiant> resultats = Etudiant.rechercherParNom("du");

        assertNotNull(resultats, "La liste de résultats ne doit pas être nulle");
        assertFalse(resultats.isEmpty(), "On devrait trouver au moins un étudiant");

        boolean trouve = false;
        for(int i = 0; i < resultats.size(); i++) {
            if(resultats.get(i).getNom().equals(etu.getNom())) {
                trouve = true;
            }
        }
        assertTrue(trouve);
    }

    @Test
    void testRechercherParPrenom() {
        Etudiant e = new Etudiant("E005", "Hh", "Bob", Cursus.E1);
        Etudiant.tousLesEtudiants.add(e);
        List<Etudiant> resultats = Etudiant.rechercherParPrenom("ob"); // "ob" est dans B"ob"

        assertFalse(resultats.isEmpty(), "On devrait trouver au moins un étudiant");

        boolean trouve = false;
        for (int i = 0; i < resultats.size(); i++) {
            if (resultats.get(i).getPrenom().equals("Bob")) {
                trouve = true;
            }
        }
        assertTrue(trouve);
    }

    @Test
    void testRechercherNumero() {
        Etudiant e = new Etudiant("E010", "Baguette", "Marc", Cursus.E1);
        Etudiant.tousLesEtudiants.add(e);
        List<Etudiant> resultats = Etudiant.rechercherNumero("E010");

        assertFalse(resultats.isEmpty(), "Le numéro devrait être trouvé");

        boolean trouve = false;
        for (int i = 0; i < resultats.size(); i++) {
            if (resultats.get(i).getNumeroApprenant().equalsIgnoreCase("E010")) {
                trouve = true;
            }
        }
        assertTrue(trouve);
    }
}