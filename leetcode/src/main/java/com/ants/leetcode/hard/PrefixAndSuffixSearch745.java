package com.ants.leetcode.hard;

import java.util.*;

/**
 * @author ants_
 */
public class PrefixAndSuffixSearch745 {
    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        int f = wordFilter.f("a", "e");
        System.out.println(f);
    }

    // 超时
//    static class WordFilter {
//        List<String> wordDic=new ArrayList<>();
//        public WordFilter(String[] words) {
//            Arrays.stream(words).forEach(x->wordDic.add(x));
//        }
//
//        public int f(String pref, String suff) {
//            int re = -1;
//            for (int i=0;i<wordDic.size();i++){
//                if (wordDic.get(i).startsWith(pref)&&wordDic.get(i).endsWith(suff)){
//                    re=i;
//                }
//            }
//            return re;
//        }
//    }


    static class WordFilter {
        Map<String, Integer> dictionary = new HashMap<>();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int m = word.length();
                for (int pref = 1; pref <= m; pref++) {
                    for (int suff = 1; suff <= m; suff++) {
                        dictionary.put(word.substring(0, pref) + "&" + word.substring(m - suff), i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return dictionary.getOrDefault(pref + "&" + suff, -1);
        }
    }
}
