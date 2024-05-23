import java.util.ArrayList;

public class Principale {
    public static void main(String[] args) throws Exception {
        //Creation des constantes
        ArrayList<CapteurIncendie> capteursI = new ArrayList<CapteurIncendie>();
        ArrayList<CapteurGaz> capteursG = new ArrayList<CapteurGaz>();
        ArrayList<CapteurRadiation> capteursR = new ArrayList<CapteurRadiation>();

        MoniteurA moniteurA = new MoniteurA("Moniteur A");
        MoniteurB moniteurB = new MoniteurB("Moniteur B");
        //Capteur incendie
        CapteurIncendie cIA = new CapteurIncendie("cIA", "Batiment A");
        CapteurIncendie cIB = new CapteurIncendie("cIB", "Batiment B");
        CapteurIncendie cIC = new CapteurIncendie("cIC", "Batiment C");
        cIA.addMoniteur(moniteurA);
        cIB.addMoniteur(moniteurA);
        cIC.addMoniteur(moniteurA);
        capteursI.add(cIA);
        capteursI.add(cIB);
        capteursI.add(cIC);

        //Capteur Gaz
        CapteurGaz cGA = new CapteurGaz("cGA", "Batiment A",20,50);
        CapteurGaz cGB = new CapteurGaz("cGB", "Batiment B",20,50);
        CapteurGaz cGC = new CapteurGaz("cGC", "Batiment C",20,50);
        cGA.addMoniteur(moniteurB);
        cGB.addMoniteur(moniteurB);
        cGC.addMoniteur(moniteurB);
        cGA.addMoniteur(moniteurA);
        cGB.addMoniteur(moniteurA);
        cGC.addMoniteur(moniteurA);
        capteursG.add(cGA);
        capteursG.add(cGB);
        capteursG.add(cGC);

        //Capteur Radiation
        CapteurRadiation cRA = new CapteurRadiation("cRA", "Batiment A", 20, 50);
        CapteurRadiation cRB = new CapteurRadiation("cRA", "Batiment B", 20, 50);
        CapteurRadiation cRC = new CapteurRadiation("cRA", "Batiment C", 20, 50);
        cRA.addMoniteur(moniteurB);
        cRB.addMoniteur(moniteurB);
        cRC.addMoniteur(moniteurB);
        capteursR.add(cRA);
        capteursR.add(cRB);
        capteursR.add(cRC);

        //Création des fenetres
        FenetreAlarme fA = new FenetreAlarme(capteursI,capteursR,capteursG);
		fA.setVisible(true);

        FenetreMoniteur fM = new FenetreMoniteur(moniteurA,moniteurB);
		fM.setVisible(true);
    }
}

