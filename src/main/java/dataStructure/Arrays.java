package dataStructure;


import static java.lang.Math.max;

/**
 * Array的相关操作
 */
public class Arrays {
    public static void main(String[] args){
        int a[] = {1,3,5,7,9,10,13,15,17,19,21};
        System.out.println(binSerach(a,15));
    }

    //求输出数组的最大的K个值
    public static void topK(int a[],int k){
        int temp[] = new int[k];
        int i,j,x;
        for (int ax: temp) ax = 0;
        for(i = 0; i < k; i++) temp[i] = a[i];
        //取出k个值，插入排序
        for(i = 1; i < temp.length; i++){
            x = temp[i];
            j = i-1;
            while(j >= 0 && x > temp[j]){
                temp[j+1] = temp[j];
                j--;
            }
            temp[j+1] = x;
        }
        //对后面每取一个值，在temp数组找到对应位置，插进去，溢出一个树。
        for(i = k; i < a.length; i++){
            for(j = 0; j < temp.length; j++){
                int w = 0;
                int e = 0;
                if(a[i] > temp[j]){
                    w = temp[j];
                    temp [j] = a[i];
                    while( ((j+1) < temp.length) && w > temp[j+1] ){
                        e = temp[j+1];
                        temp[j+1] = w;
                        w = e;
                        j++;
                    }
                    break;
                }
            }
        }
        System.out.println(java.util.Arrays.toString(temp));
    }

    //求数组的子数组之和的最大值
    public static int maxOfSubArray(int array[],int num){
        int nstart = array[num-1];
        int nall = array[num-1];
        for(int i = num - 2; i >= 0; i--){
            nstart = max(array[i],nstart+array[i]);
            nall = max(nstart,nall);
        }
        return nall;
    }

    //基于数组的二分查找法
    public static int binSerach(int a[],int n){
        int low = 0;
        int high = a.length-1;
        int mid;
        while (low <= high){
            mid = (low+high)/2;
            if(a[mid] == n){
                return mid+1;
            }
            else if(a[mid] < n){
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }

}
