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
     */

    public void remplir(int nbrElements){
        if(!(validerNbrFormes(nbrElements))){
            throw new IndexOutOfBoundsException();
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
        for (int i = 0; i < Vecteur.size(); i++) {
            for (int j = 0; j < Vecteur.size() ; j++) {
                if (0 < Vecteur.get(j).compareTo(Vecteur.get(j + 1)){
                    permuter(j,j+1);
                }
            }
        }
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
        forme.setCouleur(c);
        Vecteur.add(forme);
    }

    private void permuter(int index1, int index2) {
        Forme o1;
        Forme o2;

         o1 = Vecteur.get(index1);
         o2 = Vecteur.get(index2);

        Vecteur.remove(index1);
        Vecteur.add(index1, o2);
        Vecteur.remove(index2);
        Vecteur.add(index2, o1);

    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        int i = 0;

        while (i<Vecteur.size()){
            str.append(Vecteur.get(i).toStringCourt()).append("\n");
            i++;
        }

        return str.toString();
    }

    private boolean validerNbrFormes(int nbrForme) {
        if (nbrForme <= 0){
            throw new ArrayIndexOutOfBoundsException();
        }
    }


}
