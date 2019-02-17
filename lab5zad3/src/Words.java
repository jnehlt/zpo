import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

public class Words {
    private URL url;
    public ArrayList<String> words;

    private Words(){}
    public Words(URL url) throws Exception {
        this.url = url;
        words = new ArrayList<>();

        getWords();
    }

    public void getWords() throws Exception {
        HashSet<String> words = new HashSet<>();
        BufferedReader Reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String NextWord;
        while((NextWord = Reader.readLine()) != null) {
            words.add(NextWord);
        }
        this.words.addAll(words);
    }
}
