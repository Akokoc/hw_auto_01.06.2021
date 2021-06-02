import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game implements Runnable {
    int loopNumber;
    Auto auto;

    public Game(int loopNumber, Auto auto) {
        this.loopNumber = loopNumber;
        this.auto = auto;
    }

    @Override
    public void run() {
        ArrayList<Integer> time = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < loopNumber; i++) {
            long start = System.currentTimeMillis();
            int randomPitStop = 0;
            if (i % 2 == 0) {
                int pit1 = auto.getMinPitStopTime();
                int pit2 = auto.getMaxPitStopTime();

                randomPitStop = pit1 + (int) (Math.random() * pit2);
                try {
                    Thread.sleep(randomPitStop);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int loop1 = auto.getMinLoopTime();
            int loop2 = auto.getMaxLoopTime();
            int randomLoop = loop1 + (int) (Math.random() * loop2);
            try {
                Thread.sleep(randomLoop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time.add(randomLoop);

            sum += randomPitStop + randomLoop;//общее время гонки


            System.out.println("Auto: " + auto.getName() + ", loop nr: " + i + ", loop time: " + randomLoop);
            System.out.println("Auto: " + auto.getName() + ", loop nr: " + i + ", pit-stop time: " + randomPitStop);
//            System.out.println("Auto: " + auto.getName() + ", loops: " + loopNumber + ", times: " + time);

        }
        System.out.println("Auto: " + auto.getName() + ", loops: " + loopNumber + ", times: " + time);
        System.out.println("Auto: " + auto.getName() + ", Total time:" + sum);

    }
}
