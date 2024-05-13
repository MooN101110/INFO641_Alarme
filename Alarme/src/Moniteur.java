import java.util.ArrayList;

public class Moniteur implements AnomalieListener {
    //Attribut
    protected String nom;
    protected ArrayList<AnomalieEvent> listeAnomalies;

    //Constructeur
    public Moniteur(String n){
        nom=n;
        listeAnomalies = new ArrayList<AnomalieEvent>();
    }

    //Methode
    public void nouvelleAnomalie(AnomalieEvent anomalie){
        listeAnomalies.add(anomalie);
        System.out.println("\u001B[38;5;144mNouvelle Anomalie détéctée\u001B ");
    }

}
