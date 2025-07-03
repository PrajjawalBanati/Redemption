/*
* Given a string s, return true if it is a palindrome, otherwise return false.
* A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
* Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
* Example 1:
*
* Input: s = "Was it a car or a cat I saw?"
* Output: true
* Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
*
* Example 2:
* Input: s = "tab a cat"
* Output: false
* Explanation: "tabacat" is not a palindrome.
*
* */
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ValidPalindrome {
    public boolean isPalindrome(String s)
    {
        String str = s.toLowerCase();
        boolean isValid = true;
        int pointerOne = 0;
        int pointerTwo = s.length()-1;
        while(pointerOne < pointerTwo)
        {
            char ch1 = str.charAt(pointerOne);
            char ch2 = str.charAt(pointerTwo);
            if(!((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= '0' && ch1 <= '9')))
            {
                pointerOne++;
            }
            else if(!((ch2 >= 'a' && ch2 <= 'z') || (ch2 >= '0' && ch2 <= '9')))
            {
                pointerTwo--;
            }
            else {
                if(ch1 != ch2)
                {
                    isValid = false;
                    break;
                }
                else
                {
                    pointerTwo--;
                    pointerOne++;
                }
            }
        }
        return isValid;
    }
}
