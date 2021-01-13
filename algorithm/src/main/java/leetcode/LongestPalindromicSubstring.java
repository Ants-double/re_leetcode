package leetcode;

import java.util.HashSet;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/13
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String babad = longestPalindrome("babad");
        System.out.println(babad);
    }


    public static String longestPalindrome(String s) {
        String result="";

        if (s==null||s.length()==0){
            return result;
        }
        int n=s.length();
       boolean[][] dp=new boolean[n][n];
       for (int m=0;m<n;++m){
           for (int i=0;i+m<n;++i){
               int j=i+m;
               if (m==0){
                   dp[i][j]=true;
               }
               else if (m==1){
                   dp[i][j]=(s.charAt(i)==s.charAt(j));
               }
               else {
                   dp[i][j]=(s.charAt(i)==s.charAt(j))&&dp[i+1][j-1];

               }
               if (dp[i][j]&&m+1>result.length()){
                   result=s.substring(i,i+m+1);
               }

           }
       }
        return result;

    }

    public static String longestPalindroms(String s){
        String result="";

        if (s==null||s.length()==0){
            return result;
        }
        int start=0,end=0;
        for (int i=0;i<s.length();i++){
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);
            if (len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        result=s.substring(start,end+1);
        return result;
    }

    public static int expandAroundCenter(String s,int left,int right){
        int L=left,R=right;
        while (L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
