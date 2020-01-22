package Data;

import java.io.Serializable;
public abstract class Pracownik_Uczelni extends Osoba implements Serializable {
    private String stanowisko;
    private String staz;
    private int pensja;

    public Pracownik_Uczelni(String stanowisko, String staz, int pensja,String imie, String nazwisko,
                             String pesel, String plec, int wiek) {
        super(imie, nazwisko, pesel, plec, wiek);
        this.pensja = pensja;
        this.stanowisko = stanowisko;
        this.staz = staz;
    }

    public int getPensja(int pensja) {
        return pensja;
    }

    public String getStanowisko(String stanowisko) {
        return stanowisko;
    }

    public String getStaz(String staz) {
        return staz;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public void setStaz(String staz) {
        this.staz = staz;
    }

    @Override
    public String toString(){
        return super.toString() + ", stanowisko: "+ stanowisko + ", staz: "+ staz + ", pensja: "+ pensja;
    }
}