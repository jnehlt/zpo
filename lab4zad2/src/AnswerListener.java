import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerListener implements ActionListener {
    private Exam exam;

    private AnswerListener(){}
    public AnswerListener(Exam exam) {
        this.exam = exam;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        exam.goNext();
    }
}
