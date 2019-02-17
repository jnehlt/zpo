public class WrappedBook extends BookDecorator {
    public WrappedBook(Publication p) {
        super(p);
        if( ! p.HasCover() || p.HasWrapper()) {
            throw new IllegalArgumentException();
        }
        p.AddWrapper();
    }

    @Override
    public String toString() { return p.toString() + " in wrapper |"; }
}