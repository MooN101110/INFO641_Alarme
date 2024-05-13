public class MoniteurA extends Moniteur{

    //Constructeur
    public MoniteurA(String n) {
        super(n);
    }

    //Méthode
    public void nouvelleAnomalie(AnomalieEvent anomalie){
        listeAnomalies.add(anomalie);
        System.out.println("\u001B[38;5;144mNouvelle Anomalie détéctée - Incendie en cours\u001B ");
    }
    

}
