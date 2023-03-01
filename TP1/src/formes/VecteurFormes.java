package formes;

import java.util.ArrayList;

import static formes.Couleur.*;

public class VecteurFormes implements IVecteurFormes {

    ArrayList<Forme> Vecteur;

    @Override
    public ArrayList<Forme> getVecteur() {
        return Vecteur;
    }

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
    @Override
    public void trier() {

    }

    @Override
    public void melanger() {

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
