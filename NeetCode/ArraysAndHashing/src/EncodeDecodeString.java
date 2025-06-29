/*
* Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
* Please implement encode and decode
*
* Example 1:
* Input: ["neet","code","love","you"]
* Output:["neet","code","love","you"]
*
* Example 2:
* Input: ["we","say",":","yes"]
* Output: ["we","say",":","yes"]
*
* Constraints:
* 0 <= strs.length < 100
* 0 <= strs[i].length < 200
* strs[i] contains only UTF-8 characters.
*
* */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EncodeDecodeString {
    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String word: strs)
        {
            stringBuilder.append(word.length()).append("#").append(word);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> stringList = new ArrayList<>();
        int size = str.length();
        for(int i = 0; i < size;)
        {
            int j = i;
            while(str.charAt(j) != '#') j++;
            int length = Integer.parseInt(str.substring(i,j));
            j++;
            stringList.add(str.substring(j,j+length));
            i=j+length;
        }
        return stringList;
    }

    public static void main(String[] args) {
        EncodeDecodeString obj = new EncodeDecodeString();
        String encodedString = obj.encode(List.of("neet","code","love","you"));
        System.out.println(encodedString);
        System.out.println(obj.decode(encodedString));

    }
}
