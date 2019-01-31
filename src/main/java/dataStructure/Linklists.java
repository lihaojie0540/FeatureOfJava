package dataStructure;
/**
 * linklist的相关操作
 */
public class Linklists {
    public static void main(String[] args){
        Data data = new Data(1);
        System.out.println(data.obj);
        insertFirst(27);
        insertFirst(34);
        insertFirst(43);
        display();

    }

    private static Data first = null;

    private static class Data{
        private Object obj;
        private Data next = null;
        Data(Object obj){
            this.obj = obj;
        }
    }

    public static void clear(){
        first = null;
    }

    public static void insertFirst(Object obj){
        Data data = new Data(obj);
        data.next = first;
        first = data;
    }

    public static void display(){
        if(first==null){
            System.out.println("empty");
        }
        Data cur = first;
        while(cur!=null){
            System.out.print(cur.obj.toString()+"->");
            cur = cur.next;
        }
        System.out.println();
    }

    //逆序输出链表
    public static void ReversePrint(){
        int i = 0;
        String pr = "";
        Data cur = first;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        Object[] stack = new Object[i];
        cur = first;

    }

    //单链表排序

    //合并有序链表

    //判断链表是否为环

    //输出链表倒数第K个元素
}
