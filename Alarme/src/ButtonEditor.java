import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonEditor extends DefaultCellEditor 
{
  private String label;
  private MoniteurA moniteurA;
  private MoniteurB moniteurB;
  protected JButton button;
  
  public ButtonEditor(JCheckBox checkBox, MoniteurA moniteurA, MoniteurB moniteurB)
  {
    super(checkBox);
    this.moniteurA=moniteurA;
    this.moniteurB=moniteurB;
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

    if((type=="Incendie") || (type == "Emission de Gaz")){

        Object[] options = {"Traiter", "Fermer"};
        int choix = JOptionPane.showOptionDialog(button,
                moniteurA.listeAnomalies.get(ligne).toString(),
                "Détails de l'anomalie",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);
    }
    else{
        Object[] options = {"Traiter", "Fermer"};
        int choix = JOptionPane.showOptionDialog(button,
                moniteurB.listeAnomalies.get(ligne).toString(),
                "Détails de l'anomalie",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
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
