import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

class Dictionary {
    ArrayList<Word> Words = new ArrayList<>();
    ListIterator<Word> iterator;

    public Dictionary(){}

    public void init() {
        iterator = Words.listIterator();
    }

    public Word getNext() {
        if(iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}