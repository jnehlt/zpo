import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        String [] firsNames = {"Dominika", "Dominik", "Jerzy", "Igor", "Zygmunt", "Protazy", "Gerwazy"};
        String [] lastNames = {"Wiśniewski", "Wójcik", "Nowak", "Jarek", "Lewandowski", "Martyniuk"};

        ArrayList<Student> s_l = new ArrayList<>();

        for(String f : firsNames) {
            Random rand = new Random();
            Calendar callendar = Calendar.getInstance();
            callendar.set(1990 + rand.nextInt(4), rand.nextInt(12), rand.nextInt(5));
            s_l.add(new Student(f, lastNames[rand.nextInt(6)], callendar.getTime(), rand.nextFloat() * 200));
        }
        for(Student s : s_l) {
            System.out.println(s);
        }

        ArrayList<Student> copyOf_s_l = new ArrayList<>(s_l);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("POSORTOWANE JDKComparator");
        System.out.println();

        Collections.sort(s_l, new JDKComp());
        for(Student s : s_l) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("POSORTOWANE GuavaComparator");
        System.out.println();
        Collections.sort(copyOf_s_l, new GuavaComp());
        for(Student s : copyOf_s_l) {
            System.out.println(s);
        }
    }
}
