public class CapteurGaz extends Capteur {
    //Attributs
    private int niveau;
    private int seuil;

    //Constructeur
    public CapteurGaz(String no,String l,int n, int s) {
        super(no,l);
        niveau=n;
        seuil=s;
    }

    //Methode
    public String toString(){
        return super.toString()+"\t Niveau :"+niveau+"\t Seuil maximum :"+seuil;
    }

    public void addMoniteur(Moniteur m){
            listeMoniteurs.add(m);
            System.out.println("\u001B[38;5;10m"+super.nom+" -> Moniteur ajouté\u001B[0m");
      
    }
    //Quand il n'y a pas d'interface graphique
    public void set(int niv){
        niveau=niv;
        detecterAnomalie();
    }
    
    public void detecterAnomalie(){
        if(niveau>=seuil){
            System.out.print("\u001B[38;5;33mChoississez le niveau d'importance(1/2/3)\u001B[0m");
            String niveauS=System.console().readLine();
            int niveauI=Integer.valueOf(niveauS);
            System.out.print("\u001B[38;5;33mRentrez la date du jour : \u001B[0m");
            String date=System.console().readLine();  
            System.out.print("\u001B[38;5;33mRentrez le type de gaz : \u001B[0m");
            String typeGaz=System.console().readLine();
            GazEvent g1 = new GazEvent(this,date,localisation,niveauI,typeGaz,niveau);
            for (Moniteur m : listeMoniteurs){
                m.nouvelleAnomalie(g1);
            }
        }
    }

    //Pour l'interface
    public void setInterface(int niv,String date, int niveauI, String typeGaz){
        niveau=niv;
        detecterAnomalieInterface(niv, date, niveauI, typeGaz);
    }
    
    public void detecterAnomalieInterface(int niv,String date, int niveauI, String typeGaz){
        if(niveau>=seuil){
            GazEvent g1 = new GazEvent(this,date,localisation,niveauI,typeGaz,niv);
            for (Moniteur m : listeMoniteurs){
                m.nouvelleAnomalie(g1);
            }
            FenetrePopUp f = new FenetrePopUp(g1);
            f.setVisible(true);
        }
    }

    
}
