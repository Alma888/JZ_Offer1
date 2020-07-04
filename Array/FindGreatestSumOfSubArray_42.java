package Array;
//连续子数组的最大和

//题目描述：输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成
// 一个子数组。求所有子数组的和的最大值。
// 要求时间复杂度为O(n)。

//解题思路：  复杂度（时间O(N) 空间O(1)）
//动态规划是本题的最优解法，以下按照标准流程解题。
//先将给定数组的第一个元素作为：子数组和的最大值，用变量res保存
//然后从数组的第2个元素开始遍历，
//
// 如果当前下标的前面一个元素>0,就将其与当前下标元素的和-->作为该下标的元素
// 如果<0，说明该元素会对当前下标的元素产生负贡献，所以这时：就将当前下标元素-->作为该下标的元素(不变)

//对上面两行文字进行方程描述：
/*
若 dp[i−1]≤0 ，说明 dp[i - 1]对 dp[i]会产生负贡献，即 dp[i-1] + nums[i] 还不如 nums[i] 本身大。
当 dp[i - 1] > 0 时：执行 dp[i] = dp[i-1] + nums[i]；
当 dp[i - 1] <=0 时：执行 dp[i] = nums[i]。
 */
//然后以上遍历操作过程中，会用res保存：相比之下的最大的下标元素，即就是连续子数组的最大和。
//最终程序返回res即可。

// （其实整个程序：就是改变了数组每个位置的元素，每个位置的新元素就是连续子数组的和）
public class FindGreatestSumOfSubArray_42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] +=Math.max(nums[i - 1],0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new FindGreatestSumOfSubArray_42().maxSubArray(arr));
    }
}
