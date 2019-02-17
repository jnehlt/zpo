import java.util.ArrayList;

public class LazyList extends ArrayList<Float> {
    private Float start;
    private Float end;
    private Float step;
    private Integer list_size;
    private Function f;

    private LazyList(){}
    public LazyList(Float start, Float end, Float step) {
        this.start = start;
        this.end = end;
        if(step < 0) { throw new IllegalArgumentException(); }
        this.step = step;
        list_size = (int)( (end - start) / step );

        f = x -> (2 * x * x - 3 * x - 17);
    }

    @Override
    public int size() { return list_size; }

    @Override
    public Float get(int x) {
        if(x < 0 || x > list_size) { throw new IllegalArgumentException(); }
        return f.calcY(at(x));
    }

    public Float at(int index) {
        return start + index * step;
    }
}
