import java.util.ArrayList;

public abstract class Capteur {
    //Attributs
    protected String nom,localisation;
    protected ArrayList<Moniteur> listeMoniteurs;

    //Constructeur
    public Capteur(String n, String l){
        nom=n;
        localisation=l;
        listeMoniteurs = new ArrayList<Moniteur>();
    }

    //Methode
    public String toString(){
        return"Nom : "+nom+"\tLocalisation : "+localisation;
    }

    public void addMoniteur(Moniteur m){
        listeMoniteurs.add(m);
    }
    
    public void detecterAnomalie(){};

    public void setInterface(){};
}
