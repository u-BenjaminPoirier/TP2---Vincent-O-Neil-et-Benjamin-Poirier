package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import jeu.JeuMemoire;

/**
 * Contrôleur pour le jeu de mémoire
 *
 * @author Julie Freve & Robert Aubé
 */
public class ControleurMemoire implements ActionListener, Runnable {
    private enum ETAT_JEU {
        PAS_FINI, ECHEC_DU_JOUEUR, SUCCES_DU_JOUEUR;
    }

    private static final String PATH_SEPARATOR = System.getProperty("file.separator");

    private static final String IMAGE_PATH = "images";
    private static final Color BACKGROUND_COLOR = Color.GREEN;
    private static final int ATTENDRE_AVANT_DE_VOIR = 1000;
    private static final int ATTENDRE_POUR_VOIR = 1500;
    private int nbEssai;
    private VueMemoire vue;
    private Thread t1;

    // TODO - Ajouter une variable pour une instance de type "JeuMemoire" du nom de "jeu".
    //  Voir le diagramme de classe.
    private JeuMemoire jeu;

    public ControleurMemoire() {
        // TODO - Instancier la variable "jeu"
        jeu = new JeuMemoire();
        vue = new VueMemoire();

        ajouterEcouteur();
        mettreAJourNiveau();

        nbEssai = 1;
        t1 = new Thread(this);
        t1.start();
    }

    public static void bienvenu() {
        String sTitre = "Souviens-toi ...";
        String sMessage = "Éducation physique pour votre mémoire :o)"
                + "\n\nLe but du jeu est de mémoriser les formes présentées par l'application\n"
                + "et de les sélectionner dans le même ordre après.\n\n"
                + "Si vous réussissez vous augmenterez de niveau et vous aurez plus de formes à mémoriser.\n\n"
                + "Bonne chance et amusez-vous bien!...";

        JOptionPane.showMessageDialog(null, sMessage, sTitre,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        verifierBouton(b);
    }

    private void ajouterEcouteur() {
        String image = "";

        for (int ligne = 0; ligne < JeuMemoire.LIGNE; ligne++) {
            for (int colonne = 0; colonne < JeuMemoire.COLONNE; colonne++) {
                image = jeu.getNomForme(ligne, colonne);

                ImageIcon imageIcon = new ImageIcon(IMAGE_PATH + PATH_SEPARATOR + image + ".png");
                //		imageIcon = resize(imageIcon, 64,64);
                vue.boutons[ligne][colonne].addActionListener(this);
                vue.boutons[ligne][colonne].setIcon(imageIcon);
                vue.boutons[ligne][colonne].setOpaque(true); //Pour Mac
            }
        }
    }

    private ImageIcon resize(ImageIcon imageIcon, int largeur, int hauteur) {
        Image image = imageIcon.getImage(); // transform it
        Image newImg = image.getScaledInstance(largeur, hauteur, Image.SCALE_REPLICATE); // scale it the smooth way
        return (new ImageIcon(newImg));
    }

    private void verifierBouton(JButton b) {
        int ligne;
        int colonne;
        ETAT_JEU jeu = ETAT_JEU.PAS_FINI;

        // Le niveau 1 en cache 3, niveau 2 en cache 4, etc. jusqu'à 7 qui en cache 9
        // le joueur peut jouer jusqu'à ce qu'il ait réussi ou jusqu'à la première erreur
        if (jeu == ETAT_JEU.PAS_FINI && nbEssai <= this.jeu.getNiveau() + 2) {
            System.out.println(b.getName());
            ligne = Integer.parseInt(("" + b.getName().charAt(0)));
            colonne = Integer.parseInt(("" + b.getName().charAt(1)));
            vue.boutons[ligne][colonne].setBackground(BACKGROUND_COLOR);

            // on a réussi et on passe à la cache suivante
            if (this.jeu.jouerHumain(ligne, colonne)) {
                vue.nbTrouve.setText(" Nombre de formes trouvées :  " + nbEssai);
                nbEssai++;
                if (nbEssai > this.jeu.getNiveau() + 2)
                    jeu = ETAT_JEU.SUCCES_DU_JOUEUR;
            } else
                jeu = ETAT_JEU.ECHEC_DU_JOUEUR;
        }

        // réussite ou échec, on recommence
        if (jeu == ETAT_JEU.ECHEC_DU_JOUEUR || jeu == ETAT_JEU.SUCCES_DU_JOUEUR) {
            retirerEcouteur();
            nbEssai = 1;
            if (jeu == ETAT_JEU.ECHEC_DU_JOUEUR)
                JOptionPane.showMessageDialog(null, "Erreur, on recommence ce niveau", "Oups!", JOptionPane.INFORMATION_MESSAGE);
            else {
                JOptionPane.showMessageDialog(null, "On change de niveau", "Good!!!", JOptionPane.INFORMATION_MESSAGE);
                this.jeu.setNiveauPlusUn();
            }
            mettreAJourNiveau();
            t1 = new Thread(this);
            t1.start();
        }
    }

    private void retirerEcouteur() {
        for (int ligne = 0; ligne < JeuMemoire.LIGNE; ligne++) {
            for (int colonne = 0; colonne < JeuMemoire.COLONNE; colonne++) {
                vue.boutons[ligne][colonne].removeActionListener(this);
            }
        }
    }

    private void retirerFond() {
        for (int ligne = 0; ligne < JeuMemoire.LIGNE; ligne++) {
            for (int colonne = 0; colonne < JeuMemoire.COLONNE; colonne++) {
                vue.boutons[ligne][colonne].setBackground(null);
            }
        }
    }

    private void mettreAJourNiveau() {
        vue.titre.setText(" Niveau " + jeu.getNiveau());
        vue.nbTrouve.setText(" Nombre de formes trouvées :  0");
        vue.nbReste.setText(" Nombre de formes à trouver : " + (jeu.getNiveau() + 2) + " ");
    }

    private void faireJouerOrdi() {
        ArrayList<Point> points;

        retirerEcouteur();
        retirerFond();
        points = jeu.jouerOrdi();

        for (Point p : points) {
            attendre(ATTENDRE_AVANT_DE_VOIR); //avant de voir la forme de la série

            vue.boutons[p.y][p.x].setBackground(BACKGROUND_COLOR);
            attendre(ATTENDRE_POUR_VOIR); //pour laisser le temps au joueur de voir la forme sélectionnée

            vue.boutons[p.y][p.x].setBackground(null);
        }
        this.ajouterEcouteur();
    }

    private void attendre(int milliSeconde) {
        try {
            Thread.sleep(milliSeconde);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        faireJouerOrdi();
    }
}
