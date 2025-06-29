import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
* An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
*
* Example 1:
* Input: strs = ["act","pots","tops","cat","stop","hat"]
* Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
*
* Example 2:
* Input: strs = ["x"]
* Output: [["x"]]
*
* Example 3:
* Input: strs = [""]
* Output: [[""]]
*
* Constraints:
* 1 <= strs.length <= 1000.
* 0 <= strs[i].length <= 100
* strs[i] is made up of lowercase English letters.
*
* */
public class GroupAnagrams {
    public List<List<String>> groupAnagramsInList(String[] strs)
    {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for(String word: strs)
        {
            int[] freq = new int[26];
            for(char ch : word.toCharArray())
            {
                freq[ch-'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int count: freq)
            {
                stringBuilder.append(count).append("#");
            }
            String expression = stringBuilder.toString();
            anagramMap.computeIfAbsent(expression, k->new ArrayList<>()).add(word);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
