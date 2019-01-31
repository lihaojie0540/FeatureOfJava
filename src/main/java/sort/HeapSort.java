package sort;

import java.util.Arrays;

/**
 * 堆排序的平均时间复杂度为o(n log2 n),最好o(n log2 n),最坏o(n log2 n),平均空间复杂度为o(1);
 * 构建大根堆，将最大值和数组末交换，长度减一，再度构建大根堆。
 */
public class HeapSort {
    public static void main(String[] args){
        int a[] = {51,46,20,18,65,97,82,30};
        heapSort(a);
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(a));
    }

    public static void heapSort(int[] a){
        int i;
        for(i = a.length /2 -1; i >= 0; i--) {
            createMaxdHeap(a, i, a.length - 1);
        }
        for(i = a.length -1; i >= 0; i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            createMaxdHeap(a, 0, i-1);
        }
    }

    public static void createMaxdHeap(int[] a, int i, int len){
        int temp,j;
        temp = a[i];
        for(j = 2*i; j<len; j*=2){
            if(j < len && a[j] < a[j+1])
                ++j;
            if(temp>=a[j]) break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

}
