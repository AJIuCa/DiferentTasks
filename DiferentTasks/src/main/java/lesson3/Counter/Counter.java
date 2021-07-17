package lesson3.Counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private Lock lock = new ReentrantLock();
    private int value = 0;
    private int limit;

    public int getValue() {
        return value;
    }

    public int getLimit() {
        return limit;
    }


    public void incrementRun() throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }


    private void increment(){

        for (int i = 0; i < (limit/2); i++){  // Макс лимит делим на 2 так как будем создавать 2 потока

            lock.lock();
            value++;
            System.out.println(value);
            lock.unlock();

        }
    }


    public Counter(int limit) {
        this.limit = limit;
    }
}
