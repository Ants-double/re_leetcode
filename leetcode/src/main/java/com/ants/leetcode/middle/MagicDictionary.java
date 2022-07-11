package com.ants.leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ants_
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-magic-dictionary
 */
public class MagicDictionary {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello","helee", "leetcode"});
        boolean hello = magicDictionary.search("hhllo");
        System.out.println(hello);

    }

    private Map<Integer, List<String>> dictionaryMap = new HashMap<>();

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {

        for (int i = 0; i < dictionary.length; i++) {
            int key = dictionary[i].length();
            List<String> strings = dictionaryMap.get(key);
            if (strings == null) {
                strings = new ArrayList<>();
            }
            strings.add(dictionary[i]);
            dictionaryMap.put(key, strings);
        }

    }

    public boolean search(String searchWord) {
        boolean result = false;
        // 先判断长度
        List<String> list = dictionaryMap.get(searchWord.length());
        if (list == null || list.size() <= 0) {
            return result;
        }
        // 存在同样长度的，判断不相同的字母数
        int[] tempValue = new int[list.size()];

        for (int i = 0; i < searchWord.length(); i++) {
            for (int j=0;j<list.size();j++) {
                if (searchWord.charAt(i)==list.get(j).charAt(i)){
                    tempValue[j]=tempValue[j]+1;
                    continue;
                }
            }
        }

        // 判断tempValue有值为1的，即存在
        for (int i=0;i<tempValue.length;i++){
            if (tempValue[i]==searchWord.length()-1){
                result=true;
                return result;
            }
        }

        return result;

    }
}
