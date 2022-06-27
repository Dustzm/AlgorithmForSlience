package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * FizzBuzz,求3与5的倍数
 * @author Slience
 * @date 2022/5/18 17:31
 **/
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                answer.add("FizzBuzz");
            } else if(i % 3 == 0 ){
                answer.add("Fizz");
            } else if(i % 5 == 0){
                answer.add("Buzz");
            } else{
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }
}
