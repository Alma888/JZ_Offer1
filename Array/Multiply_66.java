package Array;

import java.util.Arrays;

//构建乘积数组——>题目描述：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
//       B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

//解题思路：（本题可通过实际例子去实践找规律得出以下矩阵）
//B[i]的值可以看作下图的矩阵中每行的乘积。
//下三角用连乘可以很容求得，上三角，从下向上也是连乘。
//因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按
//上三角中的分布规律，把另一部分也乘进去。
// B[0]:       1    A[1]   A[2]   ...   A[n-2]    A[n-1]
// B[1]:     A[0]    1     A[2]   ...   A[n-2]    A[n-1]
// B[2]:     A[0]   A[1]    1     ...   A[n-2]    A[n-1]
// ... :     A[0]   A[1]   ...     1    A[n-2]    A[n-1]
// B[n-2]:   A[0]   A[1]   ...  A[n-3]    1       A[n-1]
// B[n-1]:   A[0]   A[1]   ...  A[n-3]  A[n-2]     1

public class Multiply_66 {
    public int[] constructArr(int[] a) {
        int len=a.length;
        int[] b=new int[len];
        if(len!=0){
            b[0]=1;
            //先计算下三角
            for(int i=1;i<len;i++){
                b[i]=b[i-1]*a[i-1];
            }
            //后计算上三角
            int temp=1;
            for(int j=len-2;j>=0;j--){
                temp*=a[j+1];
                b[j]*=temp;
            }
        }
        return b;
    }
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        Multiply_66 mul=new Multiply_66();
        System.out.println(Arrays.toString(mul.constructArr(a)));
}
}
