package sort;

import java.util.Arrays;

/**
 *插入排序的平均时间复杂度o(n~2),最好情况o(n),最差情况o(n~2),空间复杂度o(1).
 *从数组第二个开始选，所有比它大的都往后挪一下，直到遇见比他小的，插入它
 */
public class InsertSort {
    public static void main(String[] args){
        int a[] = {38,65,64,76,13,27,49,4};
        insertSort(a);
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(a));
    }
    public static void insertSort(int[] a){
        int i,j,insertNote;
        for(i = 1 ; i < a.length; i++){
            insertNote = a[i];
            j = i-1;
            while ( j >= 0 && insertNote < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = insertNote;
            System.out.println(Arrays.toString(a));
        }
    }
}
