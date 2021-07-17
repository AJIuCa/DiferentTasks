package lesson3.PingPong.SecondMethod;

public class PingPong {

    public void start() throws InterruptedException {
        synchronized (this) {
            while (true) {
                Thread.sleep(500);
                System.out.println("Ping");
                wait();
                System.out.println("Pong!");
                notify();
            }
        }
    }
    public void notifyThread() throws InterruptedException {
        synchronized (this) {
            while (true) {
                Thread.sleep(500);
                notify();
                wait();
            }
        }
    }
}
