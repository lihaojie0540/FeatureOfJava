package dataStructure;
/**
 * String
 */
public class Strings {
    public static void main(String[] args){
        String str1 = "ffqeceeceqdfwasdsarr";
        String str2 = "gwgrecedcwasds";
        System.out.println(longestPalindrome(str1));

    }

    //7 最长公共子串 动态规划
    public static void longestCommonSubstring(String str1,String str2){
        int i,j,k,max,start,end;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int temp[][] = new int[arr1.length][arr2.length];
        max = 0;
        start = 0;
        end = 0;
        //初始化二维数组的第一行
        for(i = 0; i < arr2.length; i++ )
            temp[0][i] = (arr1[0] == arr2[i]) ? 1 : 0;
        //初始化二维数组的第一列
        for(j = 0; j< arr1.length; j++)
            temp[j][0] = (arr2[0] == arr1[j]) ? 1 : 0;
        //对每一个相等的位置，根据它的左上对角线为其赋值
        for(i = 1; i < arr1.length; i++){
            for(j = 1; j < arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    temp[i][j] = temp[i-1][j-1] + 1;
                    if(temp[i][j] > max){
                        max = temp[i][j];
                        end = j;
                    }
                }else
                    temp[i][j] = 0;
            }
        }
        start = end - max + 1;
        StringBuffer stringBuffer = new StringBuffer();
        for(j = start; j < end + 1; j++ )
            stringBuffer.append(arr2[j]);
        System.out.println(stringBuffer);
    }

    //最长回文子串 动态规划
    public static String longestPalindrome(String s){
        if(s == null) return null;
        if(s.length() <= 1) return s;
        int max = 0;
        String longestStr = null;
        int temp[][] = new int [s.length()][s.length()];
        //每一个单字符字串都是回文子串
        for(int i = 0; i < s.length(); i++)
            temp[i][i] = 1;
        //对对称中心为两个字符的回文子串赋值
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                temp[i][i+1] = 1;
                longestStr = s.substring(i, i+2);
                max = 2;
            }
        }
        System.out.println(longestStr);
        for(int len = 3; len <= s.length(); len++){
            for(int i = 0; i < s.length() - len + 1; i++){
                int j = i + len -1;
                if(s.charAt(i) == s.charAt(j)){
                    temp[i][j] = temp[i+1][j-1];
                    if(temp[i][j] == 1 && len > max)
                        longestStr = s.substring(i, j+1);
                }else
                    temp[i][j] = 0;
            }
        }
        return longestStr;
    }

    //左旋字符串
    public static String leftRotateString(String s,int k){
        return null;
    }
}

