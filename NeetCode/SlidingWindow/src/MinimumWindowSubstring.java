import java.util.HashMap;
import java.util.Objects;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int have = 0, need = 0;
        HashMap<Character, Integer> hms = new HashMap<>();
        HashMap<Character,Integer> hmt = new HashMap<>();
        int [] indexes = new int[]{-1,-1};
        int startIndex = 0, endIndex = 0, minLength = Integer.MAX_VALUE;
        int n = s.length();
        int m = t.length();
        if(m > n)
        {
            return "";
        }
        for(char ch: t.toCharArray()) {
            hmt.compute(ch, (k, v) -> v == null ? 1 : v + 1);
            hms.put(ch,0);
        }
        need = hmt.size();
        while(endIndex < n)
        {
            if(hms.containsKey(s.charAt(endIndex)))
            {
                hms.put(s.charAt(endIndex), hms.get(s.charAt(endIndex))+1);
                if(Objects.equals(hms.get(s.charAt(endIndex)), hmt.get(s.charAt(endIndex))))
                {
                    have++;
                }
                while(have == need)
                {
                    int length = endIndex-startIndex+1;
                    indexes = length < minLength ? new int[]{startIndex, endIndex} : indexes;
                    minLength = Math.min(length, minLength);
                    if(Objects.equals(hmt.get(s.charAt(startIndex)), hms.get(s.charAt(startIndex))))
                    {
                        have--;
                    }
                    hms.computeIfPresent(s.charAt(startIndex),(k,v)->v-1<=0?0:v-1);
                    startIndex++;
                }
            }
            endIndex++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(indexes[0], indexes[1]+1);
    }
}
