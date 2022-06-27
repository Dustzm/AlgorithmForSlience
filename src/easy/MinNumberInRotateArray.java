package easy;

/**
 * 旋转数组的最小数字
 * @author Slience
 * @date 2022/5/23 14:15
 **/
public class MinNumberInRotateArray {

    //正解
    private static int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        int middle;
        while(i < j){
            middle = (numbers[i] + numbers[j]) / 2;
            if(numbers[middle] < numbers[j]){
                j = middle;
            }else if(numbers[middle] > numbers[j]){
                i = middle + 1;
            }else if(numbers[middle] == numbers[j]){
                int x = i;
                for(int k = i + 1; k < j; k++) {
                    if(numbers[k] < numbers[x]) x = k;
                }
                return numbers[x];
            }
        }
        return numbers[i];
    }

    private static int i_am_sb(int [] numbers){
        int min = numbers[0];
        for(int i : numbers){
            if (min > i){
                min = i;
            }
        }
        return min;
    }
}
