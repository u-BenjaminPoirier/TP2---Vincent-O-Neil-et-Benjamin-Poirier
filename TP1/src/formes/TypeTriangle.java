package formes;

public enum TypeTriangle {
    EQUILATERAL("equilatéral"),ISOCELE("isocèle"),RECANGLE("rectangle"),SCALENE("scalene");

    public String type;


    private TypeTriangle(String type){
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "";
    }
}
