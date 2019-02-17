import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{
    @org.junit.jupiter.api.Test
    void split()
    {
        Integer test_len = 5;
        String test_string = "Testuje rzeczy oczywiste.";

        Splitter splitter = Splitter.fixedLength(test_len);
        Iterable<String> takie_samo = splitter.split(test_string);
        Iterable<String> my_split = Main.split(test_string, test_len);

        Iterator<String> i_my_split = my_split.iterator();
        Iterator<String> i_takie_samo = takie_samo.iterator();

        while(i_my_split.hasNext() && i_takie_samo.hasNext()) {
            assertEquals(i_my_split.next(), i_takie_samo.next());
        }

        assertFalse(i_my_split.hasNext());
        assertFalse(i_takie_samo.hasNext());


    }
}