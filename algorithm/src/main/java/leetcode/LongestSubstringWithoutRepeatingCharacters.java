package leetcode;

import java.util.HashSet;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/11
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        int abcabcbb = lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }

    public static int lengthOfLongestSubstring(String s) {
        int result=0;

        if (s==null||s.length()==0){
            return result;
        }
        HashSet<Character> hash=new HashSet<Character>();
        int i=0;
        int j=0;

        for (;i<s.length(); i++){

            if (i!=0){
                hash.remove(s.charAt(i-1));
            }
            while (j<s.length()&&!hash.contains(s.charAt(j))){
                hash.add(s.charAt(j));
                j++;
            }

            result=Math.max(result, j - i );
        }

        return result;
    }

}
