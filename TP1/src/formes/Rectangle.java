package formes;

import exceptions.FormeException;

public class Rectangle extends Forme {
    private int hauteur;
    private int largeur;

    public Rectangle(int largeur, int hauteur) {
        super("Rectangle");

        if (largeurEstValide(largeur)) {
            setLargeur(largeur);
        } else throw new FormeException("Largeur est invalide");

        if (hauteurEstValide(hauteur)) {
            setHauteur(hauteur);
        } else throw new FormeException("Hauteur est invalide");

    }


    public int calculerPerimetre() {
        int perimetre;

        perimetre = (2 * largeur) + (2 * hauteur);

        return perimetre;
    }

    public int calculerSurface() {
        int Surface;

        Surface = largeur * hauteur;

        return Surface;
    }

    public static boolean hauteurEstValide(int hauteur) {return hauteur <= Forme.MAX_VAL && hauteur >= Forme.MIN_VAL;}

    public static boolean largeurEstValide(int Largeur) {
        return Largeur <= Forme.MAX_VAL && Largeur >= Forme.MIN_VAL;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }


    @Override
    public String toString() {
        return getNom() + " " + getCouleur() + "(où " + hauteur + " est la hauteur et " + largeur + " est la largeur)";
    }
}
