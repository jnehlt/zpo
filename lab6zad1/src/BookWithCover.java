public abstract class BookWithCover extends BookDecorator {
    public BookWithCover(Publication p) {
        super(p);
        if(p.HasCover()) {
            throw new IllegalArgumentException();
        }
        p.AddCover();
    }
}