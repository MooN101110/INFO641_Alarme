public class MoniteurA extends Moniteur{

    //Constructeur
    public MoniteurA(String n) {
        super(n);
    }

    //Méthode
    public void nouvelleAnomalie(AnomalieEvent anomalie){
        listeAnomalies.add(anomalie);
        if(anomalie.niveauImportance == 1){
            System.out.println("\u001B[38;5;196mNouvelle Anomalie détéctée - Incendie en cours\u001B[0m");
        }
        else if(anomalie.niveauImportance == 2){
            System.out.println("\u001B[38;5;208mNouvelle Anomalie détéctée - Incendie en cours\u001B[0m");
        }
        else{
            System.out.println("\u001B[38;5;220mNouvelle Anomalie détéctée - Incendie en cours\u001B[0m");
        }
    }
    

}
