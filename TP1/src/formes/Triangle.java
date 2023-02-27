package formes;


import exceptions.FormeException;

import static formes.TypeTriangle.*;

public class Triangle extends Forme {

    int coteA;
    int coteB;
    int coteC;

    /***
     * constructeur du triangle
     * @param a est le cote a du triangle
     * @param b est le cote b du triangle
     * @param c est le cote c du triangle
     */

    public Triangle(int a, int b, int c) {
        super("Triangle");

        if (coteEstValide(a)) {
            this.coteA = a;
        }
        if (coteEstValide(b)) {
            this.coteB = b;
        }
        if (coteEstValide(c)) {
            this.coteC = c;
        }


    }

    /***
     *Calcule et retourne le perimetre du triangle.
     * @return perimetre du triangle.
     */

    public int calculerPerimetre() {
        int perimetre;

        perimetre = coteA + coteB + coteC;

        return perimetre;
    }

    /***
     * Calcule la surface du triangle avec la formule de heron
     * @return la surface du triangle
     */

    public int calculerSurface() {
        int surface;
        int p = calculerPerimetre() / 2;

        surface = (int) Math.sqrt(p * (p - coteA) * (p - coteB) * (p - coteC));

        return surface;
    }

    /***
     * Cette methode calculer le nombre de coté qui sont egale dans le triangle
     * @return le nombre de cote dont la longueur est egale.
     */

    private int getNombreDeCoteEgaux() {
        if (coteA == coteB && coteA == coteC)
            return 3;
        else if(coteA == coteB || coteA == coteC || coteC == coteB)
            return 2;
        else return 1;
    }

    /***
     * Méthode qui verifie si le triangle est rectangle
     * @return vrai si le triangle s'il est rectangle
     */

    private boolean estRectangle() {
        int[] coteTrie = getCotesTrie();
        int plusGrandNombre = coteTrie[0];
        return (plusGrandNombre * plusGrandNombre) == (coteTrie[1] * coteTrie[1]) + (coteTrie[2] * coteTrie[2]);
    }

    /***
     * Cette methode verifie que les trois longueur font un triangle
     * @param a cote A du triangle
     * @param b cote b du triangle
     * @param c cote c du triangle
     * @return vrai si le triangle existe
     */
    public static boolean estTriangle(int a, int b, int c) {
        int plusGrosNb = 0;
        int petitNb1 = 0;
        int petitNb2 = 0;

        if (a >= b && a >= c) {
            plusGrosNb = a;
            petitNb1 = b;
            petitNb2 = c;
        } else if (b >= a && b >= c) {
            plusGrosNb = b;
            petitNb1 = a;
            petitNb2 = c;
        } else {
            plusGrosNb = c;
            petitNb1 = a;
            petitNb2 = b;
        }
        return (plusGrosNb <= petitNb1 + petitNb2);
    }

    /***
     * Methode qui verifie et retourne le type du triangle
     * @return le type du triangle
     */

    public String getType() {
        Boolean estTriangle = estTriangle(coteA, coteB, coteC);
        int nbDeCote = getNombreDeCoteEgaux();
        String Type = "";

        if (estRectangle()) {
            Type = "rectangle";
        }

        if (nbDeCote == 2) {
            Type = "isocèle";
        } else if (nbDeCote == 3) {
            Type = "equilateral";
        }

        if (Type.equals("")) {
            Type = "scalene";
        }

        return Type;
    }

    /***
     * Verifie que le cote est valide, sinon il lance une exception
     * @param Cote est le cote a verifier
     */
    public boolean coteEstValide(int Cote) {
        if (Cote >= MIN_VAL && Cote <= MAX_VAL) return true;
        else throw new FormeException("Le cote de longueur " + Cote + " est invalide");
    }

    /***
     * Methode qui trie les 3 cotes en ordre decroissant
     * @return une liste des cotes qui sont trie, du plus grand au plus petit
     */


    private int[] getCotesTrie() {
        int a = coteA;
        int b = coteB;
        int c = coteC;
        int[] coteTrie = new int[3];
        int plusGrosNb = 0;
        int petitNb1 = 0;
        int petitNb2 = 0;
        if (a >= b && a >= c) {
            plusGrosNb = a;
            petitNb1 = b;
            petitNb2 = c;
        } else if (b >= a && b >= c) {
            plusGrosNb = b;
            petitNb1 = a;
            petitNb2 = c;
        } else {
            plusGrosNb = c;
            petitNb1 = a;
            petitNb2 = b;
        }
        coteTrie[0] = plusGrosNb;

        if (petitNb1 >= petitNb2) {
            coteTrie[1] = petitNb1;
            coteTrie[2] = petitNb2;
        } else {
            coteTrie[1] = petitNb2;
            coteTrie[2] = petitNb1;
        }
        return coteTrie;
    }

    /***
     * Accesseur du cote a
     * @return le cote a
     */
    public int getCoteA() {
        return coteA;
    }

    /***
     * Accesseur du cote b
     * @return le cote b
     */
    public int getCoteB() {
        return coteB;
    }

    /***
     * Accesseur du cote c
     * @return le cote c
     */
    public int getCoteC() {
        return coteC;
    }

    /***
     * Methode qui transfert le triangle en string
     * @return le string du triangle
     */

    @Override
    public String toString() {
        return getNom() + " " + getCouleur() + "(où " + coteA + " est un cote " + ", où " + coteB + " est un cote et où " + coteC + " est un cote";
    }

}
