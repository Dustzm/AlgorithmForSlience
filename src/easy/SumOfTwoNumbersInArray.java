package easy;

import java.util.Arrays;

/**
 * 和为s的两个数字
 * @author Slience
 * @date 2022/6/27 13:22
 **/
public class SumOfTwoNumbersInArray {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int sum;
        while(left < right){
            sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{nums[left], nums[right]};
            }
            if(sum < target){
                left ++;
            }else{
                right --;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{14,15,16,22,53,60};
        SumOfTwoNumbersInArray temp = new SumOfTwoNumbersInArray();
        System.out.println(Arrays.toString(temp.twoSum(arr, 76)));
    }
}
