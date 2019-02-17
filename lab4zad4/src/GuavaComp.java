import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

public class GuavaComp implements Comparator<Student>
{
    @Override
    public int compare(Student o1, Student o2) {
        return ComparisonChain
                .start()
                .compare(o1.getYear(), o2.getYear())
                .compare(o1.getFirstLetter(), o2.getFirstLetter())
                .compare(o2.wzrost, o1.wzrost)
                .result();
    }
}
