import java.time.LocalDate;
import java.util.List;

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

    @Test
    void testGetFormulaireParEtudiant(){
        Formulaire formulaire1 = new Formulaire();
        formulaire1.setEtudiants(new Etudiant("001", "Darde", "Romain", Cursus.E3e));
        Formulaire formulaire2 = new Formulaire();
        formulaire2.setEtudiants(new Etudiant("002", "Darde", "Romain", Cursus.E3e));
        List<Formulaire> resultats = GestionnaireFormulaire.getFormulairesParEtudiant("001");
        assertEquals(1, resultats.size());
        assertEquals(formulaire1, resultats.get(0));
        GestionnaireFormulaire.suppressionFormulaire(formulaire1.getId());
        GestionnaireFormulaire.suppressionFormulaire(formulaire2.getId());
    }

    @Test
    void testGetFormulaireParEtudiant2(){
        Formulaire formulaire1 = new Formulaire();
        formulaire1.setEtudiants(new Etudiant("001", "Darde", "Romain", Cursus.E3e));
        Formulaire formulaire2 = new Formulaire();
        formulaire2.setEtudiants(new Etudiant("001", "Darde", "Romain", Cursus.E3e));
        List<Formulaire> resultats = GestionnaireFormulaire.getFormulairesParEtudiant("001");
        assertEquals(2, resultats.size());
        assertEquals(formulaire1, resultats.get(0));
        assertEquals(formulaire2, resultats.get(1));
        GestionnaireFormulaire.suppressionFormulaire(formulaire1.getId());
        GestionnaireFormulaire.suppressionFormulaire(formulaire2.getId());
    }

    @Test
    void testGetFormulaireParEpreuve(){
        Formulaire formulaire1 = new Formulaire();
        formulaire1.setEpreuve(new Epreuve("UE2", LocalDate.now(), 90, Modalite.QCM));
        Formulaire formulaire2 = new Formulaire();
        formulaire2.setEpreuve(new Epreuve("UE1", LocalDate.now(), 90, Modalite.QCM));
        List<Formulaire> resultats = GestionnaireFormulaire.getFormulairesParEpreuve("UE1");
        assertEquals(1, resultats.size());
        assertEquals(formulaire2, resultats.get(0));
        GestionnaireFormulaire.suppressionFormulaire(formulaire1.getId());
        GestionnaireFormulaire.suppressionFormulaire(formulaire2.getId());
    }

    @Test
    void testGetFormulaireParEpreuve2(){
        Formulaire formulaire1 = new Formulaire();
        formulaire1.setEpreuve(new Epreuve("UE1", LocalDate.now(), 90, Modalite.QCM));
        Formulaire formulaire2 = new Formulaire();
        formulaire2.setEpreuve(new Epreuve("UE1", LocalDate.now(), 90, Modalite.QCM));
        List<Formulaire> resultats = GestionnaireFormulaire.getFormulairesParEpreuve("UE1");
        assertEquals(2, resultats.size());
        assertEquals(formulaire1, resultats.get(0));
        assertEquals(formulaire2, resultats.get(1));
        GestionnaireFormulaire.suppressionFormulaire(formulaire1.getId());
        GestionnaireFormulaire.suppressionFormulaire(formulaire2.getId());
    }

    @Test
    void testGetFormulaireParFraude(){
        Formulaire formulaire1 = new Formulaire();
        formulaire1.setFraudes(new FraudeIAG(LocalDate.now(), "a", "a", "a"));
        Formulaire formulaire2 = new Formulaire();
        formulaire2.setFraudes(new FraudePapier(LocalDate.now(), "a", "a","a", true));
        List<Formulaire> resultats = GestionnaireFormulaire.getFormulairesParFraude(Type.IAG_CONNECTEE);
        assertEquals(1, resultats.size());
        assertEquals(formulaire1, resultats.get(0));
        GestionnaireFormulaire.suppressionFormulaire(formulaire1.getId());
        GestionnaireFormulaire.suppressionFormulaire(formulaire2.getId());
    }

    @Test
    void testGetFormulaireParFraude2(){
        Formulaire formulaire1 = new Formulaire();
        formulaire1.setFraudes(new FraudeIAG(LocalDate.now(), "a", "a", "a"));
        Formulaire formulaire2 = new Formulaire();
        formulaire2.setFraudes(new FraudeIAG(LocalDate.now(), "a", "a", "a"));
        List<Formulaire> resultats = GestionnaireFormulaire.getFormulairesParFraude(Type.IAG);
        assertEquals(2, resultats.size());
        assertEquals(formulaire1, resultats.get(0));
        assertEquals(formulaire2, resultats.get(1));
        GestionnaireFormulaire.suppressionFormulaire(formulaire1.getId());
        GestionnaireFormulaire.suppressionFormulaire(formulaire2.getId());
    }
}
