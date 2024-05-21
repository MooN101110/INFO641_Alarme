import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.*;
import java.util.ArrayList;

public class Fenetre extends JFrame implements ActionListener {
	
	//Attributs
		final static int HAUTEUR=500;
		final static int LARGEUR=350;
        private JComboBox jTypeAlarme;
		
    //Constructeur
    public Fenetre(ArrayList<CapteurIncendie> capteursI, ArrayList<CapteurRadiation> capteursR, ArrayList<CapteurGaz> capteursG) {
        //Initialisation fenetre
        setTitle("Gestion alarme");
        setSize(LARGEUR,HAUTEUR);
        this.getContentPane().setBackground(Color.WHITE);

        JPanel j = new JPanel();
        j.setLayout(new GridLayout(0,1));
        JPanel jBase = new JPanel();
        // //Création bouton menu
        // JButton bAlarme = new JButton("Génération des alarmes");
        // JButton bMoniteur= new JButton("Gestion des moniteurs");

        // //Ajout dans la fenêtre
        // this.add(bAlarme,"West");
        // this.add(bMoniteur,"East");

        //Création des listes déroulantes
        Object[] batiments = new Object[]{"Batiment A","Batiment B","Batiment C"};
        JComboBox jBatiment = new JComboBox(batiments);

        Object[] types = new Object[]{"Incendie","Gaz","Radiation"};
        jTypeAlarme= new JComboBox(types);

        Object[] niveaux = new Object[]{"1","2","3"};
        JComboBox jNiveaux = new JComboBox(niveaux);

        JLabel ldate = new JLabel("Date :");
        JTextField tdate = new JTextField("01/01/2024");

        //Ajout à la fenetre
        jBase.add(jBatiment);
        jBase.add(jTypeAlarme);
        jBase.add(jNiveaux);
        jBase.add(ldate);
        jBase.add(tdate);
        j.add(jBase);

        //Ajout données relatives au capteur gaz
        JPanel jGaz = new JPanel();
        jGaz.setVisible(false);
        JLabel lTypeGaz = new JLabel("Choississez votre type de gaz :");
        JTextField tTypeGaz = new JTextField("CO2");
        JLabel lniveau = new JLabel("Choississez le niveau de gaz:");
        JTextField tniveau = new JTextField("50");
    
        jGaz.add(lTypeGaz);
        jGaz.add(tTypeGaz);
        jGaz.add(lniveau);
        jGaz.add(tniveau);

        j.add(jGaz);

        //Ajout données relatives au capteur radiation
        JPanel jRadiation = new JPanel();
        jRadiation.setVisible(false);
        JLabel lniveauR = new JLabel("Choississez le niveau de Radiation:");
        JTextField tniveauR = new JTextField("50");

        jRadiation.add(lniveauR);
        jRadiation.add(tniveauR);

        j.add(jRadiation);

        this.add(j);

        //Bouton execution
        JButton bValider = new JButton("Valider");
        this.add(bValider, "South");


        //Surveillance de la valeur du type de capteur
        jTypeAlarme.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String item = String.valueOf(jTypeAlarme.getSelectedItem());
                if (item == "Radiation"){
                    jGaz.setVisible(false);
                    jRadiation.setVisible(true);
                }
                else if (item == "Gaz"){
                    jGaz.setVisible(true);
                    jRadiation.setVisible(false);
                }
                else{
                    jGaz.setVisible(false);
                    jRadiation.setVisible(false);
                }

            }

        });

        bValider.addActionListener(new AlarmeListener(capteursI, capteursR,capteursG,jBatiment,jNiveaux,jTypeAlarme,tdate,tTypeGaz,tniveau,tniveauR));
   
}

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

  
}
