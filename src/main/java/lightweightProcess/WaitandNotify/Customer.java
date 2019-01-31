package lightweightProcess.WaitandNotify;

/**
 * 消费者Consumer
 */
public class Customer extends Thread{
    private int num;
    private Storage storage;

    public Customer(Storage storage){
        this.storage = storage;
    }

    public void run(){
        consume(num);
    }

    public void consume(int num){
        storage.consume(num);
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

}
