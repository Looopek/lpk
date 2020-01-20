import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void usun_po_imieniu(String imie) {
        for (int i=0;i<osoby.size();i++) {
            if (osoby.get(i).getImie() == imie) osoby.remove(osoby.get(i));
        }
    }

    public static void usun_po_pesel(String pesel) {
        for (int i=0;i<osoby.size();i++) {
            if (osoby.get(i).getPesel() == pesel) osoby.remove(osoby.get(i));
        }
    }

    public static ObjectInputStream input;
    public static ObjectOutputStream outputStream;
    public static ArrayList<Osoba> osoby;
    public static ArrayList<Kurs> kursy;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Pracownik_Badawczo_Dydaktyczny Profesor = new Pracownik_Badawczo_Dydaktyczny(22, "Profesor", "20 lat",
                5000, "Paolo", "Nowak", "567567567", "M", 90);
        Pracownik_Badawczo_Dydaktyczny Wykladowca = new Pracownik_Badawczo_Dydaktyczny(10,"wykladowca","10 lat",5000,"Mario","Dan","1321312","m",55);
        Kurs matematyka = new Kurs("matematyka", Profesor, 10);
        Kurs programowanie = new Kurs("programowanie", Profesor, 4);
        Kurs filozofia = new Kurs("filozofia", Wykladowca, 4);
        Kurs[] kierunek1 = new Kurs[]{matematyka};
        Kurs[] kierunek2 = new Kurs[]{programowanie, filozofia};
        Kurs[] kierunek3 = new Kurs[]{matematyka, programowanie};
        kursy = new ArrayList<>();
        kursy.add(matematyka);
        kursy.add(programowanie);
        kursy.add(filozofia);
        osoby = new ArrayList<>();
        osoby.add(new Student("12345678", true, true, false, kierunek1, "Adam", "D", "123345677", "m", 20));
        osoby.add(new Student("123456789", true, false, true, kierunek2, "Damian", "D", "123456789", "M", 24));
        osoby.add(new Student("987654321", false, false, true, kierunek3, "Marzena", "A", "123123123", "K", 22));
        osoby.add(new Pracownik_Badawczo_Dydaktyczny(20, "Wykładowca", "5 lat", 3000, "Marzena", "M", "567567567",
                "K", 40));
        osoby.add(new Pracownik_Badawczo_Dydaktyczny(40, "Adiunkt", "2 lata", 2000, "Mariusz", "Q",
                "789789789", "M", 60));
        osoby.add(new Pracownik_Administracyjny(20, 2500, "Referent", "10 lat", "Jakub", "P", "098098098",
                "M", 70));

        String filepath = "C://Users//Konrad//OneDrive//Pulpit//Lista.txt";
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filepath));
            outputStream.writeInt(osoby.size());
            for (Osoba osoba : osoby) {
                outputStream.writeObject(osoba);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        FileInputStream fis = new FileInputStream(filepath);
        ArrayList<Osoba> objectsList = new ArrayList<Osoba>();
        input = new ObjectInputStream(fis);
        int x = input.readInt();
        System.out.println(x);

        for (int i = 0; i < x; i++) {
            Object obj = input.readObject();
            System.out.println(obj);
            objectsList.add((Osoba) obj);
        }
        System.out.println();
        /*
        Scanner scan = new Scanner((System.in));
        System.out.println("wpisz nr indeksu");
        String nr_indeksu = scan.nextLine();
        System.out.println("Wpisz kierunek");
        String kierunek = scan.nextLine();
        System.out.println("wpisz imie");
        String imie = scan.nextLine();
        System.out.println("wpisz nazwisko");
        String nazwisko = scan.nextLine();
        System.out.println("Wpisz pesel");
        String pesel = scan.nextLine();
        System.out.println("wpisz plec");
        String plec = scan.nextLine();
        osoby.add(new Student(nr_indeksu, true, true, false, kierunek1, imie, nazwisko, pesel, plec, 44));
        System.out.println(osoby.get(6).getImie());
        */
        System.out.println();
        for (int i = 0; i < osoby.size(); i++) {
            System.out.println(osoby.get(i).getImie());
        }
        Collections.sort(osoby, Osoba.OsobaAgeComparator);
        System.out.println();
        for (int i = 0; i < osoby.size(); i++) {
            System.out.println(osoby.get(i).getWiek());
        }
        System.out.println();
        Collections.sort(osoby, Osoba.OsobaNameComparator);
        for (int i = 0; i < osoby.size(); i++) {
            System.out.println(osoby.get(i).getNazwisko());
            System.out.println(" " + osoby.get(i).getImie());
        }
        System.out.println();
        Collections.sort(osoby, Osoba.OsobaSurnameComparator);
        for(int i=0;i<osoby.size();i++){
            System.out.println(osoby.get(i).getNazwisko());
        }
        System.out.println();
        Collections.sort(kursy, Kurs.KursComparator);
        for(int i=0;i<kursy.size();i++){
            System.out.print(kursy.get(i).getECTS());
            System.out.println(" " + kursy.get(i).getProwadzacy().getNazwisko());
        }

        System.out.println();
        usun_po_pesel("123456789");
        for(int i=0;i<osoby.size();i++){
            System.out.println(osoby.get(i).getPesel());
        }
        System.out.println();
        usun_po_imieniu("Marzena");
        for(int i=0;i<osoby.size();i++){
            System.out.println(osoby.get(i).getImie());
        }

    }


}


