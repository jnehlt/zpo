public class BookDecorator implements Publication {
    protected Publication p;
    public BookDecorator(Publication p) { this.p = p; }

    @Override
    public String toString() { return super.toString(); }

    @Override
    public int GetPageCount() { return p.GetPageCount(); }

    @Override
    public String GetAuthor() { return p.GetAuthor(); }

    @Override
    public String GetTitle() { return p.GetTitle(); }

    @Override
    public boolean HasCover() { return p.HasCover(); }

    @Override
    public void AddCover() { p.AddCover(); }

    @Override
    public boolean HasWrapper() { return p.HasWrapper(); }

    @Override
    public void AddWrapper() { p.AddWrapper(); }

    @Override
    public boolean HasSignature() { return p.HasSignature(); }

    @Override
    public void AddSignature() { p.AddSignature(); }
}