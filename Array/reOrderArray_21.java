package Array;
//调整数组顺序使奇数位于偶数前面——>题目描述：输入一个整数数组，实现一个函数来调整
// 该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
//

//方法一：简单粗暴，申请一个临时数组   时间O(n) 空间O(n)
//
//    public int[] exchange(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return nums;
//        int left = 0;
//        int right = nums.length - 1;
//        int temp[] = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if ((nums[i] & 1) == 0) {//偶数
//                temp[right--] = nums[i];
//            } else {//奇数
//                temp[left++] = nums[i];
//            }
//        }
//        return temp;
//    }
//

//方法二：双指针实现                时间O(n) 空间O(1)
// 解题思路：
//使用两个指针 i和j。i从左边开始扫描，如果是奇数就往右走，如果遇到偶数就停下来
// （此时i指向的是偶数），j从右边开始扫描，如果是偶数就往左走，如果是奇数就停下来
// （此时j指向的是奇数），交换i和j指向的值。继续循环，直到i==j为止。

import java.util.Arrays;

public class reOrderArray_21 {

    public int[] exchange(int[] nums) {
        if(nums==null||nums.length==0){ //先判断数组是否合格
            return nums;
        }
        int i=0;
        int j=nums.length-1;
        while (i<j){                    //循环语句
            while ((i<j)&&nums[i]%2!=0){ //再次判断保证i++后 i<j
                i++;
            }
            while ((i<j)&&nums[j]%2==0){//再次判断保证j++后 i<j
                j--;
            }
            swap(nums,i,j);
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(Arrays.toString(new reOrderArray_21().exchange(arr)));
    }
}

//方法三：快慢指针实现           时间O(n) 空间O(1)
//解题思路：第三种方式使用的是快慢指针，和上一种解决方式有一点区别，上一种是一前一后
// 扫描。我们这里使用的快慢指针都是从头开始扫描。
// 我们使用两个指针，一个快指针fast，一个慢指针slow。
// 慢指针slow存放下一个奇数应该存放的位置，快指针fast往前搜索奇数，搜索到之后然后就
// 和slow指向的值交换。

// public int[] exchange(int[] nums) {
//        int slow = 0, fast = 0;
//        while (fast < nums.length) {
//            if ((nums[fast] & 1) == 1) {//奇数
//                if (slow != fast) {
//                    nums[slow] ^= nums[fast];
//                    nums[fast] ^= nums[slow];
//                    nums[slow] ^= nums[fast];
//                }
//                slow++;
//            }
//            fast++;
//        }
//        return nums;
//    }

