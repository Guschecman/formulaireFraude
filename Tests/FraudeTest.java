import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FraudeTest {

    @Test
    void testConstructeurCalc() {
        LocalDate date = LocalDate.now();
        FraudeCalculatrice f = new FraudeCalculatrice(date, "a", "a", "a", "a");

        assertEquals("a", f.getDescription());
        assertEquals(date, f.getDateReleve());
        assertEquals("a", f.getContenu());
        assertEquals("a", f.getMarque());
        assertEquals("a", f.getProgramme());
    }

    @Test
    void testConstructeurIAG() {
        LocalDate date = LocalDate.now();
        FraudeIAG f = new FraudeIAG(date, "a", "a", "a");

        assertEquals("a", f.getDescription());
        assertEquals(date, f.getDateReleve());
        assertEquals("a", f.getContenu());
        assertEquals("a", f.getNomService());
    }

    @Test
    void testConstructeurIAGConnecte() {
        LocalDate date = LocalDate.now();
        FraudeIAGConnecte f = new FraudeIAGConnecte(date, "a", "a", "a", "a");

        assertEquals("a", f.getDescription());
        assertEquals(date, f.getDateReleve());
        assertEquals("a", f.getContenu());
        assertEquals("a", f.getNomService());
        assertEquals("a", f.getAdresseIP());
    }

    @Test
    void testConstructeurPapier() {
        LocalDate date = LocalDate.now();
        FraudePapier f = new FraudePapier(date, "a", "a", "a", true);

        assertEquals("a", f.getDescription());
        assertEquals(date, f.getDateReleve());
        assertEquals("a", f.getContenu());
        assertEquals("a", f.getDimensions());
        assertTrue(f.isEstPlie());
    }
}
