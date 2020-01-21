package Controller;

import Data.*;
import Interface.GUI;
import Logic.Logic;

import java.io.IOException;

public class Main {
    private static Logic logika;

    public static void main(String[] args) {
        logika = new Logic();
        GUI.showGUI();
    }

    public static String znajdz(String pesel){
        Osoba osoba = logika.znajdz(pesel);
        if(osoba==null)return "Nie znaleziono.";
        else return osoba.toString();
    }

    public static boolean usun_po_imieniu(String imie) {
        return logika.usun_po_imieniu(imie);
    }

    public static boolean usun_po_pesel(String pesel) {
        return logika.usun_po_pesel(pesel);
    }

    public static void dodaj_student(String nr_indeksu, boolean czy_erasmus, boolean czy_1stopien, boolean czy_2stopien, String imie, String nazwisko, String pesel, String plec,int wiek){
        Student osoba = new Student(nr_indeksu, czy_erasmus, czy_1stopien, czy_2stopien, new Kurs[0], imie, nazwisko, pesel, plec, wiek);
        logika.dodaj_osobe(osoba);
    }

    public static void dodaj_pracownik_administracyjny(int liczba_nadgodzin, int pensja, String stanowisko, String staz, String imie, String nazwisko, String pesel, String plec, int wiek){
        Pracownik_Administracyjny osoba = new Pracownik_Administracyjny(liczba_nadgodzin, pensja, stanowisko, staz, imie, nazwisko, pesel, plec, wiek);
        logika.dodaj_osobe(osoba);
    }

    public static void dodaj_pracownik_badawczo_dydaktyczny(int punktacja, String stanowisko, String staz, int pensja, String imie, String nazwisko, String pesel, String plec, int wiek){
        Pracownik_Badawczo_Dydaktyczny osoba = new Pracownik_Badawczo_Dydaktyczny(punktacja, stanowisko, staz, pensja, imie, nazwisko, pesel, plec, wiek);
        logika.dodaj_osobe(osoba);
    }

    public static void wczytaj(String sciezka){
        try {
            logika.wczytaj(sciezka);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zapisz(String sciezka){
        try {
            logika.zapisz(sciezka);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}