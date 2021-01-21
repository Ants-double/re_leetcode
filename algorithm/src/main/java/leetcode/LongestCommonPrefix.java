package leetcode;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/21
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"ab", "a"});
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {

        String result="";
        if (strs==null||strs.length==0){
            return result;
        }
        int n=0;
        Character temp=' ';
        boolean flag=true;
        if (strs.length==1){
            return strs[0];
        }
        else {

            while (n<strs[0].length()&&flag){
                if (strs[0].length()<=0){
                    return result;
                }
                temp=strs[0].charAt(n);

                for (int i=1;i<strs.length;i++){

                   if (n<strs[i].length()&&strs[i].charAt(n)!=temp){
                       flag=false;
                       break;
                   }
                   if (n>=strs[i].length()){
                       flag=false;
                       break;
                   }
                }
                n++;
                if (flag){
                    result = result+temp;
                }

            }

        }

        return result;
    }
}
