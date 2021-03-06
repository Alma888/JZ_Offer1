package Array;
//二维数组的查找——>题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，
// 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的个二维数组和一个整数，
// 判断数组中是否含有该整数。
//Eg:下面的二维数组就是每行、每列都递增排序。如果在这个数组中查找数字7，则返回true;
//   如果查找数字5,由于数组不含有该数字，则返回false.
//                {1,2,8,9},
//                {2,4,9,12},
//                {4,7,10,13},
//                {6,8,11,15}
//        givenValue=7,return true.
//        givenValue=0,return false.
/* 解题思路：
 *选择给出的二维数组的右上角或左下角的数进行比较过程。
 *如果选中的数和要查找的值相等，就返回true。
 *
 *如果选中的数比要查找的值大，就排除选中数的所在列，对选中数
 *的左侧所有列的数进行比较查找。
 *
 *如果选中的数比要查找的值小，就排除选中数的所在行，对选中数
 *的下侧所有行的数进行比较查找。
 *循环上述操作，直到找到该值为止，若循环完都没找到就返回false。
 */
public class Find_04 {

/*
    //方式一：每次选择右上角的数字进行比较查找过程
    public  boolean Find1(int[][] arr,int value){
        boolean found=false;  //设置标志位

        if(arr!=null&&arr.length!=0&&arr[0].length!=0){ //先判断数组所给是否为空
            int rows=arr.length; //获取行数
            int row=0;//行下标
            int column=arr[0].length-1;//列下标
            //每次将查找区域的右上角的数与所查找的数字进行比较
            while (row<rows&&column>=0){
                if(arr[row][column]==value){
                    found=true;
                    break;
                }else if(arr[row][column]<value){
                    row++;
                }else {
                    column--;
                }
            }
        }
        return found;
    }
*/

    //方式二：每次选择左下角的数字进行比较查找过程
public boolean Find1(int[][] arr,int value){
    boolean found=false;
    if(arr!=null&&arr.length!=0&&arr[0].length!=0){
        int rows=arr.length;//行数
        int columns=arr[0].length;//列数
        int row=rows-1;//行下标
        int column=0;//列下标
        while (row>0&&column<columns){
            if(arr[row][column]==value){
                found=true;
                break;
            }else if(arr[row][column]<value){
                column++;
            }else {
                row--;
            }
        }
    }
    return found;
}
    public static void main(String[] args) {
        int[][] a={{1,2,8,9},
                   {2,4,9,12},
                   {4,7,10,13},
                   {6,8,11,15}};
        System.out.println(new Find_04().Find1(a,8));
    }
}
