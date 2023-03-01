package formes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static formes.Couleur.*;

public class VecteurFormes implements IVecteurFormes {

    ArrayList<Forme> Vecteur;

    /**
     * Obtenir le vecteur de formes
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

        if (nbrElements <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Couleur[] listeCouleur = {BLEU, JAUNE, NOIR, ORANGE, ROUGE, VERT,};
        String formeString = "Triangle";
        int indexCouleur = 0;

        for (int i = 0; i < nbrElements; i++) {
            switch (formeString) {
                case "Triangle" -> {
                    Forme t = new Triangle(1, 1, 1);
                    t.setCouleur(listeCouleur[indexCouleur]);
                    Vecteur.add(t);
                    formeString = "Rectangle";
                }
                case "Rectangle" -> {
                    Forme r = new Rectangle(1, 1);
                    r.setCouleur(listeCouleur[indexCouleur]);
                    Vecteur.add(r);
                    formeString = "Cercle";
                }
                case "Cercle" -> {
                    Forme c = new Cercle(1);
                    c.setCouleur(listeCouleur[indexCouleur]);
                    Vecteur.add(c);
                    formeString = "Rectangle";
                    indexCouleur++;
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
        Forme o;

        for (int i = 0; i < Vecteur.size(); i++) {
            for (int j = 0; j < Vecteur.size(); j++) {
                if( 0 < Vecteur.get(j).compareTo(Vecteur.get(j +1))){
                    o = Vecteur.get(i);
                    Vecteur.set(i,Vecteur.get(i+1) );
                    Vecteur.set(i+1, o);
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


    private void addForme(Forme forme, Couleur c) {
            forme.setCouleur(c);
            Vecteur.add(forme);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int i = 0;

        while (i < Vecteur.size()){
            str.append(Vecteur.get(i).toStringToCourt()).append("\n");

            i++;
        }


        return str.toString();
    }
}
