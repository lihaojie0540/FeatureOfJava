package sort;

import java.util.Arrays;

/**
 * 选择排序的平均时间复杂度为o(n~2),最好o(n~2),最坏o(n~2),平均空间复杂度为o(1);
 * 选出最小的，和数组第一个交换，以此类推。
 */
public class SelectSort {
    public static void main(String[] args){
        int a[] = {51,46,6,23,20,18,65,97,82,30,7};
        selectSort(a,a.length);
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(a));
    }

    public static void selectSort(int a[],int n){
        int i,j,min;
        for(i = 0; i < n; i++){
            min = i;
            for(j = i + 1; j < n; j++){
                if(a[j]<a[min])
                    min = j;
            }
            int tmp;
            tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }
}
