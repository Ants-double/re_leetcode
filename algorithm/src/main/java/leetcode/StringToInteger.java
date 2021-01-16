package leetcode;

/**
 * @Author lyy
 * @Description
 * @Date 2021-01-16
 **/
public class StringToInteger {

	public static void main(String[] args) {

		int myAtoi = myAtoi("-91283472332");
		System.out.println(myAtoi);
	}

	public static int myAtoi(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// 真正的数字位
		int index = 0;
		// 符号标记
		int flag = 1;
		long result = 0;
		s = s.trim();
		for (index = 0; index < s.length(); index++) {
			if (s.charAt(index) == '-' && index == 0) {
				flag = -1;
			}else if (s.charAt(index) == '+' && index == 0){
				continue;
			}
			else {
				if ('0' <= s.charAt(index) && s.charAt(index) <= '9') {
					result = result * 10 + s.charAt(index) - '0';
					if (flag == -1 && result > Integer.MAX_VALUE) {
						return Integer.MIN_VALUE;

					}
					if (flag == 1 && result > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				} else {
					break;
				}

			}
		}

		return (int) (flag * result);

	}
}
