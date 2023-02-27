package formes;

import exceptions.FormeException;

public class Cercle extends Forme {

    int rayon;

    public Cercle(int rayon) {
        super("Cercle");

        if (rayonEstValide(rayon)) {
            setRayon(rayon);
        } else throw new FormeException("Rayon est invalide");
    }

    public int calculerPerimetre() {
        int perimetre;

        perimetre = (int) (2 * Math.PI * rayon);

        return perimetre;
    }


    public int calculerSurface() {
        int Surface;

        Surface = (int) ( Math.PI * rayon * rayon);

        return Surface;
    }

    public boolean rayonEstValide(int rayon) {
        return rayon < MAX_VAL && rayon > MIN_VAL;
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    @Override
    public String toString() {
        return getNom() + " " + getCouleur() + "(où " + rayon + " est le rayon)";
    }
}
