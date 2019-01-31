package sort;

import java.util.Arrays;

/**
 * 冒泡排序的平均时间复杂度为o(n~2),最好o(n),最坏o(n~2),平均空间复杂度为o(1);
 * 外部循环一遍,内部循环一边,小于外部1,交换.
 */
public class BubbleSort {
    public static void main(String[] args){
        int a[] = {51,46,20,18,65,97,82,30};
        bubbleSort(a);
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int a[]){
        for(int i = 0; i < a.length - 1; i++){
            for(int j = 0; j < a.length - i - 1; j++){
                if(a[j] < a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println("第" + (i+1) + "次的排序结果");
            System.out.println(Arrays.toString(a));
        }
        System.out.println("最后一次的排序结果");
        System.out.println(Arrays.toString(a));
    }
}
