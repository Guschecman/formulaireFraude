import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestionnaireFormulaireTest {
    @Test
    void testSuppressionFormulaire(){
        Formulaire formulaire = new Formulaire();
        formulaire.setEtudiants(new Etudiant("001", "Darde", "Romain", Cursus.E3e));
        formulaire.setEpreuve(new Epreuve("UE2", LocalDate.now(), 90, Modalite.QCM));
        GestionnaireFormulaire.suppressionFormulaire(formulaire.getId());
        assertEquals(0, Formulaire.getNbFormulaires());
        assertEquals(0, GestionnaireFormulaire.getFormulaires().size());
    }

    void testGetFormulaireParEtudiant(){
        Formulaire formulaire = new Formulaire();
        formulaire.setEtudiants(new Etudiant("001", "Darde", "Romain", Cursus.E3e));
        formulaire.setEpreuve(new Epreuve("UE2", LocalDate.now(), 90, Modalite.QCM));

    }
}
