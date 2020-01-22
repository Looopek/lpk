package Data;

import java.io.Serializable;
public class Student extends Osoba implements Serializable {
    private String nr_indeksu;
    private boolean czy_erasmus;
    private boolean czy_1stopien;
    private boolean czy_2stopien;
    private Kurs[] tab;

    public Student(String nr_indeksu, boolean czy_erasmus, boolean czy_1stopien, boolean czy_2stopien, Kurs[] tab,
                   String imie, String nazwisko, String pesel, String plec,int wiek) {
        super(imie, nazwisko, pesel, plec, wiek);
        this.nr_indeksu = nr_indeksu;
        this.czy_erasmus = czy_erasmus;
        this.czy_1stopien = czy_1stopien;
        this.czy_2stopien = czy_2stopien;
        this.tab = new Kurs[tab.length];
        for (int i = 0; i < tab.length; i++)
            this.tab[i] = tab[i];
    }

    public String GetNr_indeksu() {
        return nr_indeksu;
    }

    public boolean GetCzy_erasmus() {
        return czy_erasmus;
    }

    public boolean GetCzy_1stopien() {
        return czy_1stopien;
    }

    public boolean GetCzy_2stopien() {
        return czy_2stopien;
    }

    public Kurs[] getTab() {
        return tab;
    }

    public void setNr_indeksu(String nr_indeksu) {
        this.nr_indeksu = nr_indeksu;
    }

    public void setCzy_erasmus(boolean czy_erasmus) {
        this.czy_erasmus = czy_erasmus;
    }

    public void setCzy_1stopien(boolean czy_1stopien) {
        this.czy_1stopien = czy_1stopien;
    }

    public void setCzy_2stopien(boolean czy_2stopien) {
        this.czy_2stopien = czy_2stopien;
    }

    public void setTab(Kurs[] tab) {
        for(int i=0 ;i<tab.length; i++){
            this.tab[i]=tab[i];
        }
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + ", nr indeksu: "+nr_indeksu+", erasmus: "+czy_erasmus+", 1 stopien: "+czy_1stopien+", 2 stopien: "+ czy_2stopien;
    }
}