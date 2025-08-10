import java.util.HashSet;

public class LongestSubstringWIthoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int startIndex = 0, endIndex = 0, maxLength = 0;
        int n = s.length();
        HashSet<Character> hs = new HashSet<>();
        while(endIndex < n)
        {
            if(hs.contains(s.charAt(endIndex)))
            {
                hs.remove(s.charAt(startIndex));
                startIndex++;
            }
            else
            {
                hs.add(s.charAt(endIndex));
                int length = endIndex - startIndex + 1;
                maxLength = Math.max(maxLength, length);
                endIndex++;
            }
        }
        return maxLength;
    }
}
