package com.ants.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ants_
 */
public class UniqueSubCharacter {

    public static void main(String[] args) {


    }

    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if (!map.containsKey(sc[i])) {
                map.put(sc[i], new ArrayList<>());
            }
            map.get(sc[i]).add(i);
        }
        // 按分区分段进行计算 包含重复的情况
        int result = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            int head = -1, tail = -1;
            List<Integer> item = entry.getValue();
            for (int i = 0; i < item.size(); i++) {
                tail = (i < item.size() - 1) ? item.get(i + 1) : sc.length;
                result += (item.get(i) - head) * (tail - item.get(i));
                head = item.get(i);

            }
        }
        return result;
    }
}



