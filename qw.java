public class qw {
    class Solution {
    public int reverseDegree(String s) {
        char[] aws=s.toCharArray();
        int sum=0;
        // int s=0;
        for(int i=aws.length-1;i>=0;i--){
            sum += ('z' - aws[i]+1) * (1 + i);
        }
        return sum;
    }
}
}
