import exceptions.FormeException;
import formes.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.Transient;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {


    @DisplayName("Calculer Perimetre")
    @Test
    void calculerPerimetre() {
        Triangle t = new Triangle(4, 4, 4);

        assert (t.calculerPerimetre() == 12);
        assertNotEquals(13, t.calculerPerimetre());

        Triangle t2 = new Triangle(1, 6, 8);

        assert (t2.calculerPerimetre() == 15);
        assertNotEquals(21, t2.calculerPerimetre());
    }

    @DisplayName("Calculer Surface")
    @Test
    void calculerSurface() {
        Triangle t = new Triangle(4, 4, 4);

        assert (t.calculerSurface() == 6);
        assertNotEquals(7, t.calculerPerimetre());
    }


    @DisplayName("Tester est triangle")
    @Test
    void estTriangle() {
        assertTrue(Triangle.estTriangle(1, 2, 3));
        assertTrue(Triangle.estTriangle(3, 2, 1));
        assertTrue(Triangle.estTriangle(2, 3, 1));

        assertNotEquals(true, Triangle.estTriangle(1, 2, 4));
    }

    @Test
    void getType() {
        Triangle t = new Triangle(1, 1, 1);
        assertEquals(t.getType(), "equilateral");
        Triangle t2 = new Triangle(1, 4, 4);
        assertEquals("isocèle", t2.getType());
       Triangle t3 = new Triangle(3, 4, 5);
        assertEquals(t3.getType(), "rectangle");
        t = new Triangle(13, 14, 9);
        assertEquals(t.getType(), "scalene");
    }


    @Test
    void coteEstValideLanceUneException() {
        Exception exception = assertThrows(FormeException.class, () -> {
            new Triangle(-1, 2, 3);
        });
    }


    @Test
    void getCoteA() {
        Triangle t = new Triangle(1,1,1);
        assert (t.getCoteA() == 1);
    }

    @Test
    void getCoteB() {
        Triangle t = new Triangle(1,1,1);
        assert (t.getCoteB() == 1);
    }

    @Test
    void getCoteC() {
        Triangle t = new Triangle(1,1,1);
        assert (t.getCoteC() == 1);
    }

    @Test
    void testToString() {
        Triangle t = new Triangle(1,2,3);
        assertEquals(t.toString(),"Triangle" + " " + "ROUGE" + "(où " + 1 + " est un cote "
                + ", où " + 2 + " est un cote et où " + 3 + " est un cote");
    }
}