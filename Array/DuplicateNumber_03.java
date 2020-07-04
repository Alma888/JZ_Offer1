package Array;
//数组中重复的数字——>题目描述：在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1
// 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了
// 几次。请找出数组中任意一个重复的数字。

//解题思路：
//初始化集合为空集合，重复的数字 repeat = -1
//遍历数组中的每个元素：
//将该元素加入集合中，判断是否添加成功
//如果添加失败，说明该元素已经在集合中，因此该元素是重复元素，将该元素的值赋给 repeat，并结束遍历
//返回 repeat即可

//时间复杂度：O(n)
//空间复杂度：O(n)
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumber_03 {
    public int duplicate(int[] nums){
        int repeat=-1;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                repeat=num;
                break;
            }
        }
        return repeat;
    }

    public static void main(String[] args) {
        int[] arr={2,3,1,0,2,5,3};
        System.out.println(new DuplicateNumber_03().duplicate(arr));
    }
}

