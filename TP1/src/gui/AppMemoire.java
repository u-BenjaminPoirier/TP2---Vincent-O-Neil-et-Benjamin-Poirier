package gui;
/**
 * Application pour le jeu de mémoire
 *
 * @author Julie Freve & Robert Aubé
 */
public class AppMemoire {
    public static void main(String[] args) {
       // ControleurMemoire.bienvenu();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControleurMemoire();
            }
        });
    }
}
