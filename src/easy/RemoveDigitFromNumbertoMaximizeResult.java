package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 移除指定数字得到的最大结果
 * @author Slience
 * @date 2022/6/14 13:22
 **/
public class RemoveDigitFromNumbertoMaximizeResult {

    public String removeDigit(String number, char digit) {
        if(!number.contains(digit+"")){
            return number;
        }
        List<Integer> index = new ArrayList<>();
        char[] arr = number.toCharArray();
        for(int i =0; i < arr.length; i++){
            if(arr[i] == digit){
                index.add(i);
            }
        }
        StringBuilder max = new StringBuilder("0");
        for(Integer j : index){
            StringBuilder sb = new StringBuilder(number);
            sb.deleteCharAt(j);
            if(max.toString().compareTo(sb.toString()) < 0){
                max = sb;
            }
        }
        return max.toString();
    }

}
