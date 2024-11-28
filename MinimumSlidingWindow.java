import java.util.HashMap;
import java.util.Map;

public class MinimumSlidingWindow {

    public static String minWindow(String s, String t){
        int m = t.length();
        int n = s.length();

        if(m > n)
            return "";

        Map<Character, Integer> charCount = new HashMap<>();
        for(char c : t.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c , 0) + 1);
        }
        int l = 0 , r = 0, count = 0, minLen = n + 1, minLeft = 0;
        while(r < n){
            if(charCount.containsKey(s.charAt(r))){
                charCount.put(s.charAt(r), charCount.get(s.charAt(r)) - 1);
                if(charCount.get(s.charAt(r)) >= 0){
                    count++;
                }
            }
            while(count == m){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    minLeft = l;
                }
                if(charCount.containsKey(s.charAt(l))){
                    charCount.put(s.charAt(l), charCount.get(s.charAt(l)) + 1);
                    if(charCount.get(s.charAt(l)) > 0){
                        count--;
                    }
                }
                l++;
            }
            r++;
        }
        if(minLen > n){
            return "";
        }
        return s.substring(minLeft, minLeft + minLen);
    }
}
