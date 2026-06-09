import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FormulaireTest {
    @Test
    void testConstructeur(){
        Formulaire formulaire = new Formulaire();
        assertEquals(1, Formulaire.getNbFormulaires());
        assertEquals(1, formulaire.getId());
        assertEquals(formulaire, GestionnaireFormulaire.getFormulaires().get(0));
        assertTrue(formulaire.getEtudiants().isEmpty());
        assertTrue(formulaire.getFraudes().isEmpty());
    }


    @Test
    void testAjoutEtudiant() {
        Formulaire f = new Formulaire();
        Etudiant fauxEtudiant = new Etudiant("E004", "Jean", "Dupont", Cursus.E1);
        f.setEtudiants(fauxEtudiant);


        assertEquals(1, f.getEtudiants().size(), "La liste doit contenir exactement 1 étudiant");
        assertEquals(fauxEtudiant, f.getEtudiants().get(0), "L'étudiant récupéré doit être celui ajouté");
    }


    @Test
    void testConfigurationEpreuve() {
        Formulaire f = new Formulaire();
        Epreuve fausseEpreuve = new Epreuve("Maths", LocalDate.now(), 120, null);
        f.setEpreuve(fausseEpreuve);

        assertNotNull(f.getEpreuve(), "L'épreuve ne doit plus être nulle");
        assertEquals(fausseEpreuve, f.getEpreuve(), "L'épreuve doit correspondre à celle configurée");
    }
}