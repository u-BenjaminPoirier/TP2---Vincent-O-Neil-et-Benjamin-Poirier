package jeu;

import formes.Forme;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Cette interface impose les signatures de méthodes pour que le jeu de mémoire fonctionne.
 */
public interface IJeuMemoire {
    /**
     * Nombre maximal de niveaux de jeu.
     */
    public static final int NIVEAU_MAX = 6;

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
    public ArrayList<Point> jouerOrdi();

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
    public boolean jouerHumain(int ligne, int colonne);

    boolean jouerHumain(int ligne, int colonne, Forme forme);

    /**
     * Obtenir sous forme de chaîne sans espace le nom et la couleur de la forme
     * à l'emplacement désiré dans la grille.
     *
     * @param ligne   coordonnée ligne de la matrice grille
     * @param colonne coordonnée colonne de la matrice grille
     * @return nom et couleur concaténée en chaîne de caractère
     */
    public String getNomForme(int ligne, int colonne);

    /**
     * Connaître le niveau du jeu.
     *
     * @return le niveau du jeu
     */
    public int getNiveau();

    /**
     * Ajoute 1 au niveau si celui-ci est en-dessous de 6, autrement il demeure à 6.
     */
    public void setNiveauPlusUn();

}
