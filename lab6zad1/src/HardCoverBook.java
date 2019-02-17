public class HardCoverBook extends BookWithCover {
    public HardCoverBook(Publication p) {
        super(p);
        if(p instanceof BookWithCover) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() { return p.toString() + " (Hard Cover) |"; }
}