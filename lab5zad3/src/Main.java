import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        Words words = new Words(new URL("http://szgrabowski.kis.p.lodz.pl/zpo18/1500.txt"));
        Jasio jasio = new Jasio(words);

        Integer epoch = 10;
        while(epoch > 0) {
            jasio.JasioRemember();
            jasio.JasioForget();
            epoch--;
            System.out.println(jasio);
        }
    }
}
