package Data;

import java.io.Serializable;
public class Pracownik_Administracyjny extends Pracownik_Uczelni implements Serializable {
    private String stanowisko_pracy;
    private String staz_pracy;
    private int liczba_nadgodzin;
    private int pensja;

    public Pracownik_Administracyjny(int liczba_nadgodzin, int pensja,
                                     String stanowisko, String staz, String imie, String nazwisko, String  pesel,
                                     String plec, int wiek)
    {
        super(stanowisko, staz, pensja, imie, nazwisko, pesel, plec, wiek);
        this.liczba_nadgodzin=liczba_nadgodzin;
        this.pensja=pensja;
        this.stanowisko_pracy=stanowisko_pracy;
        this.staz_pracy=staz_pracy;
    }
    public String getStanowisko_pracy(String stanowisko_pracy){
        return stanowisko_pracy;
    }

    public String getStaz_pracy(String staz_pracy) {
        return staz_pracy;
    }

    public int getLiczba_nadgodzin(int liczba_nadgodzin) {
        return liczba_nadgodzin;
    }

    public int getPensja(int pensja) {
        return pensja;
    }

    public void setLiczba_nadgodzin(int liczba_nadgodzin) {
        this.liczba_nadgodzin = liczba_nadgodzin;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public void setStanowisko_pracy(String stanowisko_pracy) {
        this.stanowisko_pracy = stanowisko_pracy;
    }

    public void setStaz_pracy(String staz_pracy) {
        this.staz_pracy = staz_pracy;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}