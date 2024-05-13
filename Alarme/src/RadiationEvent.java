public class RadiationEvent extends AnomalieEvent{

    //Attributs
    private int niveau;

    //Constructeur    
    public RadiationEvent(Object source, String d, String l, int ni,int n) {
        super(source,d, l, ni);
        niveau=n;
    }
    
}
