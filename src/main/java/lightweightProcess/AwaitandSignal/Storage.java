package lightweightProcess.AwaitandSignal;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by amarsoft on 17-6-10.
 */
public class Storage {
    //仓库容量
    private final int MAX_SIZE =100;
    //仓储的载体
    private LinkedList<Object> list = new LinkedList<Object>();
    //锁
    private final Lock lock = new ReentrantLock();

    private final Condition full = lock.newCondition();

    private final Condition empty = lock.newCondition();
    public void produce(int num){
        //同步代码段
        lock.lock();
        //仓库
        while(list.size() + num > MAX_SIZE){
            System.out.println("库存:"+list.size()+" 已经生产："+num+"库存满了");
            try{
                full.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //
        for(int i = 0; i < num; i ++){
            list.add(new Object());
        }
        System.out.println("已经生产："+num+" 库存："+list.size());
        full.signalAll();
        empty.signalAll();
        lock.unlock();
    }

    public void consume(int num){
        //
        lock.lock();
        while(list.size() < num) {
            System.out.println("库存:"+list.size()+" 要消费："+num+"库存不足");
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //
        for (int i = 0; i < num; i++){
            list.remove();
        }
        System.out.println("消费了："+num+" 库存："+list.size());
        empty.signalAll();
        full.signalAll();
        lock.unlock();
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

}
