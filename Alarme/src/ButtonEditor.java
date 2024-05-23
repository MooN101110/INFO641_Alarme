import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonEditor extends DefaultCellEditor 
{
  private String label;
  private MoniteurA moniteurA;
  private MoniteurB moniteurB;
  protected JButton button;
  private JComboBox moniteurs;

  public ButtonEditor(JCheckBox checkBox, MoniteurA moniteurA, MoniteurB moniteurB, JComboBox moniteurs)
  {
    super(checkBox);
    this.moniteurA=moniteurA;
    this.moniteurB=moniteurB;
    this.moniteurs=moniteurs;
    button = new JButton();
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
        }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
  boolean isSelected, int row, int column) 
  {
    label = (value == null) ? "Détails" : value.toString();
    button.setText(label);
    return button;
  }

  public Object getCellEditorValue() 
  {
    JTable tableau = (JTable) button.getParent();
    int ligne = tableau.getSelectedRow();
    String type = (String) tableau.getValueAt(ligne, 0);

    if(type=="Incendie"){

        Object[] options = {"Traiter", "Fermer"};
        int choix = JOptionPane.showOptionDialog(button,
                "Incendie \n"+moniteurA.listeAnomalies.get(ligne).toString(),
                "Détails de l'anomalie",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        //Bouton traiter
        if(choix==0){
            moniteurA.traiterAnomalie(moniteurA.listeAnomalies.get(ligne));
        }
    }
    else if(type=="Radiation"){
        Object[] options = {"Traiter", "Fermer"};
        int choix = JOptionPane.showOptionDialog(button,
                "Radiation \n"+moniteurB.listeAnomalies.get(ligne).toString(),
                "Détails de l'anomalie",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        //Bouton traiter
        if(choix==0){
            moniteurB.traiterAnomalie(moniteurB.listeAnomalies.get(ligne));
        }
    }
    else{
        Moniteur moniteur;
        if(moniteurs.getSelectedItem()=="Moniteur A"){
            moniteur=moniteurA;
        }
        else{
           moniteur=moniteurB; 
        }
        Object[] options = {"Traiter", "Fermer"};
        int choix = JOptionPane.showOptionDialog(button,
                "Emission de Gaz"+moniteur.listeAnomalies.get(ligne).toString(),
                "Détails de l'anomalie",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        //Bouton traiter
        if(choix==0){
            //Appel des deux moniteurs car gaz dans les deux
            if(moniteurs.getSelectedItem()=="Moniteur A"){

                for(AnomalieEvent event : moniteurB.listeAnomalies){
                    if((event.date == moniteurA.listeAnomalies.get(ligne).date) &&
                    (event.localisation == moniteurA.listeAnomalies.get(ligne).localisation) &&
                    (event.niveauImportance == moniteurA.listeAnomalies.get(ligne).niveauImportance) &&
                    (event instanceof GazEvent)){
                        moniteurB.traiterAnomalie(event);
                    }
                }

                moniteurA.traiterAnomalie(moniteurA.listeAnomalies.get(ligne));
            }
            else{

                for(AnomalieEvent event : moniteurA.listeAnomalies){
                    if((event.date == moniteurB.listeAnomalies.get(ligne).date) &&
                    (event.localisation == moniteurB.listeAnomalies.get(ligne).localisation) &&
                    (event.niveauImportance == moniteurB.listeAnomalies.get(ligne).niveauImportance) &&
                    (event instanceof GazEvent)){
                        moniteurA.traiterAnomalie(event);
                    }
                }

                moniteurB.traiterAnomalie(moniteurB.listeAnomalies.get(ligne));
            }    
        }
    }
    
    return label;
  }

  @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
