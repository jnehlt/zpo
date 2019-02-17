import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Random;

public class Jasio {
    HashSet<String> RememberedWords;
    ArrayDeque<HashSet<String>> NewestWords;
    HashSet<String> ForgottenWords;
    Words words;

    private Jasio() {}
    public Jasio(Words words) {
        RememberedWords = new HashSet<>();
        NewestWords = new ArrayDeque<>();
        ForgottenWords = new HashSet<>();
        this.words = words;
    }

    public void JasioForget() {
        ForgottenWords.clear();
        Random rand = new Random();
        for(int i = 0; i < 2; i++) {
            if(rand.nextFloat() < 0.5) { continue; }
            if(RememberedWords.size() == 0) { return; }
            int br = rand.nextInt(RememberedWords.size());
            String temp = new String();
            for(String s : RememberedWords) {
                temp = s;
                if(br-- == 0) { break; }
            }
            RememberedWords.remove(temp);
            ForgottenWords.add(temp);
        }
    }

    public void JasioRemember() {
        Random rand = new Random();
        HashSet<String> newest = new HashSet<>();
        for(int i = 0; i < 2; i++) {
            int index = rand.nextInt(words.words.size());
            newest.add(words.words.get(index));
            words.words.remove(index);
        }
        NewestWords.add(newest);

        if(NewestWords.size() > 2) {
            RememberedWords.addAll(NewestWords.pollFirst());
        }
    }

    public String toString(){
        StringBuilder storyOfMyLife = new StringBuilder();

        storyOfMyLife.append("\nDziś nauczyłem się: \n");
        for(String s : NewestWords.getLast()) {
            storyOfMyLife.append("  - " + s + "\n");
        }

        storyOfMyLife.append("Znam już na pamięć: \n");
        for(String s : RememberedWords){
            storyOfMyLife.append("  - " + s + "\n");
        }
        for(HashSet<String> h : NewestWords){
            for(String s : h) {
                storyOfMyLife.append("  - " + s + "\n");
            }
        }

        storyOfMyLife.append("\nZapomniałem: \n");
        for(String s : ForgottenWords){
            storyOfMyLife.append("  - " + s + "\n");
        }

        return storyOfMyLife.toString();
    }
}
