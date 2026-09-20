public class we724 {
    class Solution {
    public int pivotIndex(int[] nums) {
      int left=0;
      int sum=0;
      for(int s:nums){
        sum+=s;
      }
      int right=sum;
      for(int i=0;i<nums.length;i++){
        right-=nums[i];
        if(left==right){
            return i;
        }
        left+=nums[i];
      }
      return -1;  
    }
}  // pivot index ravjot 
}
