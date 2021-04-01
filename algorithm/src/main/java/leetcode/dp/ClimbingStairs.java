package leetcode.dp;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/3/31
 */
public class ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(waysToStep(18));
    }

    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;

        }
        return r;
    }

    static int  waysToStep(int n) {
        if(n<3) {
            return n;
        }
        double base=1e9+7,dp0=1,dp1=2,dp2=4,temp1,temp2;
        while(n--!=3){
            temp1=dp1;temp2=dp2;
            dp2=((dp0+dp1)%base+dp2)%base;
            dp0=temp1;dp1=temp2;
        }
        return (int)dp2;
    }
}
