package leetcode.recursion;

/**
 * @author ants_
 */
public class Pow50 {

    public static void main(String[] args) {
        double pow = myPow(3, 5);
        double pow2=myPow2(3,5);
        System.out.println(pow);
    }

    public static double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static double myPow2(double x, int n) {
        if(n==0)return 1;
        if(n==1)return x;
        if(n==-1)return 1/x;
        double d1=myPow2(x,n%2);
        double d2=myPow2(x,n/2);
        d2*=d2*d1;
        return d2;
    }

    // test git
    public static double myPow3(double x, long n) {
        if (n == 0) return 1;
        else if (n > 0 && n % 2 == 0) return myPow3(x * x, n / 2);
        else if (n > 0) return myPow3(x, n - 1) * x;
        else return 1 / myPow3(x, -n);
    }
}
