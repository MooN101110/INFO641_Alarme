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
    
    public void detecterAnomalie(){
        if(niveau>=seuil){
            System.out.print("Choississez le niveau d'importance(1/2/3)");
            String niveauS=System.console().readLine();
            int niveau=Integer.valueOf(niveauS);
            System.out.print("Rentrez la date du jour : ");
            String date=System.console().readLine();  
            RadiationEvent r1 = new RadiationEvent(this,date, localisation, niveau,niveau);
            for (Moniteur m : listeMoniteurs){
                m.nouvelleAnomalie(r1);
            }
        }
    }
}
