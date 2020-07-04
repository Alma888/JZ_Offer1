package Array;
//把数组排成最小的数
//题目描述：输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出
//          的所有数字中最小的一个。

//需定义排序规则：
//Java 定义为 (x, y) -> (x + y).compareTo(y + x)
//使用 "内置函数方法" 的平均时间复杂度为 O(NlogN) ，最差为 O(N^2)
//                         空间复杂度 O(N)
//
//在List或数组中的对象如果没有实现Comparable接口时，那么就需要调用者为需要排序的数组
//或List设置一个Compartor，Compartor的compare方法用来告诉代码应该怎么去比较两个实例，
//然后根据比较结果进行排序。

//内置函数方法一：
/*
import java.util.ArrayList;

public class PrintMinNumber_45 {
    public String minNumber(int [] s) {
        if(s==null) {
            return null;
        }
        String s1="";
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<s.length;i++){
            list.add(String.valueOf(s[i]));
        }
        list.sort((s0, s2) -> (s0 + s2).compareTo(s2 + s0));
        for(String j:list){
            s1+=j;
        }
        return s1.toString();
    }

    public static void main(String[] args) {
        int[] arr={3,32,321};
        System.out.println(new PrintMinNumber_45()minNumber(arr));
    }
}
*/

import java.util.Arrays;

//内置函数方法二：
public class PrintMinNumber_45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        int[] arr={3,32,321};
        System.out.println(new PrintMinNumber_45().minNumber(arr));
    }
}
