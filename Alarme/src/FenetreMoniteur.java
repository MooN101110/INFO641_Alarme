import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FenetreMoniteur extends JFrame implements ActionListener{
    //Attributs
		final static int HAUTEUR=500;
		final static int LARGEUR=500;

    //Constructeur
    public FenetreMoniteur(MoniteurA moniteurA, MoniteurB moniteurB) {
        //Initialisation fenetre
        setTitle("Gestion moniteurs");
        setSize(LARGEUR,HAUTEUR);
        this.getContentPane().setBackground(Color.WHITE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2, dim.height/4);


        JPanel j = new JPanel();
        j.setLayout(new GridLayout(2,1));
        JPanel jMoniteur = new JPanel();
        JPanel jTableau = new JPanel();

        //Choix du moniteur
        JLabel tchoix = new JLabel("Choississez un moniteur :");
        Object[] moniteurs = new Object[]{"Moniteur A","Moniteur B"};
        JComboBox cmoniteur = new JComboBox(moniteurs);

        jMoniteur.add(tchoix);
        jMoniteur.add(cmoniteur);

        //Tableau des anomalies
        Object[] colTab = new Object[]{"Type Anomalie","Détails"};
        DefaultTableModel tableModel = new DefaultTableModel(colTab, 0);
        JTable tab_anomalie = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tab_anomalie);

        tab_anomalie.getColumn("Détails").setCellRenderer(new ButtonRenderer());
        tab_anomalie.getColumn("Détails").setCellEditor(new ButtonEditor(new JCheckBox(), moniteurA, moniteurB));

        jMoniteur.add(scroll);

        //Mise à jour du tableau
        cmoniteur.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            if (cmoniteur.getSelectedItem().equals("Moniteur A")) {
                tableModel.setRowCount(0);
                for (AnomalieEvent event : moniteurA.listeAnomalies) {
                  if (event instanceof GazEvent){
                    tableModel.addRow(new Object[]{"Emission de Gaz", "Détails"});
                  }
                  else if(event instanceof IncendieEvent){
                    tableModel.addRow(new Object[]{"Incendie", "Détails"});
                  }
                  else{
                    tableModel.addRow(new Object[]{"Radiation", "Détails"});
                  }
                    
                }
            }
            else if (cmoniteur.getSelectedItem().equals("Moniteur B")){
                tableModel.setRowCount(0);
                for (AnomalieEvent event : moniteurB.listeAnomalies) {
                  if (event instanceof GazEvent){
                    tableModel.addRow(new Object[]{"Emission de Gaz", "Détails"});
                  }
                  else if(event instanceof IncendieEvent){
                    tableModel.addRow(new Object[]{"Incendie", "Détails"});
                  }
                  else{
                    tableModel.addRow(new Object[]{"Radiation", "Détails"});
                  }
                }
            }
        }
      });

        //Ajout dans fenetre
        j.add(jMoniteur);
        j.add(jTableau);
        this.add(j);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
