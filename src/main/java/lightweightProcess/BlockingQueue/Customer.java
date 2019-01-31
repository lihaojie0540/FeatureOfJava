package lightweightProcess.BlockingQueue;

/**
 * 消费者Consumer
 */
public class Customer extends Thread{
    private int num;
    private String names;
    private Storage storage;

    public Customer(Storage storage){
        this.storage = storage;
    }

    public void run(){
        consume(num,names);
    }

    public void consume(int num,String mames){
        storage.consume(num,names);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String name) {
        this.names = name;
    }
}
