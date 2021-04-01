package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/14
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String ababa = convert("PAYPALISHIRING", 3);
        System.out.println(ababa);
        String[] temp={"","1"};
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (s == null || s.length() < 0) {
            return "";
        }
        StringBuilder[] array = new StringBuilder[numRows];
        for (int init = 0; init < array.length; init++) {
            array[init] = new StringBuilder();
        }
        int step = numRows + (numRows - 2);
        for (int i = 0; i < s.length(); i += step) {

            for (int j = 0; j < step && (i + j) < s.length(); j++) {
                if (j >= numRows) {
                    array[numRows - ((j - numRows) % numRows) - 2].append(s.charAt(i + j));
                } else {
                    array[j % numRows].append(s.charAt(i + j));
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : array) {
            ret.append(row);
        }

        return ret.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows == 1) return s;
        if (s == null || s.length() < 0) {
            return "";
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow==0||curRow==numRows-1)
            {
                goingDown=!goingDown;
            }
            curRow+=goingDown?1:-1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}
