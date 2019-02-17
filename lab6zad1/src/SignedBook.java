public class SignedBook extends BookDecorator {
    private String Signature;
    public SignedBook(Publication p, String s) {
        super(p);
        if(p.HasSignature()) {
            throw new IllegalArgumentException();
        }
        p.AddSignature();
        Signature = s;
    }

    @Override
    public String toString() { return p.toString() + "\"" + Signature + "\" |"; }
}