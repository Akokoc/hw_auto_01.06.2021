public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread th1 = new Thread((Runnable) new Game(2,new Auto("mercedes_1",2000,5000,100,300)));
        Thread th2 = new Thread((Runnable) new Game(2, new Auto("audi_2",1000,3000,50,200)));
//        Thread th3 = new Thread((Runnable) new Game(2, new Auto("VW_3",100,300,5,20)));


        th1.start();
        th2.start();
//        th3.start();



    }
}
