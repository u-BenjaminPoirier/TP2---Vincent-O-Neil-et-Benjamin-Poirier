package _tests;

import formes.VecteurFormes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VecteursFormesTest {

    @Test
    void testerTrier() {
        VecteurFormes v = new VecteurFormes();
        VecteurFormes v1 = new VecteurFormes();


        v.remplir(3);
        v.melanger();
        v.trier();
        v1.remplir(3);
        v1.melanger();
        v1.trier();

        assert(v.getVecteur().equals(v1.getVecteur()));
    }

    @Test
    void testerGetVecteur() {
        VecteurFormes v = new VecteurFormes();
        VecteurFormes v2 = new VecteurFormes();

        v.remplir(14);
        v2.remplir(14);

        assert(v.getVecteur().equals(v2.getVecteur()));
    }

    @Test
    void testerRemplir() {
        VecteurFormes v = new VecteurFormes();

    }
}
