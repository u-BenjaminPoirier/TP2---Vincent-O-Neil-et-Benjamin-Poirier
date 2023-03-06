package jeu;

import formes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Random;

public class JeuMemoire implements IJeuMemoire {

    public final static int COLONNE = 6;
    public final static int LIGNE = 6;

    private final static int LONGUEUR_CHAINE = 1;

    public final static int NBR_ELEMENTS_GRILLE = 36;

    private Forme[][] grilleDeJeu;
    private int niveau;

    private VecteurFormes vecteurFormes;

    private ArrayList<Point> VecteurPoints;

    /**
     * Constructeur du jeu Memoire
     */
    public JeuMemoire() {
        preparerVecteurFormes();
        prepareGrilleDeJeu();
    }

    /**
     * Methode qui permet d'ajouter des espaces a un String
     *
     * @param nbEspaces nombre d'espace a ajouter apres le String
     * @param forme     String avant les espaces
     * @return le String et les espaces combines
     */

    private String ajouterEspaces(int nbEspaces, String forme) {
        StringBuilder str = new StringBuilder();
        str.append(forme);
        int i = 0;
        while (i < nbEspaces) {
            str.append(" ");
            i++;
        }
        return str.toString();
    }

    /**
     * Methode qui permet de choisir un point aleatoire
     *
     * @return un point aleatoire
     */
    private Point choisirForme() {
        Point p = new Point();

        boolean b = true;
        while (true) {
            int x = getNombreAleatoireEntreBorne(0, COLONNE);
            int y = getNombreAleatoireEntreBorne(0, LIGNE);
            if (estLeSeulPointDeLaListe(x, y)) {
                p.setLocation(x, y);
                break;
            }
        }
        return p;
    }

    /**
     * Methode qui permet de verifier si le point aleatoire est dans le Vecteur Point
     *
     * @param x Coordonnee colonne du point
     * @param y Coordonne Ligne du point
     * @return Vrai si le point est seul dans la liste
     */
    private boolean estLeSeulPointDeLaListe(int x, int y) {
        int nombreDeEgualPas = 0;

        for (int i = 0; i < VecteurPoints.size(); i++) {
            if (!(pointSontPareilles(i, x, y))) {
                nombreDeEgualPas++;
            }
        }
        return nombreDeEgualPas == VecteurPoints.size();
    }

    /**
     * Methode qui prepare la grille de Jeu
     */
    private void prepareGrilleDeJeu() {
        grilleDeJeu = new Forme[LIGNE][COLONNE];
        int index = 0;

        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                grilleDeJeu[i][j] = vecteurFormes.getVecteur().get(index);
                index++;
            }
        }
    }

    /**
     * Methode qui prepare le Vecteur Forme
     */
    private void preparerVecteurFormes() {
        vecteurFormes = new VecteurFormes();
        vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
        vecteurFormes.melanger();
    }


    /**
     * L'intelligence du jeu. Génère un tableau de coordonnées (des objets <b>Point(colonne, ligne)</b>)
     * au hasard. Les points générés doivent être valides dans la grille de jeu.
     * Le nombre de points générés est en relation avec le niveau courant du jeu.
     * Il obéit à la règle suivante:
     * <p>
     * Le nombre de points générés = niveau courant du jeu + 2
     * <b>Il est important qu'un même point ne soit pas choisi 2 fois.</b>
     * <b>Note</b>: la classe java.awt.Point encapsule un x et un y. Alors que dans le JeuMemoire,
     * on utilise plutôt colonne et ligne. Ainsi, x correspond à colonne et y à ligne.
     *
     * @return la liste des coordonnées <b>Point(colonne, ligne)</b> des formes choisies dans la grille.
     */
    @Override
    public ArrayList<Point> jouerOrdi() {
        VecteurPoints = new ArrayList<Point>();

        for (int i = 0; i < niveau + 2; i++) {
            VecteurPoints.add(choisirForme());
        }

        return VecteurPoints;
    }

    /**
     * Methode qui compare 2 Points, un qui est donne et un qui se trouve dans le VecteurPoint
     *
     * @param index index du point qui est compare
     * @param x     Coordonnee X du point
     * @param y     Coordonne Y du point
     * @return Vrai si les 2 points sont pareils
     */
    public boolean pointSontPareilles(int index, int x, int y) {
        return VecteurPoints.get(index).getX() == x && VecteurPoints.get(index).getY() == y;
    }

    /**
     * Methode qui cree un nombre aleatoire entre deux bornes
     *
     * @param min Le nombre sera plus grand que
     * @param max Le nombre sera plus petit que
     * @return un nombre aleatoire entre les deux bornes
     */
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

    public boolean jouerHumain(int ligne, int colonne) {
        Point p = new Point();
        p.setLocation(colonne, ligne);

        return p.equals(VecteurPoints.get(VecteurPoints.size() - 1));
    }

    public boolean jouerHumain(int ligne, int colonne, Forme forme) {
        return grilleDeJeu[ligne][colonne].equals(forme);
    }

    /**
     * Methode qui permet d'acceder a la grille
     *
     * @return la grille de jeu
     */
    public Forme[][] getGrille() {
        return grilleDeJeu;
    }

    /**
     * Methode qui permet d'avoir le nom de la forme et sa couleur sans espaces entre
     *
     * @param ligne   coordonnée ligne de la matrice grille
     * @param colonne coordonnée colonne de la matrice grille
     * @return une string du nom d'une forme et sa couleur (sans espace)
     */
    @Override
    public String getNomForme(int ligne, int colonne) {
        Forme f = grilleDeJeu[colonne][ligne];

        return f.getNom() + f.getCouleur();
    }

    /**
     * Accesseur du niveau
     *
     * @return retourne le niveau
     */
    @Override
    public int getNiveau() {
        return niveau;
    }

    /**
     * Accesseur du vecteur Forme
     *
     * @return
     */
    public VecteurFormes getVecteur() {
        return vecteurFormes;
    }

    /**
     * Methode qui permet de monter le niveau de 1
     */
    @Override
    public void setNiveauPlusUn() {
        niveau++;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                str.append(ajouterEspaces(17, grilleDeJeu[j][i].toStringCourt()));
            }
            str.append("\n");
        }

        return str.toString();
    }

    public static void main(String[] args) {
        ;
    }

}
