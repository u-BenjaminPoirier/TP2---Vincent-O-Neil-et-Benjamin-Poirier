package formes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static formes.Couleur.*;

public class VecteurFormes implements IVecteurFormes {

    ArrayList<Forme> Vecteur;

    /**
     * Obtenir le vecteur de formes
     *
     * @return le vecteur de formes
     */
    @Override
    public ArrayList<Forme> getVecteur() {
        return Vecteur;
    }

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
    @Override
    public void remplir(int nbrElements) {
        Vecteur = new ArrayList<Forme>();

        if (!(validerNbrFormes(nbrElements))) {
            throw new IndexOutOfBoundsException();
        }

        Couleur[] listeCouleur = {BLEU, JAUNE, NOIR, ORANGE, ROUGE, VERT};
        String formeString = "Triangle";
        int indexCouleur = 0;

        for (int i = 0; i < nbrElements; i++) {
            switch (formeString) {
                case "Triangle" -> {
                    Forme t = new Triangle(1, 1, 1);

                    addForme(t,listeCouleur[indexCouleur]);

                    formeString = "Rectangle";
                }
                case "Rectangle" -> {
                    Forme r = new Rectangle(1, 1);

                    addForme(r,listeCouleur[indexCouleur]);

                    formeString = "Cercle";
                }
                case "Cercle" -> {
                    Forme c = new Cercle(2);

                    addForme(c,listeCouleur[indexCouleur]);

                    formeString = "Rectangle";
                    if (indexCouleur == 5) {
                        indexCouleur = 0;
                    }
                    else{
                        indexCouleur ++;
                    }
                }
            }
        }
    }

    /**
     * Trier en ordre croissant le vecteur de formes en utilisant le "compareTo"
     * disponible sur les objets.
     */
    @Override
    public void trier() {
        for (int i = 0; i < Vecteur.size(); i++) {
            for (int j = 0; j < Vecteur.size(); j++) {
                if (0 < Vecteur.get(j).compareTo(Vecteur.get(j + 1))) {
                    permuter(j, j + 1);
                }
            }
        }
    }

    /**
     * Mélanger les éléments du vecteur.
     */
    @Override
    public void melanger() {
        int i = 0;
        Forme o;

        while (i < 100) {
            int r = (int) Math.floor(Math.random() * (Vecteur.size() - 1 + 1) + 0);

            o = Vecteur.get(r);
            Vecteur.remove(r);
            Vecteur.add(o);
            i++;
        }
    }

    /**
     * Ajoute une forme au vecteur
     *
     * @param forme forme a ajouter
     * @param c     Est pour couleur, sera la couleur de la forme
     */

    private void addForme(Forme forme, Couleur c) {
        forme.setCouleur(c);
        Vecteur.add(forme);
    }

    /**
     * Permet de permuter deux elements du vecteur
     *
     * @param index1 index de l'element 1 a echanger
     * @param index2 index de l'element 2 a echanger
     */

    private void permuter(int index1, int index2) {
        Forme o1;
        Forme o2;

        o1 = Vecteur.get(index1);
        o2 = Vecteur.get(index2);

        Vecteur.remove(index1);
        Vecteur.add(index1, o2);
        Vecteur.add(index2, o1);
        Vecteur.remove(index2);

    }

    /**
     * Transforme la classe en String
     *
     * @return une String du vecteur
     */

    public String toString() {
        StringBuilder str = new StringBuilder();
        int i = 0;

        while (i < Vecteur.size()) {
            str.append(Vecteur.get(i).toStringCourt()).append("\n");
            i++;
        }
        return str.toString();
    }

    /**
     * Permet de valider le nombre de forme (est invalide lorsque negatif)
     * @param nbrForme nombre de forme a ajouter dans le vecteur
     * @return si la forme est valide ou non
     */
    private boolean validerNbrFormes(int nbrForme) {
        return nbrForme > 0;
    }
}
