package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字
 * @author Slience
 * @date 2022/7/7 13:21
 **/
public class RepeatNumberInArray {

    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for (int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else {
                result = num;
                break;
            }
        }
        return result;
    }

}
