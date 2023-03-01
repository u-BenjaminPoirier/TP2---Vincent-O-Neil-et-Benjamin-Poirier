package formes;

import java.util.Objects;

import static formes.Couleur.*;

public abstract class Forme {

    public final static Couleur COULEUR_DEFAULT = ROUGE;

    public final static int MAX_VAL = 30;
    public final static int MIN_VAL = 1;
    private String nom;
    private String couleur;


    /***
     * Constructeur de la forme, crée la forme
     * @param nom nom de la forme
     */
    public Forme(String nom) {
        this.nom = nom;
        setCouleur(COULEUR_DEFAULT);
    }

    /***
     * Methode qui calcule le perimetre de la forme
     * @return le perimetre de la forme
     */
    public abstract int calculerPerimetre();

    /***
     * Methode qui calculer la surface de la forme
     * @return la surface de la forme
     */
    public abstract int calculerSurface();

    //nom

    /***
     *Accesseur du nom
     * @return le nom de la forme
     */
    public String getNom() {
        return nom;
    }


    //Couleur

    /***
     * Setter de la couleur
     * @param couleur Couleur de la forme
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur.getNom();
    }

    /***
     * Accesseur de la couleur
     * @return la couleur de la forme
     */
    public String getCouleur() {
        return couleur;
    }

    /***
     * ToString de la forme
     * @return La forme en string
     */
    public abstract String toString();

    /***
     * Methode qui compare deux formes via leurs nom et couleurs
     * @param forme forme qui sera compare
     * @return Le nombre qui explique la position des deux formes l'un a l'autre lexicographiquement
     */

    public int compareTo(Forme forme) {
        String nom = this.getNom();
        int nb = nom.compareTo(forme.getNom());
        if (nb == 0)
            return this.getCouleur().compareTo(forme.getCouleur());
        else return nb;
    }

    /***
     * Methode qui verifie si deux formes sont egales selon leur nom, couleur et surface
     * @param o forme qui sera compare a l'instance
     * @return Si la forme est egale ou non a l'instance
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forme forme = (Forme) o;
        if (!Objects.equals(nom, forme.nom)) return false;
        else if (!Objects.equals(this.getCouleur(), forme.getCouleur())) return false;
        else return this.calculerSurface() == forme.calculerSurface();
    }

    public String compareToCourt(){
        return getNom() + " " + getCouleur();
    }
}