package formes;

import java.util.ArrayList;

public class VecteurFormes implements IVecteurFormes{

    ArrayList<Forme> Vecteur;

    @Override
    public ArrayList<Forme> getVecteur() {
        return Vecteur;
    }

    @Override
    public void remplir(int nbrElements) throws ArrayIndexOutOfBoundsException {
        if (nbrElements <= 0){
            throw new ArrayIndexOutOfBoundsException();
        }

        int i = 0;

        do {
            Forme t = new Triangle(1,1,1);
            Vecteur.add(t);

            i++;

            Forme r = new Rectangle(1,1);
            Vecteur.add(r);

            i++;

            Forme c = new Cercle(1);
            Vecteur.add(c);

            i++;
        } while (i < nbrElements);

        
        i = 0;

        while (i < nbrElements){
            for (int j = 0; j < 3; j++) {
                Vecteur.get(i).setCouleur();


                i++;
            }
        }





    }

    @Override
    public void trier() {

    }

    @Override
    public void melanger() {

    }

    private void addForme(Forme forme, Couleur c){

    }

    private void permuter (int forme1, int forme2){

    }

    public String toString(){

    }

    private boolean validerNbrFormes(int nbrForme){

    }


}
