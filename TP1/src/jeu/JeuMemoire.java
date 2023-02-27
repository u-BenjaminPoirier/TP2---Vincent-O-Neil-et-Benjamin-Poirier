package jeu;

import formes.*;
import formes.IVecteurFormes;

import java.awt.*;
import java.util.ArrayList;

public class JeuMemoire implements IJeuMemoire {

    public final static int COLONNE = 1;
    public final static int LIGNE = 1;

    private final static int  LONGUEUR_CHAINE = 1;

    public final static int NBR_ELEMENTS_GRILLE = 1;

    private Forme[][] grilleDeJeu;
    private int niveau;

    private VecteurFormes vecteurFormes;

    private ArrayList<Point> VecteurPoints;


    private String ajouterEspaces(int, String) {

    }

    private Point choisirForme(){

    }


    private void prepareGrilleDeJeu(){

    }

    private void preparerVecteurFormes(){

    }

    @Override
    public ArrayList<Point> jouerOrdi() {
        return null;
    }

    @Override
    public boolean jouerHumain(int ligne, int colonne) {
        return false;
    }
//get

    public Forme[][] getGrille(){

    }

    @Override
    public String getNomForme(int ligne, int colonne) {
        return null;
    }

    @Override
    public int getNiveau() {
        return 0;
    }

    public VecteursFormes getVecteur(){

    }

    //set
    @Override
    public void setNiveauPlusUn() {

    }
//ToString et main


    @Override
    public String toString() {
        return "JeuMemoire{}";
    }

    public static void main(String[] args) {

    }

}
