public interface Publication {
    int GetPageCount();
    String GetAuthor();
    String GetTitle();
    boolean HasCover();
    boolean HasWrapper();
    boolean HasSignature();
    void AddCover();
    void AddWrapper();
    void AddSignature();
}
