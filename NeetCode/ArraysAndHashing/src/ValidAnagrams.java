import java.util.HashMap;
import java.util.Map;

/*
* Valid Anagram
* Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
* An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
* Example 1:
* Input: s = "racecar", t = "carrace"
* Output: true
Example 2:
* Input: s = "jar", t = "jam"
* Output: false
* Constraints:
* s and t consist of lowercase English letters.
*
* */
public class ValidAnagrams {
    public boolean isValidAnagram(String s, String t)
    {
        HashMap<Character, Integer> htf = new HashMap<>();
        HashMap<Character, Integer> hts = new HashMap<>();
        boolean isValid = true;
        for(int i = 0; i < s.length(); i++)
        {
            if(htf.containsKey(s.charAt(i)))
            {
                int freq = htf.get(s.charAt(i));
                htf.put(s.charAt(i), ++freq);
            }
            else
            {
                htf.put(s.charAt(i),1);
            }
        }
        for(int i = 0; i < t.length(); i++)
        {
            if(hts.containsKey(t.charAt(i)))
            {
                int freq = hts.get(t.charAt(i));
                hts.put(t.charAt(i), ++freq);
            }
            else
            {
                hts.put(t.charAt(i),1);
            }
        }
        for(Map.Entry<Character, Integer> mp: htf.entrySet())
        {
            char ch = mp.getKey();
            int freq = mp.getValue();

            try {
                int freqS = hts.get(ch);
                if(freq != freqS)
                {
                    isValid = false;
                }
            }
            catch (NullPointerException excp)
            {
                isValid = false;
            }

        }
        return isValid;

    }
}
