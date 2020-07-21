# JZ_Offer1

//题目描述：给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素

//             a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//注意：答案中不可以包含重复的三元组。

//示例：
//给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
package Array;

//三数之和——排序+双指针

//解题思路：
    // 1、特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
    // 2、对数组进行排序。
    // 3、遍历排序后数组：
    //    若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
    //    对于重复元素：跳过，避免出现重复解
    //    令左指针 j=i+1，右指针 k=n-1，当 j<k 时，执行循环：
    //       (1) 当 nums[i]+nums[j]+nums[k]==0，执行循环，判断左界和右界是否和下一位置重复，
    //           去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
    //       (2) 若和大于 0，说明 nums[k] 太大，k 左移
    //       (3) 若和小于 0，说明 nums[j] 太小，j 右移
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    //复杂度分析
    //时间复杂度：O(n^2)，数组排序 O(NlogN)，遍历数组 O(n)，双指针遍历 O(n)，
    //            总体 O(n)∗O(n)，O(n^2)
    //空间复杂度：O(1)

    public List<List<Integer>> threeSum(int[] nums) {
        //先将数组元素从小到大排序
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                while (j<k&&nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
                if(j>=k){
                    break;
                }
                if (nums[i]+nums[j]+nums[k]==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while (j<k&&nums[j]==nums[j+1]){
                        j++;
                    }
                    j++;
                }
                while (j<k&&nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                if(j>=k){
                    break;
                }
                if (nums[i]+nums[j]+nums[k]==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while (j<k&&nums[k]==nums[k-1]){
                        k--;
                    }
                    k--;
                }
            }
            while (i<nums.length-2&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}

