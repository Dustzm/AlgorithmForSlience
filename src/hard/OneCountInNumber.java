package hard;

/**
 * 1～n 整数中 1 出现的次数
 * @author Slience
 * @date 2022/7/7 14:07
 **/
public class OneCountInNumber {

    public int countDigitOne(int n) {
        //初始化
        int digit = 1, res = 0;
        int high = n/10, cur = n % 10, low = 0;
        //dp处理
        while (high != 0 || cur != 0){
            if(cur == 0){
                res += high * digit;
            }else if(cur == 1){
                res += high * digit + low + 1;
            }else{
                res += (high + 1) * digit;
            }
            //进位
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }


}
