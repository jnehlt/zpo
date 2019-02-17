public class SoftCoverBook extends BookWithCover {
    public SoftCoverBook(Publication p) {
        super(p);
        if(p instanceof BookWithCover) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() { return p.toString() + " (Soft Cover) | "; }
}