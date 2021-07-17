package lesson3.PingPong.ThirdMethod;

public class Ping implements Runnable {

    @Override
    public void run() {

        while (true){
            System.out.println("Ping");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
