
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

    public void addMoniteur(Moniteur m){
        if(m instanceof MoniteurA){
            listeMoniteurs.add(m);
            System.out.println("\u001B[38;5;10mMoniteur ajouté\u001B[0m");
        }
        else{
            System.out.println("\u001B[38;5;9mErreur - type du moniteur incompatible\u001B[0m"); 
        }
    }

    public void detecterAnomalie(){
        if(feu){
            System.out.print("\u001B[38;5;33mChoississez le niveau d'importance(1/2/3)\u001B[0m");
            String niveauS=System.console().readLine();
            int niveau=Integer.valueOf(niveauS);
            System.out.print("\u001B[38;5;33mRentrez la date du jour : \u001B[0m");
            String date=System.console().readLine();  
            IncendieEvent e1 = new IncendieEvent(this,date, localisation, niveau);
            for (Moniteur m : listeMoniteurs){
                m.nouvelleAnomalie(e1);
            }
        }
    }

        //Pour l'interface
        public void setInterface(boolean etat,String date, int niveauI){
            feu=etat;
            detecterAnomalieInterface( date, niveauI);
        }
        
        public void detecterAnomalieInterface(String date, int niveauI){
            if(feu){
                IncendieEvent e1 = new IncendieEvent(this,date,localisation,niveauI);
                for (Moniteur m : listeMoniteurs){
                    m.nouvelleAnomalie(e1);
                }
            }
        }
}
