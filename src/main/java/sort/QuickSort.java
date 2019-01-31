package sort;

import java.util.Arrays;

/**
 * 快速排序的平均时间复杂度：o(n log2 n),最好时间复杂度：o(n log2 n),
 * 最差时间复杂度：o(n~2),空间复杂度：o(n log2 n)
 */
public class QuickSort {
    public static void main(String[] args){
        QuickSort quickSort = new QuickSort();
        int a[] = {38,65,64,76,13,27,49,4};
        quickSort.quickSort(a);
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(a));
    }

    public void quickSort(int[] arrays){
        subQuickSort(arrays,0,arrays.length-1);
    }

    public void subQuickSort(int[] arrays, int left, int right){
        if(left >= right) return;
        int middleIndex = subQuickSortCore(arrays,left,right);
        subQuickSort(arrays,left,middleIndex-1);
        subQuickSort(arrays,middleIndex+1,right);
    }

    public int subQuickSortCore(int[] arrays,int left,int right){
        int middleValue = arrays[left];
        while(left<right){
            while (arrays[right]>=middleValue && left < right){
                right--;
            }
            arrays[left]=arrays[right];
            while (arrays[left]<=middleValue && left < right){
                left++;
            }
            arrays[right]=arrays[left];
        }
        arrays[left] = middleValue;
        return left;
    }
}
