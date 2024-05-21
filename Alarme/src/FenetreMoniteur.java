import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class FenetreMoniteur extends JFrame{
    //Attributs
		final static int HAUTEUR=500;
		final static int LARGEUR=350;

    //Constructeur
    public FenetreMoniteur() {
        //Initialisation fenetre
        setTitle("Gestion moniteurs");
        setSize(LARGEUR,HAUTEUR);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocation(900,100);


        JPanel j = new JPanel();
        j.setLayout(new GridLayout(0,1));
        JPanel jMoniteur = new JPanel();
        JPanel jTableau = new JPanel();

        //Choix du moniteur
        JLabel tchoix = new JLabel("Choississez un moniteur :");
        Object[] moniteurs = new Object[]{"Moniteur A","Moniteur B"};
        JComboBox cmoniteur = new JComboBox(moniteurs);

        jMoniteur.add(tchoix);
        jMoniteur.add(cmoniteur);


        //Ajout dans fenetre
        j.add(jMoniteur);
        j.add(jTableau);
        this.add(j);
    }
}
