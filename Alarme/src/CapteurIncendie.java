
public class CapteurIncendie extends Capteur {
    //Attributs
    private boolean feu;

    //Constructeur
    public CapteurIncendie(String n,String l) {
        super(n,l);
        feu=false;
    }

    //Methode
    public void set(boolean etat){
        feu=etat;
        detecterAnomalie();
    }

    public String toString(){
        return super.toString()+" Etat :"+feu;
    }

    public void detecterAnomalie(){
        if(feu){
            System.out.print("Choississez le niveau d'importance(1/2/3)");
            String niveauS=System.console().readLine();
            int niveau=Integer.valueOf(niveauS);
            System.out.print("Rentrez la date du jour : ");
            String date=System.console().readLine();  
            IncendieEvent e1 = new IncendieEvent(this,date, localisation, niveau);
            for (Moniteur m : listeMoniteurs){
                m.nouvelleAnomalie(e1);
            }
        }
    }
}
