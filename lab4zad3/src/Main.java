import com.google.common.base.Splitter;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        for(String i : split("Bardzo mi się chce to robić.", 5)){
            System.out.println(i);
        }
        System.out.println();
        System.out.println();
        System.out.println();

        Splitter splitter = Splitter.fixedLength(5);
        Iterable<String> takieSamo = splitter.split("Bardzo mi się chce to robić.");
        for(String i : takieSamo) {
            System.out.println(i);
        }
    }

    public static ArrayList<String> split(String s, Integer length) {

        ArrayList<String> ret = new ArrayList<>();
        for(int i = 0; i < s.length(); i+=length) {
            ret.add(s.substring(i, i+length < s.length() ? i+length : s.length()));
        }
        return ret;
    }
}
