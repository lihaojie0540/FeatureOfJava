package lightweightProcess.BlockingQueue;

/**
 * 生产者Producer
 */
public class Producer extends Thread{
    private int num;
    private String names;
    private Storage storage;

    public Producer(Storage storage){
        this.storage = storage;
    }

    public void run(){
        produce(num,names);
    }

    public void produce(int num,String names){
        storage.produce(num,names);
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

    public void setNames(String names) {
        this.names = names;
    }
}
