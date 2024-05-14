public class Principale {
    public static void main(String[] args) throws Exception {
        MoniteurA moniteurA = new MoniteurA("Marche!!!!!");
        CapteurIncendie c1 = new CapteurIncendie("c1", "hall");
        System.out.println(moniteurA instanceof MoniteurA);
        c1.addMoniteur(moniteurA);

        MoniteurB moniteurB = new MoniteurB("Marche!!!!!");
        CapteurGaz c2 = new CapteurGaz("c2", "hall",20,50,"oxygène");
        c2.addMoniteur(moniteurB);
        c1.addMoniteur(moniteurB);

        System.out.println(c1);
        c1.set(true);
        c2.set(75);


    }
}

