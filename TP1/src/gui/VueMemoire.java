package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.JeuMemoire;

/**
 * Interface graphique du jeu de mémoire
 *
 * @author Julie Frève & Robert Aubé
 */
public class VueMemoire extends JFrame {
    private static final String FONT_NAME = "Calibri";
    protected JButton[][] boutons;
    protected JLabel titre, nbTrouve, nbReste;
    private GridLayout gridLayout;
    private BorderLayout borderLayout;

    public VueMemoire() {
        super("Jeu de mémoire");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        borderLayout = new BorderLayout(1, 1);
        gridLayout = new GridLayout(JeuMemoire.LIGNE, JeuMemoire.COLONNE, 3, 3);
        JPanel panel1 = new JPanel(borderLayout);
        JPanel panel2 = new JPanel(new BorderLayout(30, 30));
        JPanel panel3 = new JPanel(gridLayout);

        titre = new JLabel();
        titre.setFont(new Font(FONT_NAME, Font.BOLD, 48));
        nbTrouve = new JLabel();
        nbReste = new JLabel();
        nbTrouve.setFont(new Font(FONT_NAME, Font.BOLD, 20));
        nbReste.setFont(new Font(FONT_NAME, Font.BOLD, 20));

        boutons = new JButton[JeuMemoire.LIGNE][JeuMemoire.COLONNE];
        for (int ligne = 0; ligne < JeuMemoire.LIGNE; ligne++) {
            for (int colonne = 0; colonne < JeuMemoire.COLONNE; colonne++) {
                boutons[ligne][colonne] = new JButton();
                boutons[ligne][colonne].setName("" + ligne + colonne);
                panel3.add(boutons[ligne][colonne]);
            }
        }

        panel2.add(nbTrouve, BorderLayout.WEST);
        panel2.add(nbReste, BorderLayout.EAST);

        panel1.add(titre, BorderLayout.NORTH);
        panel1.add(panel2, BorderLayout.SOUTH);
        panel1.add(panel3, BorderLayout.CENTER);
        getContentPane().add(panel1, BorderLayout.CENTER);

        setPreferredSize(new Dimension(600, 700));
        pack();
        setLocation((screenSize.width - this.getWidth()) / 2,
                (screenSize.height - this.getHeight()) / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
