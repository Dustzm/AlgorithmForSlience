package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 0 和 1 个数相同的子数组
 * @author Slience
 * @date 2022/6/13 14:14
 **/
public class OneAndZeroSameNumberInSubArray {

    //时间太长
    @Deprecated
    private static int findMaxLengthDeprecated(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int one = 0, zero = 0;
            for(int j = i;j < nums.length; j++){
                if(nums[j] == 0){
                    zero++;
                }
                if(nums[j] == 1){
                    one++;
                }
                if(one == zero){
                    if(max < (j-i+1)){
                        max = (j-i+1);
                    }
                }
            }
        }
        return max;
    }

    private static int findMaxLength(int[] nums){
        /**
         将数组中的0换成-1， 求和为0的最长子数组 转换成前缀和问题
         */
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0, sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }else map.put(sum, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,0};
        System.out.println(findMaxLength(nums));
    }

}
