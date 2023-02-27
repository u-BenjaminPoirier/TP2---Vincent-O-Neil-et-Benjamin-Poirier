import org.junit.jupiter.api.Test;
import formes.Rectangle;
import static org.junit.jupiter.api.Assertions.*;


class RectangleTest {

    @Test
    void calculerPerimetre() {
        Rectangle r = new Rectangle(1,2);
        assertEquals(6, r.calculerPerimetre());
    }

    @Test
    void calculerSurface() {
        Rectangle r = new Rectangle(1,2);
        assertEquals(2, r.calculerSurface());
    }
}