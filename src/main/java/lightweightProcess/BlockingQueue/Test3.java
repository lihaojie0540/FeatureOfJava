package lightweightProcess.BlockingQueue;

import java.util.Random;

/**
 * 生产者消费者是研究多线程问题的一个经典问题，描述的是有一块缓冲区作为仓库
 * 生产者可以将产品放入仓库，消费者可以将产品从仓库取走
 * 如何保证生产者不会在仓库满的时候将产品放入仓库，消费者不会在仓库空的时候去仓库取货？
 */
public class Test3 {
    public static void main(String [] args){
        Storage storage = new Storage();
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);
        Producer p4 = new Producer(storage);
        Producer p5 = new Producer(storage);
        Random random = new Random();
        p1.setNum(random.nextInt(100));
        p1.setNames("p1");
        p2.setNum(random.nextInt(100));
        p2.setNames("p2");
        p3.setNum(random.nextInt(100));
        p3.setNames("p3");
        p4.setNum(random.nextInt(100));
        p4.setNames("p4");
        p5.setNum(random.nextInt(100));
        p5.setNames("p5");

        Customer c1 = new Customer(storage);
        Customer c2 = new Customer(storage);
        Customer c3 = new Customer(storage);
        Customer c4 = new Customer(storage);
        c1.setNum(random.nextInt(100));
        c1.setNames("c1");
        c2.setNum(random.nextInt(100));
        c2.setNames("c2");
        c3.setNum(random.nextInt(100));
        c3.setNames("c3");
        c4.setNum(random.nextInt(100));
        c4.setNames("c4");
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

    }
}
