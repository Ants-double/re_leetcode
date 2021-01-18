package leetcode;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/18
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int i = maxArea(new int[]{4, 3, 2, 1, 4});
        System.out.println(i);
    }
    public static int maxArea(int[] height) {

        int result=Integer.MIN_VALUE;
        if(height.length<2){
            return result;
        }
        int i=0,j=height.length-1;
        while (i<j){
            result=Math.max(result,Math.min(height[i],height[j])*(j-i));
            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return result;
    }
}
