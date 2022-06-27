package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列
 * @author Slience
 * @date 2022/5/20 14:53
 **/
public class Fibonacci {

    Map<Integer, Integer> map = new HashMap<>();

    private int fib(int n) {
        if(n == 1){
            return 1;
        }else if(n == 0){
            return 1;
        }
        if(null != map.get(n)){
            return map.get(n);
        }else{
            int res = fib(n - 1) + fib(n - 2);
            map.put(n, res);
            return res;
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(7));
    }

}
