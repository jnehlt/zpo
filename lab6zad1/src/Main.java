public class Main {
    public static void main(String[] args) {
        Publisher _k1 = Publisher.GetInstance("Koszmider");
        Publication k1 = _k1.CreateBook("Jak zaprogramować nic", 1);
//        Publication kk1 = new HardCoverBook(k1);
        Publication kk1 = new SoftCoverBook(k1);
        Publication kkk1 = new SignedBook(kk1, "Nie ma za co");

        System.out.println(kkk1);


    }
}
