import formes.Cercle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CercleTest {

    @Test
    void calculerPerimetre() {
        Cercle c = new Cercle(2);
        assertEquals(12,c.calculerPerimetre());
    }

    @Test
    void calculerSurface() {
        Cercle c = new Cercle(2);
        assertEquals(12,c.calculerSurface());
    }
}