package lightweightProcess.BlockingQueue;


import java.util.concurrent.LinkedBlockingQueue;

/**
 * 仓库类实现缓冲区
 */
public class Storage {
    //仓库容量
    private final int MAX_SIZE =100;
    //仓储的载体
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>();
    public void produce(int num, String names){
        //
        if(list.size() == MAX_SIZE){
            System.out.println("满了,库存:"+list.size()+names+"要生产："+num);
        }else{
            System.out.println(names+"要生产："+num);
        }
        //
        for(int i = 1; i <= num; ++i){
            try{
                list.put(new Object());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(names+"生产了第"+i+"个,库存："+list.size());
        }
    }

    public void consume(int num, String names){
        //
        if(list.size()==0){
            System.out.println("空了，库存:" + list.size()+names+"要消费："+num);
        }else{
            System.out.println(names+"要消费："+num);
        }
        for(int i = 1; i <=num; ++i) {
            try {
                list.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(names+"消费了第"+i+"个,库存："+list.size());
        }
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public LinkedBlockingQueue<Object> getList() {
        return list;
    }

    public void setList(LinkedBlockingQueue<Object> list) {
        this.list = list;
    }
}
