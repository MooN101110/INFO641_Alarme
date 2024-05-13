public class CapteurGaz extends Capteur {
    //Attributs
    private int niveau;
    private int seuil;
    private String typeGaz;

    //Constructeur
    public CapteurGaz(String no,String l,int n, int s,String tg) {
        super(no,l);
        niveau=n;
        seuil=s;
        typeGaz=tg;
    }

    //Methode
    public String toString(){
        return super.toString()+" Type de gaz :"+typeGaz+"\t Niveau :"+niveau+"\t Seuil maximum :"+seuil;
    }

    public void set(int niv){
        niveau=niv;
        detecterAnomalie();
    }
    
    public void detecterAnomalie(){
        if(niveau>=seuil){
            System.out.print("Choississez le niveau d'importance(1/2/3)");
            String niveauS=System.console().readLine();
            int niveauI=Integer.valueOf(niveauS);
            System.out.print("Rentrez la date du jour : ");
            String date=System.console().readLine();  
            GazEvent g1 = new GazEvent(this,date,localisation,niveauI,typeGaz,niveau);
            for (Moniteur m : listeMoniteurs){
                m.nouvelleAnomalie(g1);
            }
        }
    }

    
}
