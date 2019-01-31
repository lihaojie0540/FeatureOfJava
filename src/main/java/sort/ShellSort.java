package sort;

import java.util.Arrays;

/**
 * 希尔排序的平均时间复杂度为o(n~1.5),最好o(n),最坏o(n~2),平均空间复杂度为o(1);
 *
 */
public class ShellSort {
    public static void main(String[] args){
        int a[] = {51,46,20,18,65,97,82,30,7};
        shellSort(a,a.length);
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(a));
    }

    public static void shellSort(int a[],int n){
        int i,j,gap;
        for(gap = n / 2; gap > 0; gap /= 2){
            for(i = 0; i < gap; i++){
                for(j = i + gap; j < n; j += gap){
                    if(a[j] < a[j - gap]){
                        int temp = a[j];
                        int k = j - gap;
                        while(k >= 0 && a[k] > temp){
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
                }
            }
        }
    }
}
