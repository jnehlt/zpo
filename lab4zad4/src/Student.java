import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class Student implements Comparable<Student> {
    public String imie;
    public String nazwisko;
    public Date data_urodzenia;
    public Float wzrost;

    private Student(){}
    public Student(String i, String n, Date d, Float w){
        imie = i;
        nazwisko = n;
        data_urodzenia = d;
        wzrost = w;


    }

    public String toString() {
        return imie + " " + nazwisko + " " + data_urodzenia.toString() + " " + wzrost.toString();
    }

    public Integer getYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data_urodzenia);
        return cal.get(Calendar.YEAR);
    }

    public Character getFirstLetter() {
        return nazwisko.charAt(0);
    }

    @Override
    public int compareTo(Student o)
    {
        if(this == o) { return 0; }

        Calendar dat1 = Calendar.getInstance();
        Calendar dat2 = Calendar.getInstance();

        dat1.setTime(data_urodzenia);
        dat2.setTime(o.data_urodzenia);
        Integer data1 = dat1.get(Calendar.YEAR);
        Integer data2 = dat2.get(Calendar.YEAR);
        if( ! data1.equals(data2)) {
            return data1 - data2;
        }

        Character litera1 = nazwisko.charAt(0);
        Character litera2 = o.nazwisko.charAt(0);
        if( ! litera1.equals(litera2)) {
            return Character.compare(litera1, litera2);
        }

        return Float.compare(o.wzrost, wzrost);
    }
}
