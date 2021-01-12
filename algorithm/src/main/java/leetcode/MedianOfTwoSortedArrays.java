package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author lyy
 * @Deprecated
 * @date 2021/1/12
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2});
        System.out.println(medianSortedArrays);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double result = 0.00;
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, count = 0;
        int[] newArray = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                newArray[count++] = nums1[i++];
            } else {
                newArray[count++] = nums2[j++];
            }
        }
        if (i >= m) {
            while (j < n) {
                newArray[count++] = nums2[j++];
            }
        }
        if (j >= n) {
            while (i < m) {
                newArray[count++] = nums1[i++];
            }
        }

        if (newArray.length % 2 == 1) {
            result = (double) newArray[(newArray.length / 2) ] ;
        } else {
            result = (double) (newArray[(newArray.length / 2)] + newArray[(newArray.length / 2) - 1]) / 2.0;
        }

        return result;


    }
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }


    public static int getKthElement(int[] nums1,int[] nums2,int k){
        int length1=nums1.length,length2=nums2.length;
        int index1=0,index2=0;
        int kthElement=0;
        while (true){
            if (index1==length1){
                return nums2[index2+k-1];
            }
            if (index2==length2){
                return nums1[index1+k-1];
            }
            if (k==1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half=k/2;
            int newIndex1=Math.min(index1+half,length1)-1;
            int newIndex2=Math.min(index2+half,length2)-1;
            if(nums1[newIndex1]<=nums2[newIndex2]){
                k-=(newIndex1-index1+1);
                index1=newIndex1+1;
            }else {
                k-=(newIndex2-index2+1);
                index2=newIndex2+1;
            }

        }

    }


    public static double median(int[] array) {
        int heapSize = array.length / 2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            heap.add(array[i]);
        }
        for (int i = heapSize; i < array.length; i++) {
            if (heap.peek() < array[i]) {
                heap.poll();
                heap.add(array[i]);
            }
        }
        if (array.length % 2 == 1) {
            return (double) heap.peek();
        } else {
            return (double) (heap.poll() + heap.peek()) / 2.0;
        }
    }
}
