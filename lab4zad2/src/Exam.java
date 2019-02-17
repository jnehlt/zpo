public class Exam {
    private Dictionary words;
    private MainWindow window;
    private Word current_word;
    private Float score;

    private Exam() {}
    public Exam(Dictionary words, MainWindow window) {
        this.words = words;
        this.window = window;
        this.score = new Float(0);
        this.current_word = words.getNext();

        window.sendMessage(current_word.Word);
    }

    public void goNext() {
        if(current_word == null){ return; }
        window.cleanTextfield();
        score += current_word.getScore(window.getAnswer());
        System.out.println("Score: " + score);

        current_word = words.getNext();
        if(current_word == null){
            window.sendMessage("Uzyskany wynik to: " + score);
            return;
        }
        window.sendMessage(current_word.Word);
    }
}
