import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class medianofaarra {
    public static void main(String[] args) {
        int[] num1 = { 1, 3 }; // even
        int[] num2 = { 2 }; // odd case 2
        int[] num3 = { 1 };
        int[] num4 = { 2 }; // both odd case 1
        int[] num5 = { 1, 2 };
        int[] num6 = { 3,4 }; // else case
        int[] combined = new int[num5.length + num6.length];
        System.arraycopy(num5, 0, combined, 0, num5.length);
        System.arraycopy(num6, 0, combined, num5.length, num6.length);
        for(int n:combined){                                                      // this one better for longer runs
            System.out.println(n);
        }

        // if (num3.length % 2 != 0 && num4.length % 2 != 0) {
        //     double sum = 0;
        //     int[] combinator = new int[num3.length + num4.length];
        //     int idc = 0;
        //     for (int n1 : num3) {
        //         combinator[idc++] = n1;
        //     }

        //     for (int n1 : num4) {
        //         combinator[idc++] = n1;
        //     }
        //     for (int n1 : combinator) {
        //         System.out.print(n1 + " ");
        //     }
        //     System.out.println();
        //     for (int i = 0; i < combinator.length; i++) {
        //         // combinator[i]=num1[i]+num2[i];
        //         sum += (combinator[i] + 1) / 2;
        //         // System.out.println(combinator[i]);
        //     }
        //     DecimalFormat df = new DecimalFormat("0.00000");
        //     System.out.println(df.format(sum));
        // } 
        //  if (num1.length == 0 && num2.length != 0) {
        //     double sum1 = 0.0;
        //     int[] combinator1 = new int[num1.length + num2.length];
        //     int idc1 = 0;
        //     for (int n : num1) {
        //         combinator1[idc1] = n;
        //         idc1++;
        //     }
        //     for (int n : num2) {
        //         combinator1[idc1] = n;
        //         idc1++;
        //     }
        //     for (int n : combinator1) {
        //         System.out.print(n + " ");
        //     }
        //     System.out.println();
        //     for (int i = 0; i < combinator1.length; i++) {
        //         // combinator[i]=num1[i]+num2[i];
        //         sum1 += (combinator1[i] + 1) / 2;
        //         // System.out.println(combinator[i]);
        //     }
        //     DecimalFormat df = new DecimalFormat("0.00000");
        //     System.out.println(df.format(sum1));
        // } if(num5.length == 0 && num6.length == 0){
        //     double sum2 = 0.0;
        //     int[] combinator2 = new int[num5.length + num6.length];
        //     int idc2 = 0;
        //     for (int n : num1) {
        //         combinator2[idc2] = n;
        //         idc2++;
        //     }
        //     for (int n : num2) {
        //         combinator2[idc2] = n;
        //         idc2++;
        //     }
        //     for (int n : combinator2) {
        //         System.out.print(n + " ");
        //     }
        //     System.out.println();
        //     for (int i = 0; i < combinator2.length; i++) {
        //         // combinator[i]=num1[i]+num2[i];
        //         sum2 += (combinator2[i] + 1) / 2;
        //         // System.out.println(combinator[i]);
        //     }
        //     DecimalFormat df = new DecimalFormat("0.00000");
        //     System.out.println(df.format(sum2));
        // }
        class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] comb=new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,comb,0,nums1.length);
        System.arraycopy(nums2,0,comb,nums1.length,nums2.length);
        Arrays.sort(comb);
        int len=comb.length;
        if(len%2!=0){
            return comb[len/2];
        }
        else{
            return (comb[len/2-1]+comb[len/2])/2.0;
        }
    }
}// approach for

    }
}
