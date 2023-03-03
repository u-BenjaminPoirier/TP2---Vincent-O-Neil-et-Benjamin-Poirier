package jeu;

import formes.*;

import java.awt.*;
import java.util.ArrayList;

public class JeuMemoire implements IJeuMemoire {

    public final static int COLONNE = 5;
    public final static int LIGNE = 4;

    private final static int  LONGUEUR_CHAINE = 1;

    public final static int NBR_ELEMENTS_GRILLE = 1;

    private Forme[][] grilleDeJeu;
    private int niveau;

    private VecteurFormes vecteurFormes;

    private ArrayList<Point> VecteurPoints;

    public JeuMemoire(){
        preparerVecteurFormes();
        prepareGrilleDeJeu();
    }


    private String ajouterEspaces(int nbEspaces, String forme) {
        int i = 0;
        while (i < nbEspaces) {
            for (int j = 0; j < nbEspaces; j++) {
                forme += " ";
                i++;
            }
            return forme;
        }
    }

    private Point choisirForme(){

    }


    private void prepareGrilleDeJeu(){
        grilleDeJeu = new Forme[COLONNE][LIGNE];
        int index = 0;


        for (int i = 0; i < COLONNE; i++) {
            for (int j = 0; j < LIGNE ; j++) {
                grilleDeJeu[i][j] = vecteurFormes.getVecteur().get(index);
                index ++;
            }
        }
    }

    private void preparerVecteurFormes(){
        vecteurFormes = new VecteurFormes();
        vecteurFormes.remplir(20);
        vecteurFormes.melanger();
    }

    @Override
    public ArrayList<Point> jouerOrdi() {
        return null;
    }

    @Override
    public boolean jouerHumain(int ligne, int colonne, Forme forme) {
        return grilleDeJeu[ligne][colonne] == forme;
    }

    public Forme[][] getGrille(){

    }

    @Override
    public String getNomForme(int ligne, int colonne) {
        return String.valueOf(grilleDeJeu[ligne][colonne]).strip();
    }

    @Override
    public int getNiveau() {
        return niveau;
    }

    public VecteurFormes getVecteur(){
        return vecteurFormes;
    }

    //set
    @Override
    public void setNiveauPlusUn() {

    }
//ToString et main


    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args) {

    }

}
