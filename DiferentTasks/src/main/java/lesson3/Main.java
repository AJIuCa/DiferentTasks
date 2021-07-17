package lesson3;

import lesson3.Counter.Counter;
import lesson3.PingPong.FirstMethod.Ping;
import lesson3.PingPong.FirstMethod.Pong;
import lesson3.PingPong.SecondMethod.PingPong;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        pingPongFirstMethod();
        pingPongSecondMethod();
//        pingPongThirdMethod();
//        threadCounter();

    }
    public static void pingPongFirstMethod() throws InterruptedException {

        while (true){

            Thread thread1 = new Thread(new Ping());
            Thread thread2 = new Thread(new Pong());

            thread1.start();
            Thread.sleep(1);
            thread2.start();

            thread1.interrupt();
            thread2.interrupt();

        }

    }

    public static void pingPongSecondMethod () throws InterruptedException {

        PingPong pingPong = new PingPong();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pingPong.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pingPong.notifyThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        Thread.sleep(3);
        thread2.start();

    }

    public static void pingPongThirdMethod() throws InterruptedException {

        Thread thread1 = new Thread(new lesson3.PingPong.ThirdMethod.Ping());
        Thread thread2 = new Thread(new lesson3.PingPong.ThirdMethod.Pong());

        thread1.start();
        Thread.sleep(3);
        thread2.start();


    }

    public static void threadCounter() throws InterruptedException {

        Counter counter = new Counter(200000);
        counter.incrementRun();

    }

}
