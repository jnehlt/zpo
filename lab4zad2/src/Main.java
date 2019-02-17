import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String argv[]) {
        Dictionary dict = null;
        Gson gson_obj = new Gson();
        try {
            String from_json_file = new String(Files.readAllBytes(Paths.get("src/oOo.json")));
            dict = gson_obj.fromJson(from_json_file, Dictionary.class);
            dict.init();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        MainWindow window = new MainWindow();
        Exam exam = new Exam(dict, window);
        AnswerListener listener = new AnswerListener(exam);
        window.setListener(listener);
    }
}
