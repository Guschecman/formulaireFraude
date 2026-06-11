import cursus.Epreuve;
import cursus.Modalite;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EpreuveTest {

    @Test
    void testConstructeur() {
        LocalDate date = LocalDate.now();
        Epreuve ep1 = new Epreuve("A1", date, 120, Modalite.TP);

        assertEquals("A1", ep1.getECUE());
        assertEquals(date, ep1.getDateHeurePassage());
        assertEquals(120, ep1.getDuree());
        assertEquals(Modalite.TP, ep1.getModalite());
    }
}
