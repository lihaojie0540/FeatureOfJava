package sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 桶排序平均时间复杂度o(d(r+n)),最好情况o(d(n+rd)),最差情况o(d(r+n)),空间复杂度o(rd+n).
 * 求步数,建桶,放数据,桶内排序,从桶中取出数据
 */
public class BucketSort {
    public static void main(String[] args){
        int a[] = {51,46,20,18,65,97,82,30};
        asc(a);
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(a));
    }

    public static int[] asc(int a[]){
        int min = a[0];
        int max = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i] > max) max = a[i];
            if(a[i] < min) min = a[i];
        }
        int step = (max - min + 1) / 10;
        if(step < 1) step++;
        return bucketSort(a,min,max,step);
    }

    public static int[] bucketSort(int a[],int min,int max,int step){
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        int num = (max - min + 1) / step;
        if (num < 1) num ++;
        //建桶
        for(int i = min; i <= max; i = i + step){
            List<Integer> bucket = new LinkedList<Integer>();
            list.add(bucket);
        }
        //将数据放入桶
        for(int i = 0; i < a.length; i ++){
            int index = (a[i] - min) / step;
            list.get(index).add(a[i]);
        }
        //对桶内数据进行排序
        for(int i = 0; i < list.size(); i++){
            list.set(i,insertSort(list.get(i)));
        }
        //桶数据放回数组
        int k = 0;
        for(int i = 0; i < list.size(); i++){
            List<Integer> temp = list.get(i);
            for(int j = 0; j < temp.size(); j++){
                a[k] = (int)temp.get(j);
                k++;
            }
        }
        return a;
    }

    public static List<Integer> insertSort(List<Integer> list){
        int i,j,insertNote;
        for(i = 1 ; i < list.size(); i++){
            insertNote = list.get(i);
            j = i-1;
            while ( j >= 0 && insertNote < list.get(j)){
                list.set(j+1,list.get(j));
                j--;
            }
            list.set(j+1,insertNote);
        }
        return list;
    }
}
