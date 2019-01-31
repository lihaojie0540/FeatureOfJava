package lightweightProcess.AwaitandSignal;

import java.util.Random;

/**
 * Created by amarsoft on 17-6-10.
 */
public class Test2 {
    public static void main(String [] args){
        Storage storage = new Storage();
        Random random = new Random();
        Producer a1 = new Producer(storage);
        Producer a2 = new Producer(storage);
        Producer a3 = new Producer(storage);
        Producer a4 = new Producer(storage);
        Producer a5 = new Producer(storage);
        Customer c1 = new Customer(storage);
        Customer c2 = new Customer(storage);
        Customer c3 = new Customer(storage);
        Customer c4 = new Customer(storage);
        Customer c5 = new Customer(storage);
        c1.setNum(random.nextInt(100));
        c2.setNum(random.nextInt(100));
        c3.setNum(random.nextInt(100));
        c4.setNum(random.nextInt(100));
        c5.setNum(random.nextInt(100));
        a1.setNum(random.nextInt(100));
        a2.setNum(random.nextInt(100));
        a3.setNum(random.nextInt(100));
        a4.setNum(random.nextInt(100));
        a5.setNum(random.nextInt(100));
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
}
