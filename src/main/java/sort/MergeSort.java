package sort;

import java.util.Arrays;

/**
 * 并归排序平均时间复杂度o(n log2 n),最好情况o(n log2 n),最差情况o(n~2),空间复杂度o(1).
 * 将数组分成两端，每段分别递归，然后合并数组。
 */
public class MergeSort {
    public static void main(String[] args){
        int a[] = {51,46,20,18,65,97,82,30,7,5856};
        int temp[] = new int[a.length];
        mergeSort(a,0,a.length-1,temp);
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(a));
    }

    public static void mergeArray(int a[],int first,int mid,int last,int temp[]){
        int i = first;
        int j = mid + 1;
        int m = mid;
        int n = last;
        int k = 0;
        while(i <= m && j <= n){
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while(i <= m){
            temp[k++] = a[i++];
        }
        while(j <= n){
            temp[k++] = a[j++];
        }
        for(i = 0; i < k; i++) a[first+i] = temp[i];
    }

    public static void mergeSort(int a[], int first , int last, int temp[]){
        if(first < last){
            int mid = (first + last) / 2;
            mergeSort(a,first,mid,temp);
            mergeSort(a,mid+1,last,temp);
            mergeArray(a,first,mid,last,temp);
        }
    }
}
