package jeu;

import formes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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


    /**
     * L'intelligence du jeu. Génère un tableau de coordonnées (des objets <b>Point(colonne, ligne)</b>)
     * au hasard. Les points générés doivent être valides dans la grille de jeu.
     * Le nombre de points générés est en relation avec le niveau courant du jeu.
     * Il obéit à la règle suivante:
     * <p>
     * Le nombre de points générés = niveau courant du jeu + 2
     *
     * <b>Il est important qu'un même point ne soit pas choisi 2 fois.</b>
     * <b>Note</b>: la classe java.awt.Point encapsule un x et un y. Alors que dans le JeuMemoire,
     * on utilise plutôt colonne et ligne. Ainsi, x correspond à colonne et y à ligne.
     *
     * @return la liste des coordonnées <b>Point(colonne, ligne)</b> des formes choisies dans la grille.
     */
    @Override
    public ArrayList<Point> jouerOrdi() {
        boolean b = false;

        for (int i = 0; i < niveau + 2; i++) {
            while (!b){
                int nbRandomX = getNombreAleatoireEntreBorne(0, COLONNE);
                int nbRandomY = getNombreAleatoireEntreBorne(0,LIGNE);

                if (!(pointSontPareilles(nbRandomX,nbRandomY))){
                    b = true;
                }
            }
        }

        return VecteurPoints;
    }

    public boolean pointSontPareilles(int nbRandomColonne, int  nbRandomLigne){
        int estPareil = 0;

        for (int i = 0; i < VecteurPoints.size(); i++) {
            if ( VecteurPoints.get(i).getX() == nbRandomColonne &&  VecteurPoints.get(i).getX() == nbRandomLigne )
                estPareil +=1;
        }
        return (estPareil == 0);
    }

    public static int getNombreAleatoireEntreBorne(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max doit être plus grand que min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Valide si la coordonnée jouée par le joueur humain est valide et dans
     * l'ordre selon les coordonnées générées par l'ordinateur. Voir la méthode
     * "jouerOrdi()"
     *
     * @param ligne   coordonnée ligne de la grille
     * @param colonne coordonnée colonne dans la grille
     * @return oui ou non si la coordonnée du joueur est la coordonnée jouée par
     * l'ordi dans l'ordre respecté.
     */

    boolean jouerHumain(int ligne, int colonne){
        int nombreDeCorrecte = 0;

        for (int i = 0; i < niveau + 2; i++) {
            if (pointSontPareilles(ligne,colonne));

        }

        if (nombreDeCorrecte == niveau+2)
            return true;
    }

    @Override
 /*   public boolean jouerHumain(int ligne, int colonne, Forme forme) {
        return grilleDeJeu[ligne][colonne] == forme;
    }*/

    public Forme[][] getGrille(){
        return grilleDeJeu;
    }

    @Override
    public String getNomForme(int ligne, int colonne) {
        Forme f = grilleDeJeu[colonne][ligne];

        return f.getNom() + f.getCouleur();
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
        niveau ++;
    }

    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args) {

    }

}
