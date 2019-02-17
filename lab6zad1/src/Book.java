public class Book implements Publication {
    private String Title;
    private String Author;
    private int Pages;
    private boolean Wrapper = false;
    private boolean Cover = false;
    private boolean Sig = false;

    public Book(String A, String T, int P) {
        Author = A;
        Title = T;
        Pages = P;
    }

    @Override
    public int GetPageCount() { return Pages; }

    @Override
    public String GetAuthor() { return Author; }

    @Override
    public String GetTitle() { return Title; }

    @Override
    public boolean HasCover() { return Cover; }

    @Override
    public boolean HasWrapper() { return Wrapper; }

    @Override
    public boolean HasSignature() { return Sig; }

    @Override
    public void AddCover() { Cover = true; }

    @Override
    public void AddWrapper() { Wrapper = true; }

    @Override
    public void AddSignature() { Sig = true; }

    @Override
    public String toString() {
        return "| " + GetAuthor() + " | " + GetTitle() + " | " + GetPageCount() + " |";
    }
}
