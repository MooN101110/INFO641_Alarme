import java.util.EventObject;

public abstract class AnomalieEvent extends EventObject {
    //Attributs
    String date, localisation;
    int niveauImportance;
    boolean estGere;

    //Constructeur
    public AnomalieEvent(Object source,String d,String l, int n){
        super(source);
        date=d;
        localisation=l;
        niveauImportance=n;
        estGere=false;
    }

    //Méthode
    public String toString(){
        return"Date : "+date+"\nLocalisation : "+localisation+"\nNiveau d'importance : "+niveauImportance;
    }
}
