import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;

class Cyclist extends TimerTask implements Comparable<Cyclist>{
    String name;
    Long startTime;
    Long time;

    public Cyclist(String name){
        this.name = name;
        time = randomTime();
    }

    @Override
    public void run() {
        Date date = new Date();
        startTime = date.getTime();
        Main.logger.info(new SimpleDateFormat("H:m:s:S").format(date) + ": " + name + " wystartował!");
    }

    private long randomTime(){
        int AVERAGE = 300;
        int VARIANCE = 40;
        int MIN = 270;
        int MAX = 370;

        long time = (long)(Main.random.nextGaussian() * VARIANCE + AVERAGE);

        if(time < MIN)
            time = MIN;
        if(time > MAX)
            time = MAX;

        System.out.println(time);
        return time;
    }

    @Override
    public int compareTo(Cyclist c) {
        return this.time.compareTo(c.time);
    }
}

public class Main {
    static final int CYCLIST_QUANTITY = 15;
    static final double SECOND = 0.04; //0.04
    static final Random random = new Random();
    static final Logger logger = Logger.getLogger("MyLog");
    static final JFrame jFrame = new JFrame();
    static final JTextArea jTextArea = new JTextArea();

    static ArrayList<String> getNameList(String address) throws IOException{
        URL url = new URL(address);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));

        ArrayList<String> nameList = new ArrayList<>();
        String line;
        while((line = bufferedReader.readLine()) != null){
            nameList.add(line);
        }

        return nameList;
    }

    public static void main(String[] args) throws IOException{
        FileHandler fileHandler = new FileHandler("log.log", true);
        logger.addHandler(fileHandler);
        jFrame.setVisible(true);
        jFrame.setBounds(50, 50, 1000, 300);
        jFrame.add(jTextArea);

        ArrayList<String> nameList = getNameList("http://szgrabowski.kis.p.lodz.pl/zpo18/nazwiska.txt");

        Timer timer = new Timer();
        ArrayList<Cyclist> cyclistList = new ArrayList<>();
        PriorityQueue<Cyclist> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < CYCLIST_QUANTITY; i++){
            int tempRandom = random.nextInt(nameList.size());
            Cyclist tempCyclist = new Cyclist(nameList.get(tempRandom));

            timer.schedule(tempCyclist, (int)(i * 1000 * 60 * SECOND));

            cyclistList.add(tempCyclist);
            nameList.remove(tempRandom);
        }

        while(true){
            Date date = new Date();
            for(Cyclist c : cyclistList){
                if(c.startTime != null && c.startTime + c.time * SECOND * 1000 < date.getTime()){

                    priorityQueue.add(c);
                    PriorityQueue<Cyclist> priorityQueue2 = new PriorityQueue(priorityQueue);

                    int i = 0;
                    int lastTime = 0;
                    String rank = new String("\n==========RANK==========");

                    while(priorityQueue2.size() > 0 && i < 3){
                        Cyclist cp = priorityQueue2.poll();
                        if(lastTime == cp.time.intValue()){
                            rank += ", " + cp.name;
                        }else if(i < 3){
                            rank += "\n" + cp.time + "\t" + cp.name;
                            i++;
                        }

                        lastTime = cp.time.intValue();
                    }

                    String message = new String(new SimpleDateFormat("H:m:s:S").format(date) + ": " + c.name + " zakończył wyścig z czasem: " + c.time);
                    logger.info(message);

                    rank += "\n==========RANK==========\n";
                    System.out.println(rank);
                    jTextArea.setText(message + rank);

                    cyclistList.remove(c);
                    break;
                }
            }
        }
    }
}
