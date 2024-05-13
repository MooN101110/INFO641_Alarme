public class GazEvent extends AnomalieEvent {

    //Attributs
    private String type;
    private int niveau;

    //Constructeur
    public GazEvent(Object source, String d, String l, int ni,String t, int n) {
        super(source,d, l, ni);
        type=t;
        niveau=n;
    }
    
}
