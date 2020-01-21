package Data;

import java.io.Serializable;
public class Pracownik_Badawczo_Dydaktyczny extends Pracownik_Uczelni implements Serializable {
    private String stanowisko_pracy;
    private String staz_pracy;
    private int punktacja;

    public Pracownik_Badawczo_Dydaktyczny(int punktacja,String stanowisko,
                                          String staz, int pensja, String imie, String nazwisko,
                                          String pesel,String plec, int wiek) {
        super(stanowisko, staz, pensja, imie, nazwisko, pesel, plec, wiek);
        this.punktacja = punktacja;
        this.stanowisko_pracy = stanowisko_pracy;
        this.staz_pracy = staz_pracy;
    }

    public String getStaz_pracy(String staz_pracy) {
        return staz_pracy;
    }

    public int getPunktacja(int punktacja) {
        return punktacja;
    }

    public String getStanowisko_pracy(String stanowisko_pracy) {
        return stanowisko_pracy;
    }

    public void setStaz_pracy(String staz_pracy) {
        this.staz_pracy = staz_pracy;
    }

    public void setStanowisko_pracy(String stanowisko_pracy) {
        this.stanowisko_pracy = stanowisko_pracy;
    }

    public void setPunktacja(int punktacja) {
        this.punktacja = punktacja;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}