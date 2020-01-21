package Data;
import java.io.Serializable;
import java.util.Comparator;

public abstract class Osoba implements Serializable,Comparable {
    private String imie;
    private String nazwisko;
    private String pesel;
    private String plec;
    private int wiek;

    public Osoba(String imie, String nazwisko, String  pesel, String plec, int wiek) {
        this.imie = imie;
        this.nazwisko= nazwisko;
        this.pesel=pesel;
        this.plec=plec;
        this.wiek=wiek;
    }

    public int getWiek() {
        return wiek;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public String getPlec() {
        return plec;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public static Comparator<Osoba> OsobaSurnameComparator = new Comparator<Osoba>() {

        public int compare(Osoba s1, Osoba s2) {
            String OsobaName1 = s1.getNazwisko().toUpperCase();
            String OsobaName2 = s2.getNazwisko().toUpperCase();

            //ascending order
            return OsobaName1.compareTo(OsobaName2);
        }};
    public static Comparator<Osoba> OsobaNameComparator = new Comparator<Osoba>() {

        public int compare(Osoba s1, Osoba s2) {
            String OsobaName1 = s1.getNazwisko().toUpperCase();
            String OsobaName2 = s2.getNazwisko().toUpperCase();

            //ascending order
            if( OsobaName1!=OsobaName2)return OsobaName1.compareTo(OsobaName2);
            else return s1.getImie().toUpperCase().compareTo((s2.getImie().toUpperCase()));
        }};
    public static Comparator<Osoba> OsobaAgeComparator = new Comparator<Osoba>() {

        public int compare(Osoba s1, Osoba s2) {
            String OsobaName1 = s1.getNazwisko().toUpperCase();
            String OsobaName2 = s2.getNazwisko().toUpperCase();

            //ascending order
            if( OsobaName1!=OsobaName1)return OsobaName1.compareTo(OsobaName2);
            else return s1.getWiek() - s2.getWiek();
        }};

    @Override
    public String toString(){
        return imie + " " + nazwisko + ", pesel: "+ pesel + ", plec: "+ plec + ", wiek: "+ wiek;
    }
}
