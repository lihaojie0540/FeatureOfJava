package lightweightProcess.WaitandNotify;

import java.util.LinkedList;

/**
 * 仓库类实现缓冲区
 */
public class Storage {
    //仓库容量
    private final int MAX_SIZE =100;
    //仓储的载体
    private LinkedList<Object> list = new LinkedList<Object>();

    public void produce(int num){
        //同步代码段
        synchronized (list){
            //仓库
            while(list.size() + num > MAX_SIZE){
                System.out.println("库存:"+list.size()+"已经生产："+num+"库存满了");
                try{
                    list.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            //
            for(int i = 0; i < num; i ++){
                list.add(new Object());
            }
            System.out.println("已经生产："+num+" 库存："+list.size());
            list.notifyAll();
        }
    }

    public void consume(int num){
        //
        synchronized (list){
            //
            while(list.size() < num) {
                System.out.println("库存:"+list.size()+"要消费："+num+"库存不足");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //
            for (int i = 0; i < num; i++){
                list.remove();
            }
            System.out.println("消费了："+num+"库存："+list.size());
            list.notifyAll();
        }
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
