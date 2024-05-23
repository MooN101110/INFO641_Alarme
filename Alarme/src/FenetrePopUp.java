import java.awt.*;
import javax.swing.*;

public class FenetrePopUp extends JFrame {
    //Attributs
    final static int HAUTEUR=300;
    final static int LARGEUR=350;

    public FenetrePopUp(AnomalieEvent anomalie){
        //Initialisation fenetre
        setTitle("Alerte");
        setSize(LARGEUR,HAUTEUR);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);

        JPanel j = new JPanel();
        j.setLayout(new GridLayout(0,1));
        JPanel jInfo = new JPanel();
        jInfo.setLayout(new GridLayout(4,1));
        JPanel jbouton = new JPanel();

        if (anomalie instanceof GazEvent){
            JLabel type = new JLabel("Alarme Gaz");
            JLabel niv = new JLabel("Niveau d'importance : "+anomalie.niveauImportance);
            JLabel date = new JLabel("Date : "+anomalie.date);
            JLabel loca = new JLabel("Localisation : "+anomalie.localisation);
            jInfo.add(type);
            jInfo.add(niv);
            jInfo.add(date);
            jInfo.add(loca);
        }
        else if (anomalie instanceof RadiationEvent){
            JLabel type = new JLabel("Alarme Radiation");
            JLabel niv = new JLabel("Niveau d'importance : "+anomalie.niveauImportance);
            JLabel date = new JLabel("Date : "+anomalie.date);
            JLabel loca = new JLabel("Localisation : "+anomalie.localisation);
            jInfo.add(type);
            jInfo.add(niv);
            jInfo.add(date);
            jInfo.add(loca);
        }
        else {
            JLabel type = new JLabel("Alarme Incendie");
            JLabel niv = new JLabel("Niveau d'importance : "+anomalie.niveauImportance);
            JLabel date = new JLabel("Date : "+anomalie.date);
            JLabel loca = new JLabel("Localisation : "+anomalie.localisation);
            jInfo.add(type);
            jInfo.add(niv);
            jInfo.add(date);
            jInfo.add(loca);
        }

        
        JButton bOk = new JButton("OK");
        jbouton.add(bOk);

        //Ajout dans la fenetre
        j.add(jInfo);
        j.add(jbouton);
        this.add(j);

        bOk.addActionListener(e -> {
            this.dispose();
         }); 

    }
}
