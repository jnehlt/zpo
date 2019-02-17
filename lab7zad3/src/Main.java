import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        if(args.length != 3) { throw new IllegalArgumentException(); }

        Integer N = Integer.valueOf(args[0]);
        assert(N > 0);
        Double M = Double.valueOf(args[1]);
        Double S = Double.valueOf(args[2]);
        assert(S > 0);

        Random rand = new Random();
        ArrayList<Double> oOo = new ArrayList<>();
        while(N > 0) {
            oOo.add(rand.nextGaussian() * S + M);
            N--;
        }

        FileOutputStream file = new FileOutputStream(new File("src/data.bin"));
        DataOutputStream data = new DataOutputStream(file);

        for(Double o : oOo) {
            data.writeDouble(
                    o
            );
        }

        data.close();
        file.close();

        FileInputStream f = new FileInputStream(new File("src/data.bin"));
        DataInputStream d = new DataInputStream(f);
        file = new FileOutputStream(new File("src/data.txt"));
        data = new DataOutputStream(file);
        for(int i = 0; i < oOo.size(); i++)
        {
            Double next = d.readDouble();

            data.writeChars(
                    String.valueOf(next)
                    .replace(".", ",")
                    + '\n'
            );
        }
    }
}
