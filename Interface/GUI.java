package Interface;

import Controller.Main;
import Data.Osoba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI extends JPanel implements ActionListener {
    private JFileChooser wybierz_plik;
    private JButton wczytaj;
    private JButton zapisz;

    private JButton dodaj;
    private JButton pokaz_wszystkich;
    private JButton znajdz;
    private JButton usun_pesel;
    private JButton usun_imie;
    private JTextField wpisz;

    private JTabbedPane dodawanie;

    private JTextField student_indeks;
    private JCheckBox student_erasmus;
    private JCheckBox student_czy_1stopien;
    private JCheckBox student_czy_2stopien;
    private JTextField student_imie;
    private JTextField student_nazwisko;
    private JTextField student_pesel;
    private JTextField student_plec;
    private JTextField student_wiek;

    private JTextField pracownik_administracyjny_nadgodziny;
    private JTextField pracownik_administracyjny_pensja;
    private JTextField pracownik_administracyjny_stanowisko;
    private JTextField pracownik_administracyjny_staz;
    private JTextField pracownik_administracyjny_imie;
    private JTextField pracownik_administracyjny_nazwisko;
    private JTextField pracownik_administracyjny_pesel;
    private JTextField pracownik_administracyjny_plec;
    private JTextField pracownik_administracyjny_wiek;

    private JTextField pracownik_badawczo_dydaktyczny_punktacja;
    private JTextField pracownik_badawczo_dydaktyczny_stanowisko;
    private JTextField pracownik_badawczo_dydaktyczny_staz;
    private JTextField pracownik_badawczo_dydaktyczny_pensja;
    private JTextField pracownik_badawczo_dydaktyczny_imie;
    private JTextField pracownik_badawczo_dydaktyczny_nazwisko;
    private JTextField pracownik_badawczo_dydaktyczny_pesel;
    private JTextField pracownik_badawczo_dydaktyczny_plec;
    private JTextField pracownik_badawczo_dydaktyczny_wiek;

    private GUI(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        wybierz_plik = new JFileChooser();
        wybierz_plik.setCurrentDirectory(new File(System.getProperty("user.home")+ "/Desktop"));
        setPreferredSize(new Dimension(800, 600));

        JPanel gora = new JPanel();
        wczytaj = new JButton("Wczytaj");
        zapisz = new JButton("Zapisz");
        wczytaj.addActionListener(this);
        zapisz.addActionListener(this);
        gora.add(wczytaj);
        gora.add(zapisz);

        JPanel srodek = new JPanel();
        srodek.add(stworz_dodawanie());

        JPanel dol = new JPanel(new GridLayout(2, 0));
        JPanel usuwanie = new JPanel();
        znajdz = new JButton("Znajdz po peselu");
        usun_pesel = new JButton("Usun po peselu");
        usun_imie = new JButton("Usun po imieniu");
        wpisz = new JTextField(10);
        znajdz.addActionListener(this);
        usun_pesel.addActionListener(this);
        usun_imie.addActionListener(this);
        usuwanie.add(wpisz);
        usuwanie.add(znajdz);
        usuwanie.add(usun_pesel);
        usuwanie.add(usun_imie);

        JPanel guziki = new JPanel();
        dodaj = new JButton("Dodaj");
        dodaj.addActionListener(this);
        pokaz_wszystkich = new JButton("Pokaz wszystkich");
        pokaz_wszystkich.addActionListener(this);
        guziki.add(dodaj);
        guziki.add(pokaz_wszystkich);
        dol.add(guziki);
        dol.add(usuwanie);

        add(gora);
        add(srodek);
        add(dol);
    }

    public static void showGUI() {
        JFrame frame = new JFrame("Uczelnia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GUI(), BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == wczytaj) {
            int result = wybierz_plik.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = wybierz_plik.getSelectedFile();
                Main.wczytaj(selectedFile.getAbsolutePath());
            }
        } else if (e.getSource() == zapisz) {
            int result = wybierz_plik.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = wybierz_plik.getSelectedFile();
                Main.zapisz(selectedFile.getAbsolutePath());
            }
        } else if (e.getSource() == dodaj) {
            wykonaj_dodaj();
        }else if (e.getSource() == pokaz_wszystkich) {
            wykonaj_pokaz_wszystkich();
        } else if (e.getSource() == znajdz) {
            wykonaj_znajdz();
        } else if (e.getSource() == usun_pesel) {
            wykonaj_usun_pesel();
        } else if (e.getSource() == usun_imie) {
            wykonaj_usun_imie();
        }else{
            System.out.println(e.getSource());
        }
    }

    private void wykonaj_pokaz_wszystkich(){
        String wszyscy = Main.wszystkie_osoby();
        if(wszyscy.equals(""))wszyscy = "Brak dodanych osob.";
        else wszyscy = "<html><body width='750'>" + wszyscy.replaceAll("\n", "<br><br>");
        JOptionPane.showMessageDialog(null, wszyscy);
    }

    private void wykonaj_znajdz(){
        JOptionPane.showMessageDialog(null, Main.znajdz(wpisz.getText()));
    }

    private void wykonaj_usun_pesel(){
        boolean usunieto = Main.usun_po_pesel(wpisz.getText());
        if(usunieto){
            JOptionPane.showMessageDialog(null, "Pomyslnie usunieto osobe!");
        }else{
            JOptionPane.showMessageDialog(null, "Nie znaleziono takiej osoby.");
        }
    }

    private void wykonaj_usun_imie(){
        boolean usunieto = Main.usun_po_imieniu(wpisz.getText());
        if(usunieto){
            JOptionPane.showMessageDialog(null, "Pomyslnie usunieto osoby!");
        }else{
            JOptionPane.showMessageDialog(null, "Nie znaleziono takiej osoby.");
        }
    }

    private void wykonaj_dodaj(){
        int zakladka = dodawanie.getSelectedIndex();
        switch(zakladka){
            case 0: dodaj_student();
                break;
            case 1: dodaj_pracownik_administracyjny();
                break;
            case 2: dodaj_pracownik_badawczo_dydaktyczny();
                break;
        }
    }

    private void dodaj_student(){
        String indeks = student_indeks.getText();
        boolean erasmus = student_erasmus.isSelected();
        boolean czy_1stopien = student_czy_1stopien.isSelected();
        boolean czy_2stopien = student_czy_2stopien.isSelected();
        String imie = student_imie.getText();
        String nazwisko = student_nazwisko.getText();
        String pesel = student_pesel.getText();
        String plec = student_plec.getText();
        int wiek = Integer.parseInt(student_wiek.getText());
        Main.dodaj_student(indeks, erasmus, czy_1stopien, czy_2stopien, imie, nazwisko, pesel, plec, wiek);
    }

    private void dodaj_pracownik_administracyjny(){
        int liczba_nadgodzin = Integer.parseInt(pracownik_administracyjny_nadgodziny.getText());
        int pensja = Integer.parseInt(pracownik_administracyjny_pensja.getText());
        String stanowisko = pracownik_administracyjny_stanowisko.getText();
        String staz = pracownik_administracyjny_staz.getText();
        String imie = pracownik_administracyjny_imie.getText();
        String nazwisko = pracownik_administracyjny_nazwisko.getText();
        String pesel = pracownik_administracyjny_pesel.getText();
        String plec = pracownik_administracyjny_plec.getText();
        int wiek = Integer.parseInt(pracownik_administracyjny_wiek.getText());
        Main.dodaj_pracownik_administracyjny(liczba_nadgodzin, pensja, stanowisko, staz, imie, nazwisko, pesel, plec, wiek);
    }

    private void dodaj_pracownik_badawczo_dydaktyczny(){
        int punktacja = Integer.parseInt(pracownik_badawczo_dydaktyczny_punktacja.getText());
        String stanowisko = pracownik_badawczo_dydaktyczny_stanowisko.getText();
        String staz = pracownik_badawczo_dydaktyczny_staz.getText();
        int pensja = Integer.parseInt(pracownik_badawczo_dydaktyczny_pensja.getText());
        String imie = pracownik_badawczo_dydaktyczny_imie.getText();
        String nazwisko = pracownik_badawczo_dydaktyczny_nazwisko.getText();
        String pesel = pracownik_badawczo_dydaktyczny_pesel.getText();
        String plec = pracownik_badawczo_dydaktyczny_plec.getText();
        int wiek = Integer.parseInt(pracownik_badawczo_dydaktyczny_wiek.getText());
        Main.dodaj_pracownik_badawczo_dydaktyczny(punktacja, stanowisko, staz, pensja, imie, nazwisko, pesel, plec, wiek);
    }

    private JTabbedPane stworz_dodawanie(){
        dodawanie = new JTabbedPane();
        dodawanie.setPreferredSize(new Dimension(500, 400));
        dodawanie.addTab("Student", null, stworz_dodaj_student(), null);
        dodawanie.addTab("Pracownik administracyjny", null, stworz_dodaj_pracownik_administracyjny(), null);
        dodawanie.addTab("Pracownik badawczo-dydaktyczny", null, stworz_dodaj_pracownik_badawczo_dydaktyczny(), null);
        return dodawanie;
    }

    private JPanel stworz_dodaj_student(){
        JPanel dodaj_student = new JPanel(new GridLayout(0,1));

        JPanel nr_indeksu = new JPanel();
        student_indeks = new JTextField(15);
        nr_indeksu.add(new JLabel("Nr indeksu: "));
        nr_indeksu.add(student_indeks);

        JPanel checkboxes = new JPanel();
        student_erasmus = new JCheckBox("Erasmus");
        checkboxes.add(student_erasmus);
        student_czy_1stopien = new JCheckBox("1 Stopien");
        checkboxes.add(student_czy_1stopien);
        student_czy_2stopien = new JCheckBox("2 Stopien");
        checkboxes.add(student_czy_2stopien);

        JPanel imie = new JPanel();
        student_imie = new JTextField(15);
        imie.add(new JLabel("Imie: "));
        imie.add(student_imie);

        JPanel nazwisko = new JPanel();
        student_nazwisko = new JTextField(15);
        nazwisko.add(new JLabel("Nazwisko: "));
        nazwisko.add(student_nazwisko);

        JPanel pesel = new JPanel();
        student_pesel = new JTextField(15);
        pesel.add(new JLabel("Pesel: "));
        pesel.add(student_pesel);

        JPanel plec = new JPanel();
        student_plec = new JTextField(15);
        plec.add(new JLabel("Plec: "));
        plec.add(student_plec);

        JPanel wiek = new JPanel();
        student_wiek = new JTextField(15);
        wiek.add(new JLabel("Wiek: "));
        wiek.add(student_wiek);

        dodaj_student.add(nr_indeksu);
        dodaj_student.add(checkboxes);
        dodaj_student.add(imie);
        dodaj_student.add(nazwisko);
        dodaj_student.add(pesel);
        dodaj_student.add(plec);
        dodaj_student.add(wiek);

        return dodaj_student;
    }

    private JPanel stworz_dodaj_pracownik_administracyjny(){
        JPanel dodaj_pracownik_administracyjny = new JPanel(new GridLayout(0, 1));

        JPanel nadgodziny = new JPanel();
        pracownik_administracyjny_nadgodziny = new JTextField(15);
        nadgodziny.add(new JLabel("Liczba nadgodzin: "));
        nadgodziny.add(pracownik_administracyjny_nadgodziny);

        JPanel pensja = new JPanel();
        pracownik_administracyjny_pensja = new JTextField(15);
        pensja.add(new JLabel("Pensja: "));
        pensja.add(pracownik_administracyjny_pensja);

        JPanel stanowisko = new JPanel();
        pracownik_administracyjny_stanowisko = new JTextField(15);
        stanowisko.add(new JLabel("Stanowisko: "));
        stanowisko.add(pracownik_administracyjny_stanowisko);

        JPanel staz = new JPanel();
        pracownik_administracyjny_staz = new JTextField(15);
        staz.add(new JLabel("Staz: "));
        staz.add(pracownik_administracyjny_staz);

        JPanel imie = new JPanel();
        pracownik_administracyjny_imie = new JTextField(15);
        imie.add(new JLabel("Imie: "));
        imie.add(pracownik_administracyjny_imie);

        JPanel nazwisko = new JPanel();
        pracownik_administracyjny_nazwisko = new JTextField(15);
        nazwisko.add(new JLabel("Nazwisko: "));
        nazwisko.add(pracownik_administracyjny_nazwisko);

        JPanel pesel = new JPanel();
        pracownik_administracyjny_pesel = new JTextField(15);
        pesel.add(new JLabel("Pesel: "));
        pesel.add(pracownik_administracyjny_pesel);

        JPanel plec = new JPanel();
        pracownik_administracyjny_plec = new JTextField(15);
        plec.add(new JLabel("Plec: "));
        plec.add(pracownik_administracyjny_plec);

        JPanel wiek = new JPanel();
        pracownik_administracyjny_wiek = new JTextField(15);
        wiek.add(new JLabel("Wiek: "));
        wiek.add(pracownik_administracyjny_wiek);

        dodaj_pracownik_administracyjny.add(nadgodziny);
        dodaj_pracownik_administracyjny.add(pensja);
        dodaj_pracownik_administracyjny.add(stanowisko);
        dodaj_pracownik_administracyjny.add(staz);
        dodaj_pracownik_administracyjny.add(imie);
        dodaj_pracownik_administracyjny.add(nazwisko);
        dodaj_pracownik_administracyjny.add(pesel);
        dodaj_pracownik_administracyjny.add(plec);
        dodaj_pracownik_administracyjny.add(wiek);

        return dodaj_pracownik_administracyjny;
    }

    private JPanel stworz_dodaj_pracownik_badawczo_dydaktyczny(){
        JPanel dodaj_pracownik_badawczo_dydaktyczny = new JPanel(new GridLayout(0, 1));

        JPanel punktacja = new JPanel();
        pracownik_badawczo_dydaktyczny_punktacja = new JTextField(15);
        punktacja.add(new JLabel("Punktacja: "));
        punktacja.add(pracownik_badawczo_dydaktyczny_punktacja);

        JPanel stanowisko = new JPanel();
        pracownik_badawczo_dydaktyczny_stanowisko = new JTextField(15);
        stanowisko.add(new JLabel("Stanowisko: "));
        stanowisko.add(pracownik_badawczo_dydaktyczny_stanowisko);

        JPanel staz = new JPanel();
        pracownik_badawczo_dydaktyczny_staz = new JTextField(15);
        staz.add(new JLabel("Staz: "));
        staz.add(pracownik_badawczo_dydaktyczny_staz);

        JPanel pensja = new JPanel();
        pracownik_badawczo_dydaktyczny_pensja = new JTextField(15);
        pensja.add(new JLabel("Pensja: "));
        pensja.add(pracownik_badawczo_dydaktyczny_pensja);

        JPanel imie = new JPanel();
        pracownik_badawczo_dydaktyczny_imie = new JTextField(15);
        imie.add(new JLabel("Imie: "));
        imie.add(pracownik_badawczo_dydaktyczny_imie);

        JPanel nazwisko = new JPanel();
        pracownik_badawczo_dydaktyczny_nazwisko = new JTextField(15);
        nazwisko.add(new JLabel("Nazwisko: "));
        nazwisko.add(pracownik_badawczo_dydaktyczny_nazwisko);

        JPanel pesel = new JPanel();
        pracownik_badawczo_dydaktyczny_pesel = new JTextField(15);
        pesel.add(new JLabel("Pesel: "));
        pesel.add(pracownik_badawczo_dydaktyczny_pesel);

        JPanel plec = new JPanel();
        pracownik_badawczo_dydaktyczny_plec = new JTextField(15);
        plec.add(new JLabel("Plec: "));
        plec.add(pracownik_badawczo_dydaktyczny_plec);

        JPanel wiek = new JPanel();
        pracownik_badawczo_dydaktyczny_wiek = new JTextField(15);
        wiek.add(new JLabel("Wiek: "));
        wiek.add(pracownik_badawczo_dydaktyczny_wiek);

        dodaj_pracownik_badawczo_dydaktyczny.add(punktacja);
        dodaj_pracownik_badawczo_dydaktyczny.add(pensja);
        dodaj_pracownik_badawczo_dydaktyczny.add(stanowisko);
        dodaj_pracownik_badawczo_dydaktyczny.add(staz);
        dodaj_pracownik_badawczo_dydaktyczny.add(imie);
        dodaj_pracownik_badawczo_dydaktyczny.add(nazwisko);
        dodaj_pracownik_badawczo_dydaktyczny.add(pesel);
        dodaj_pracownik_badawczo_dydaktyczny.add(plec);
        dodaj_pracownik_badawczo_dydaktyczny.add(wiek);
        return dodaj_pracownik_badawczo_dydaktyczny;
    }

    private JPanel stworz_dodaj_kurs(){
        JPanel dodaj_kurs = new JPanel();
        return dodaj_kurs;
    }
}
