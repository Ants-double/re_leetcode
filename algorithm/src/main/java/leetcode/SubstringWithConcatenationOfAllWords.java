package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/2/5
 */
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        List<Integer> barfoothefoobarman = findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        for (Integer integer : barfoothefoobarman) {
            System.out.println(integer);
        }


    }

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return result;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            HashMap<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == wordNum) {
                result.add(i);
            }
        }


        return result;
    }
}
