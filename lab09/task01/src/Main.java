public class Main {
    private static String[] strings = {"aaaa", "bb", "ccccccccccccc", "dddddd"};

//    public static void main(String[] args) throws InterruptedException {
//        Thread[] threads = new Thread[4];
//        int[] iterators = new int[4];
//        String siema = "xdasda";
//
//        while(true){
//            for(int i = 0; i < 4; i++){
//                int finalI = i;
//                if(strings[i].length() != iterators[i]) {
//                    threads[i] = new Thread(() -> {
//                        System.out.print(strings[finalI].charAt(iterators[finalI]));
//                        iterators[finalI]++;
//                    });
//                    threads[i].start();
//                    threads[i].join();
//                }
//            }
//            System.out.print(" ");
//
//            if(strings[0].length() == iterators[0] &&
//                    strings[1].length() == iterators[1] &&
//                    strings[2].length() == iterators[2] &&
//                    strings[3].length() == iterators[3]){
//                break;
//            }
//        }
//    }
    public static void main(String[] args) {
        for(int i = 0; i < strings.length; i++){
            new Threads(strings[i]);
        }

        Threads.ready = true;
    }
}
