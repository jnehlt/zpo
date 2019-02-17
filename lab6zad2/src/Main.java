import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        //a)
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1939, Calendar.OCTOBER, 1);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(1945, Calendar.MAY, 9);

        Long ww2 = cal2.getTime().getTime() - cal1.getTime().getTime();
        System.out.println(ww2/(1000L*60*60*24) + " dni");

        //b)
        Calendar cal3 = Calendar.getInstance();
        cal3.set(2016, Calendar.JANUARY, 1);
        cal3.add(Calendar.DAY_OF_MONTH, 67);
        System.out.println(cal3.getTime());

        //c)
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2019, Calendar.FEBRUARY, 16);
        Calendar cal5 = Calendar.getInstance();
        cal5.set(1993, Calendar.FEBRUARY, 6);
        int pszestempca = 0;
        while(cal5.getTime().getTime() < cal4.getTime().getTime()) {
            if(cal5.getActualMaximum(Calendar.DAY_OF_MONTH) == 29) {
                pszestempca++;
            }
            cal5.add(Calendar.YEAR, 1);
        }
        System.out.println(pszestempca);
    }
}
