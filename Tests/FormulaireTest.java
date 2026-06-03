import org.junit.jupiter.api.Test;
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
}