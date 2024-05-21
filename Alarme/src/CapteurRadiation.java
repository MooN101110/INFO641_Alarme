public class CapteurRadiation extends Capteur {
    //Attributs
    private int niveau;
    private int seuil;

    //Constructeur
    public CapteurRadiation(String no,String l,int n, int s) {
        super(no,l);
        niveau=n;
        seuil=s;
    }

    //Methode
    public String toString(){
        return super.toString()+" Niveau :"+niveau+"\t Seuil maximum :"+seuil;
    }

    public void set(int niv){
        niveau=niv;
        detecterAnomalie();
    }

    public void addMoniteur(Moniteur m){
        if(m instanceof MoniteurB){
            listeMoniteurs.add(m);
            System.out.println("\u001B[38;5;10m"+super.nom+" ->Moniteur ajouté\u001B[0m");
        }
        else{
            System.out.println("\u001B[38;5;9m"+super.nom+" ->Erreur - type du moniteur incompatible\u001B[0m"); 
        }
    }
    
    public void detecterAnomalie(){
        if(niveau>=seuil){
            System.out.print("\u001B[38;5;33mChoississez le niveau d'importance(1/2/3)\u001B[0m");
            String niveauS=System.console().readLine();
            int niveau=Integer.valueOf(niveauS);
            System.out.print("\u001B[38;5;33mRentrez la date du jour : \u001B[0m");
            String date=System.console().readLine();  
            RadiationEvent r1 = new RadiationEvent(this,date, localisation, niveau,niveau);
            for (Moniteur m : listeMoniteurs){
                m.nouvelleAnomalie(r1);
            }
        }
    }

    //Pour l'interface
    public void setInterface(int niv,String date, int niveauI){
        niveau=niv;
        detecterAnomalieInterface(niv, date, niveauI);
    }
    
    public void detecterAnomalieInterface(int niv,String date, int niveauI){
        if(niveau>=seuil){
            RadiationEvent g1 = new RadiationEvent(this,date,localisation,niveauI,niv);
            for (Moniteur m : listeMoniteurs){
                m.nouvelleAnomalie(g1);
            }
            FenetrePopUp f = new FenetrePopUp(g1);
            f.setVisible(true);
        }
    }
}
