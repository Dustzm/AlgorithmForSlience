package middle;

import java.util.*;

/**
 * 字符串中的所有变位词
 * @author Slience
 * @date 2022/6/14 14:12
 **/
public class AnagramsInString {

    public static void main(String[] args) {
        AnagramsInString ana = new AnagramsInString();
        System.out.println(ana.findAnagrams("cbaebabacd","abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        if(sLength <= pLength){
            res.add(0);
            return res;
        }
        int[] pMap = new int[26];
        int[] sMap = new int[26];
        for(int i = 0;i < p.length(); i++){
            pMap[p.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while(right < sLength){
            sMap[s.charAt(right) - 'a']++;
            if(Arrays.equals(pMap, sMap)){
                res.add(right);
            }
            if(right - left + 1 > pLength){
                sMap[s.charAt(left++) - 'a']--;
            }
            right++;
        }
        return res;
    }

    //时间太长
    @Deprecated
    public List<Integer> findAnagramsDeprecated(String s, String p) {
        List<Integer> res = new ArrayList<>();
        //哈希表
        Map<Character, Integer> pMap = new HashMap<>();
        for(Character charac : p.toCharArray()){
            if(pMap.containsKey(charac)){
                int num = pMap.get(charac);
                pMap.put(charac, ++num);
            }else{
                pMap.put(charac,1);
            }
        }
        char[] sArr = s.toCharArray();
        for(int i =0;i < sArr.length; i++){
            if(!pMap.keySet().contains(sArr[i])){
                continue;
            }
            if(sArr.length - i < p.length()){
                continue;
            }
            Map<Character, Integer> temp = new HashMap<>(pMap);
            if(p.contains(sArr[i] + "") && isAnagrams(s.substring(i,i + p.length()), temp)){
                res.add(i);
            }
        }
        return res;
    }

    private Boolean isAnagrams(String word, Map<Character, Integer> pMap){
        for(Character c : word.toCharArray()){
            if(pMap.get(c) == null){
                return false;
            }
            int value = pMap.get(c);
            if(value >= 0){
                pMap.put(c, --value);
            }else{
                return false;
            }
        }
        for(Integer value : pMap.values()){
            if(value != 0){
                return false;
            }
        }
        return true;
    }

}
