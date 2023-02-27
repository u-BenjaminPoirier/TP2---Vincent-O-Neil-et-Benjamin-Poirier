package formes;

public enum Couleur {
    BLEU, JAUNE, NOIR, ORANGE, ROUGE, VERT, ;


    public String getNom() {
        return name();
    }


    @Override
    public String toString() {
        return getNom();
    }
}
