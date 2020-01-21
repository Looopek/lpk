package Logic;

import Data.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Logic {

    private ArrayList<Osoba> osoby;
    private HashSet<String> studenci;
    private HashSet<String> pracownicy;

    public Logic(){
        osoby = new ArrayList<>();
        studenci = new HashSet<>();
        pracownicy = new HashSet<>();
    }

    public Osoba znajdz(String pesel) {
        for (int i=0;i<osoby.size();i++) {
            if (osoby.get(i).getPesel().equals(pesel)) {
                return osoby.get(i);
            }
        }
        return null;
    }

    public boolean usun_po_imieniu(String imie) {
        boolean usunieto = false;
        for (int i=0;i<osoby.size();i++) {
            if (osoby.get(i).getImie().equals(imie)) {
                if(osoby.get(i) instanceof Student){
                    studenci.remove((((Student) osoby.get(i)).GetNr_indeksu()));
                }else{
                    pracownicy.remove(osoby.get(i).getPesel());
                }
                osoby.remove(osoby.get(i));
                usunieto = true;
            }
        }
        return usunieto;
    }

    public boolean usun_po_pesel(String pesel) {
        for (int i=0;i<osoby.size();i++) {
            if (osoby.get(i).getPesel().equals(pesel)) {
                if(osoby.get(i) instanceof Student){
                    studenci.remove((((Student) osoby.get(i)).GetNr_indeksu()));
                }else{
                    pracownicy.remove(osoby.get(i).getPesel());
                }
                osoby.remove(osoby.get(i));
                return true;
            }
        }
        return false;
    }

    public void dodaj_osobe(Osoba osoba){
        if(osoba instanceof Student) {
            if(studenci.contains(((Student) osoba).GetNr_indeksu()))return;
            else studenci.add(((Student) osoba).GetNr_indeksu());
        }else{
            if(pracownicy.contains(osoba.getPesel())) return;
            else pracownicy.add(osoba.getPesel());
        }
        osoby.add(osoba);
    }

    public void zapisz(String sciezka) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(sciezka));
        outputStream.writeInt(osoby.size());
        for (Osoba osoba : osoby) {
            outputStream.writeObject(osoba);
        }
    }

    public void wczytaj(String sciezka) throws Exception {
        osoby = new ArrayList<>();
        studenci = new HashSet<>();
        pracownicy = new HashSet<>();
        FileInputStream fis = new FileInputStream(sciezka);
        ObjectInputStream input = new ObjectInputStream(fis);
        int x = input.readInt();
        for (int i = 0; i < x; i++) {
            Object obj = input.readObject();
            osoby.add((Osoba) obj);
        }
    }
}
