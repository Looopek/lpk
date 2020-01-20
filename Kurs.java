import java.io.Serializable;
import java.util.Comparator;

public class Kurs implements Serializable {
    private String nazwa_kursu;
    private Pracownik_Badawczo_Dydaktyczny prowadzacy;
    private int ECTS;

    public Kurs(String nazwa_kursu, Pracownik_Badawczo_Dydaktyczny prowadzacy, int ECTS) {
        this.nazwa_kursu = nazwa_kursu;
        this.ECTS = ECTS;
        this.prowadzacy = prowadzacy;
    }

    public String getNazwa_kursu() {
        return nazwa_kursu;
    }

    public int getECTS() {
        return ECTS;
    }

    public Pracownik_Badawczo_Dydaktyczny getProwadzacy() {
        return prowadzacy;
    }

    public void setNazwa_kursu(String nazwa_kursu) {
        this.nazwa_kursu = nazwa_kursu;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }

    public void setProwadzacy(Pracownik_Badawczo_Dydaktyczny prowadzacy) {
        this.prowadzacy = prowadzacy;
    }
    public static Comparator<Kurs> KursComparator = new Comparator<Kurs>() {

        public int compare(Kurs s1, Kurs s2) {
           if(s1.getECTS() != s2.getECTS())return s1.getECTS()-s2.getECTS();
            else return s1.getProwadzacy().getNazwisko().toUpperCase().compareTo(s2.getProwadzacy().getNazwisko());
        }};
}
