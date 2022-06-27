package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 赎金信
 * @author Slience
 * @date 2022/5/18 17:04
 **/
public class RansomNote {

    private static boolean canConstructOld(String ransomNote, String magazine) {
        List<String> ransom = new ArrayList<>();
        List<String> source = new ArrayList<>();
        for(int i = 0; i < ransomNote.length(); i++){
            ransom.add(String.valueOf(ransomNote.charAt(i)));
        }
        for(int i = 0; i< magazine.length(); i++){
            source.add(String.valueOf(magazine.charAt(i)));
        }
        for(String str : ransom){
            if(source.contains(str)){
                source.remove(str);
            }else{
                return false;
            }
        }
        return true;
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
       if(ransomNote.length() > magazine.length()){
           return false;
       }
       int[] cnt = new int[26];
       for(char c : magazine.toCharArray()){
           cnt[c - 'a']++;
       }
       for(char c : ransomNote.toCharArray()){
           cnt[c - 'a']--;
           if(cnt[c - 'a'] < 0){
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a","aab"));
    }

}
