package easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * @author Slience
 * @date 2022/9/29 15:21
 **/
public class FirstUniqChar {

    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }

    public char firstUniqChar(String s) {
        if(s.equals("")){
            return ' ';
        }
        Map<Character, Integer> tempMap = new HashMap<>();
        char[] strs = s.toCharArray();
        for(char c : strs){
            if(tempMap.get(c) == null){
                tempMap.put(c, 1);
            } else {
                int num = tempMap.get(c) + 1;
                tempMap.put(c, num);
            }
        }
        for(char c : strs){
            if(tempMap.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        FirstUniqChar temp = new FirstUniqChar();
        System.out.println(temp.firstUniqChar2("leetcode"));
    }
}
