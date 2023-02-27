package formes;

import java.util.ArrayList;

/**
 * Interface de manipulation d'un vecteur basé sur un ArrayList
 */
public interface IVecteurFormes {

    /**
     * Obtenir le vecteur de formes
     * @return le vecteur de formes
     */
    public ArrayList<Forme> getVecteur();

    /**
     * Mettre le nombre de formes voulues dans le vecteur. Les formes qui seront
     * placées dans le vecteur devront être générées de la façon suivante:
     * <p>
     * Tant que le nombre de formes souhaitées n'est pas atteint on crée une forme
     * à la fois, pour toutes les formes disponibles (Cercle, Rectangle et
     * Triangle) combiné à toutes les couleurs possibles (rouge, vert, bleu,
     * jaune, noir, orange). Quand toutes les combinaisons sont épuisées on
     * recommence.
     * <p>
     * Le but final étant d'obtenir le bon nombre de formes, les plus
     * diversifiées possibles.
     *
     * @param nbrElements le nombre de formes voulues
     */
    public void remplir(int nbrElements) throws ArrayIndexOutOfBoundsException;

    /**
     * Trier en ordre croissant le vecteur de formes en utilisant le "compareTo"
     * disponible sur les objets.
     */
    public void trier();

    /**
     * Mélanger les éléments du vecteur.
     */
    public void melanger();

}