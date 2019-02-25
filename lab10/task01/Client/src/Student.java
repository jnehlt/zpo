import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String imie;
    private String nazwisko;
    private int nrIndeksu;
    private ArrayList<Integer> listaOcen;

    public Student(String imie, String nazwisko, int nrIndeksu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrIndeksu = nrIndeksu;
        listaOcen = new ArrayList<>();
    }

    @Override
    public String toString(){
        StringBuilder oceny = new StringBuilder();
        listaOcen.forEach(integer -> oceny.append(integer).append(" "));

        return imie + " " + nazwisko + " " + nrIndeksu + ", oceny: " + oceny;
    }

    public void dodajOcene(int ocena){
        listaOcen.add(ocena);
    }

    public int getNrIndeksu(){
        return nrIndeksu;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
