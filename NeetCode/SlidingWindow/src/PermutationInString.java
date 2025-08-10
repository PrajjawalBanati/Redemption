import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1 > n2 )
        {
            return false;
        }
        HashMap<Character, Integer> hp1 = new HashMap<>();
        for(char ch : s1.toCharArray())
        {
            if(hp1.containsKey(ch))
            {
                hp1.put(ch,hp1.get(ch)+1);
            }
            else {
                hp1.put(ch,1);
            }
        }
        int startIndex = 0, endIndex = 0;
        HashMap<Character,Integer> hp2 = new HashMap<>();
        while(endIndex < n1)
        {
            char ch = s2.charAt(endIndex);
            if(hp2.containsKey(ch))
            {
                hp2.put(ch, hp2.get(ch)+1);
            }
            else {
                hp2.put(ch,1);
            }
            endIndex++;
        }
        for(Map.Entry<Character,Integer> mp: hp1.entrySet())
        {
            char key = mp.getKey();
            int value = mp.getValue();
            if(hp2.containsKey(key) && hp2.get(key) == value)
            {
                return true;
            }
        }
        while(endIndex < n2)
        {
            char ch = s2.charAt(endIndex);
            hp2.compute(ch, (key,value)->value==null?1:value+1);
            ch = s2.charAt(startIndex);
            hp2.computeIfPresent(ch, (key,value)->value-1<=0? null: value-1);
            for(Map.Entry<Character,Integer> mp: hp1.entrySet())
            {
                char key = mp.getKey();
                int value = mp.getValue();
                if(hp2.containsKey(key) && hp2.get(key) == value)
                {
                    return true;
                }
            }
            endIndex++;
            startIndex++;
        }
        return false;
    }
}
