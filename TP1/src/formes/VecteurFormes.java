package formes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static formes.Couleur.*;

public class VecteurFormes implements IVecteurFormes {

    ArrayList<Forme> Vecteur;

    /**
     * Arraylist qui nous permet de contenir le nombre de formes voulues
     * @Vecteur
     */
    @Override
    public ArrayList<Forme> getVecteur() {
        return Vecteur;
    }

    /**
     * Méthode qui nous permet de remplir le vecteur de forme selon le nombre de fois voulues
     * @param nbrElements le nombre de formes voulues
     * @throws ArrayIndexOutOfBoundsException
     */
    @Override
<<<<<<< Updated upstream
    public void remplir(int nbrElements) {

        if (nbrElements <= 0) {
=======
    public void remplir(int nbrElements) throws ArrayIndexOutOfBoundsException {
<<<<<<< Updated upstream
        if (nbrElements <= 0){
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======




=======
        if(nbrElements <= 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < nbrElements; i++){
>>>>>>> Stashed changes

        }
>>>>>>> Stashed changes
    }
    @Override
    public void trier() {

    }

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

    }

    private void permuter(int forme1, int forme2) {

    }

    public String toString() {

    }

    private boolean validerNbrFormes(int nbrForme) {

    }


}
