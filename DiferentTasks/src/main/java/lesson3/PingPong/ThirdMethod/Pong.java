package lesson3.PingPong.ThirdMethod;

public class Pong implements Runnable{

    @Override
    public void run() {

        while (true){
            System.out.println("Pong!");
            try {
                Thread.sleep(2002);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
