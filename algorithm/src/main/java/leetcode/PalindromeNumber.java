package leetcode;

/**
 * @Author lyy
 * @Description
 * @Date 2021-01-17
 **/
public class PalindromeNumber {
	public static void main(String[] args) {
		boolean palindrome = isPalindrome(121);
		System.out.println(palindrome);

	}



	public static boolean isPalindrome(int x) {
      if(x<0||(x%10==0&&x!=0)){
      	return false;
	  }
      int mindleNumber=0;
      while (x>mindleNumber){
      	mindleNumber=mindleNumber*10+x%10;
      	x/=10;
	  }
      return x==mindleNumber||x==mindleNumber/10;
	}
	public static boolean isPalindrome2(int x) {
		if(x<0||(x%10==0&&x!=0)){
			return false;
		}
		int i = reverse2(x);
		return x==i;
	}

	public static int reverse2(int x) {
		int rev=0;
		while (x!=0){
			int pop=x%10;
			x/=10;
			if(rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7)) {
				return 0;
			}
			if (rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop< -8))return 0;
			rev=rev*10+pop;

		}


		return rev;


	}
}
