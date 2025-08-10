import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.Map;

public class LongestCharacterRepeatingReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int startIndex = 0, endIndex = 0, maxLength = 0, maxFrequencyOfCharacter=0;
        HashMap<Character, Integer> freq = new HashMap<>();
        while(endIndex < n)
        {
           if(freq.containsKey(s.charAt(endIndex)))
           {
               freq.put(s.charAt(endIndex), freq.get(s.charAt(endIndex))+1);
           }
           else {
               freq.put(s.charAt(endIndex), 1);
           }
           int length = endIndex - startIndex + 1;
           for(Map.Entry<Character, Integer> mp: freq.entrySet())
           {
               maxFrequencyOfCharacter = Math.max(mp.getValue(),maxFrequencyOfCharacter);
           }
           int replacementNeeded = length - maxFrequencyOfCharacter;
           if(replacementNeeded <= k)
           {
               maxLength = Math.max(length,maxLength);
               endIndex++;
           }
           else{
               freq.computeIfPresent(s.charAt(startIndex), (key,value)->(value-1) <= 0 ? null: value-1);
               startIndex++;
               freq.computeIfPresent(s.charAt(endIndex),(key, value)->(value - 1)<=0 ? null: value-1);
           }
        }
        return maxLength;
    }
}
