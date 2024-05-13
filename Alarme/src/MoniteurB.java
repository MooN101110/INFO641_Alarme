public class MoniteurB extends Moniteur{

    //Constructeur
    public MoniteurB(String n) {
        super(n);
    }

    //Méthode
    public void nouvelleAnomalie(AnomalieEvent anomalie){
        listeAnomalies.add(anomalie);

        System.out.println("\u001B[38;5;144mNouvelle Anomalie détéctée - Niveau au dessus des seuils de sécurité \u001B]");
    }
}
    
