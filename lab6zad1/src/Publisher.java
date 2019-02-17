public abstract class Publisher {
    protected String Author;

    public Publisher(String Author) {
        this.Author = Author;
    }

    static Publisher GetInstance(String Author) {
        switch(Author) {
            case "Koszmider":
            case "Adam Mickiewicz":
                return new PoemPublisher(Author);
            case "Pies który jeździł koleją":
                return new ThrillerPublisher(Author);
            case "Ed Gain":
            case "Adolf Hitler":
                return new HistoryPublisher(Author);
        }
        throw new IllegalArgumentException();
    }

    public String GerAuthor() { return Author; }

    public Book CreateBook(String Title, int Pages) {
        return new Book(GerAuthor(), Title, Pages);
    }
}
