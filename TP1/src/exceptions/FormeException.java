package exceptions;

public class FormeException extends RuntimeException{

    public FormeException(){
        System.out.println("erreur de dimentions");
    }

    public FormeException(String erreur){
        System.out.println(erreur);
    }

}