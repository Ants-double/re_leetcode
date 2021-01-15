package leetcode;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/15
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int reverse = reverse(123);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String s = String.valueOf(x);
        StringBuilder stringBuilder=new StringBuilder();
        int i = 0;
        if (s.charAt(0) == '-') {

            i = 1;
        }
        for (int n=s.length()-1;n>i-1;n--){
            stringBuilder.append(s.charAt(n));
        }
        long temp=i==0?Long.valueOf(stringBuilder.toString()):Long.valueOf("-"+stringBuilder.toString());
        return  (temp>Integer.MAX_VALUE||temp<Integer.MIN_VALUE)?0:(int)temp;



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
