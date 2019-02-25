public class Pair {
    Long a;
    Long b;

    public Pair(Long a, Long b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString(){
        return a + ", " + b;
    }
}
