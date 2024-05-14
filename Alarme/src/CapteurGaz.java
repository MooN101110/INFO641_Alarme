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

    public void addMoniteur(Moniteur m){
        if(m instanceof MoniteurB){
            listeMoniteurs.add(m);
            System.out.println("\u001B[38;5;10mMoniteur ajouté\u001B[0m");
        }
        else{
            System.out.println("\u001B[38;5;9mErreur - type du moniteur incompatible\u001B[0m"); 
        }
    }

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
            GazEvent g1 = new GazEvent(this,date,localisation,niveauI,typeGaz,niveau);
            for (Moniteur m : listeMoniteurs){
                m.nouvelleAnomalie(g1);
            }
        }
    }

    
}
