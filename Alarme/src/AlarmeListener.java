import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class AlarmeListener implements ActionListener {
    //Attributs
    private ArrayList<CapteurIncendie> capteursI;
    private ArrayList<CapteurRadiation> capteursR;
    private ArrayList<CapteurGaz> capteursG;
    private JComboBox jBatiment, jNiveaux, jTypeAlarme;
    private JTextField tdate, tTypeGaz, tniveau, tniveauR;

    //Constructeur
    public AlarmeListener(ArrayList<CapteurIncendie> capteursI, ArrayList<CapteurRadiation> capteursR, ArrayList<CapteurGaz> capteursG,
            JComboBox jBatiment, JComboBox jNiveaux, JComboBox jTypeAlarme,
            JTextField tdate, JTextField tTypeGaz, JTextField tniveau, JTextField tniveauR) {
        this.jBatiment = jBatiment;
        this.jNiveaux = jNiveaux;
        this.jTypeAlarme = jTypeAlarme;
        this.tdate = tdate;
        this.tTypeGaz = tTypeGaz;
        this.tniveau = tniveau;
        this.tniveauR = tniveauR;
        this.capteursI=capteursI;
        this.capteursR=capteursR;
        this.capteursG=capteursG;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Récupération des valeurs
        String batiment = String.valueOf(jBatiment.getSelectedItem());
        String niveauImportanceS = String.valueOf(jNiveaux.getSelectedItem());
        int niveauImportance = Integer.parseInt(niveauImportanceS);
        String typeCapteur = String.valueOf(jTypeAlarme.getSelectedItem());
        String date = tdate.getText();

        if (typeCapteur == "Gaz"){
            String valNIveauS = tniveau.getText();
            int valNIveau = Integer.parseInt(valNIveauS);
            String valTypeGaz = tTypeGaz.getText();
            for(CapteurGaz c : capteursG){
                if (c.localisation == batiment){
                   c.setInterface(valNIveau, date, niveauImportance, valTypeGaz);
                }
            }
        }
        else if (typeCapteur == "Radiation"){
            String valNIveauS = tniveauR.getText();
            int valNIveau = Integer.parseInt(valNIveauS);
            for(CapteurRadiation c : capteursR){
                if (c.localisation == batiment){
                   c.setInterface(valNIveau, date, niveauImportance);
                }
            }

        }
        else {
            for(CapteurIncendie c : capteursI){
                if (c.localisation == batiment){
                   c.setInterface(true, date, niveauImportance);
                }
            }
        }

    }
}
