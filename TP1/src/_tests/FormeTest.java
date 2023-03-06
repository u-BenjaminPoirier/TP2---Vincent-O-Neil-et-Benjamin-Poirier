import formes.Couleur;
import formes.Rectangle;
import formes.Triangle;
import org.junit.Test;

import static formes.Couleur.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import formes.Triangle;

import java.util.Objects;
import java.util.function.DoubleUnaryOperator;

class FormeTest {

    @Test
    void getNom() {
        Triangle t = new Triangle(1,1,1);
        assertEquals(t.getNom(),"Triangle");
    }

    @Test
    void setCouleur() {
        Triangle t = new Triangle(1,1,1);

        t.setCouleur(BLEU);

        String str = t.getCouleur();

        assertEquals(str, BLEU.getNom());
    }

    @Test
    void getCouleur() {
        Triangle t = new Triangle(1,1,1);
        assertEquals(t.getCouleur(), ROUGE.getNom());
    }

    @Test
    void compareTo() {
        Triangle t1 = new Triangle(1,1,1);
        Triangle t2 = new Triangle(1,1,1);

        assert (t1.compareTo(t2) == 0);

        t1.setCouleur(BLEU);

        Rectangle r = new Rectangle(1,2);

        assertEquals(t1.compareTo(r), 2);

    }

    @Test
    void testEquals() {
        Rectangle r1 = new Rectangle(1,2);
        Rectangle r2 = new Rectangle(2,1);
        Rectangle r3 = new Rectangle (3,4);
        Triangle t = new Triangle (1,1,1);


        assertEquals(r1, r2);
        assertNotEquals(r1, r3);
        assertNotEquals(r1, t);
    }
}
