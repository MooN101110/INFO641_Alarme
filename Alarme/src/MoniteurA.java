public class MoniteurA extends Moniteur{

    //Constructeur
    public MoniteurA(String n) {
        super(n);
    }

    //Méthode
    public void nouvelleAnomalie(AnomalieEvent anomalie){
        listeAnomalies.add(anomalie);

        if(anomalie instanceof GazEvent){
            if(anomalie.niveauImportance == 1){
                System.out.println("\u001B[38;5;196mNouvelle Anomalie détéctée - Emission de gaz au dessus des seuils de sécurité\u001B[0m");
            }
            else if(anomalie.niveauImportance == 2){
                System.out.println("\u001B[38;5;208mNouvelle Anomalie détéctée - Emission de gaz au dessus des seuils de sécurité\u001B[0m");
            }
            else{
                System.out.println("\u001B[38;5;220mNouvelle Anomalie détéctée - Emission de gaz au dessus des seuils de sécurité\u001B[0m");
            }
        }
        else{
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

    public void traiterAnomalie(AnomalieEvent anomalie){
        if(listeAnomalies.contains(anomalie)){
            listeAnomalies.remove(anomalie);
            System.out.println("\u001B[38;5;150mAnomalie traitée\u001B[0m");
        }  
    }
    

}
