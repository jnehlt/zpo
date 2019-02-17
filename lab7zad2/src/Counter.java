public class Counter implements Runnable {

    private Long start;
    private Long end;
    private Long result;

    private Counter(){}
    public Counter(Long start, Long end) {
        this.start = start;
        this.end = end;
        result = 0L;
    }

    @Override
    public void run() {
        Long temp = start;
        while(temp <= end) {
            if(calcPrime(temp++)) {
                result++;
            }
        }
    }

    private boolean calcPrime(Long number) {
        if(number <= 1) { return false; }
        if(number <= 3) { return true; }
        if(number % 2 == 0) { return false; }
        double sq_n = Math.floor(Math.sqrt(Double.valueOf(number)));
        for(int i = 3; i <= sq_n; i += 2) {
            if(number % i == 0) { return false; }
        }
        return true;
    }

    public Long getResult() { return result; }
}
