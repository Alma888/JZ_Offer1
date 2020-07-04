package Array;
//顺时针打印矩阵（本题多想想多多思考一下）

//题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//例如：输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//      输出：         [1,2,3,6,9,8,7,4,5]

//解题思路：将结果存入数组中，先从左到右，再从上到下，再从右到左，最后从下到上遍历。
//          循环以上操作，直到所有元素都已经被存入数组。

//方法一：
/*
import java.util.Arrays;
public class PrintMatrix_29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1,x=0;
        int[] res=new int[(r+1)*(b+1)];
        while (true){
            for(int i=l;i<=r;i++){//从左到右打印
                res[x++]=matrix[t][i];
            }
            if((++t)>b){
                break;
            }
            for(int i=t;i<=b;i++){ //从上到下打印
                res[x++]=matrix[i][r];
            }
            if((--r)<l){
                break;
            }
            for(int i=r;i>=l;i--){ //从右到左打印
                res[x++]=matrix[b][i];
            }
            if((--b)<t){
                break;
            }
            for(int i=b;i>=t;i--){ //从下到上打印
                res[x++]=matrix[i][l];
            }
            if((++l)>r){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] sourse={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}
                       };
        System.out.println(Arrays.toString(new PrintMatrix_29().spiralOrder(sourse)));
    }
}
*/

//方法二：

import java.util.Arrays;

public class PrintMatrix_29 {
    public int[] spiralOrder(int[][] matrix) {
        int r1=0,r2=matrix.length-1,c1=0,c2=matrix[0].length-1,x=0;
        int[] res=new int[(r2+1)*(c2+1)];
        while (r1<=r2&&c1<=c2){
            for(int i=c1;i<=c2;i++){
                res[x++]=matrix[r1][i];
            }
            for(int i=r1+1;i<=r2;i++){
                res[x++]=matrix[i][c2];
            }
            for(int i=c2-1;i>=c1;i--){
                res[x++]=matrix[c2][i];
            }
            for(int i=r2-1;i>r1;i--){
                res[x++]=matrix[i][r1];
            }
            r1++;r2--;c1++;c2--;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] sourse={{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(Arrays.toString(new PrintMatrix_29().spiralOrder(sourse)));
    }
}
