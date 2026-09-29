public class nooffsteps {
    // approach 1 
    class Solution {
    public int numberOfSteps(int num) {
        int steps=0;
        while(num>0){
            if(num%2==0){
                num=num/2;
            }
            else{
                num=num-1;
            }
            steps++;
        }
        return steps;
    }
}
 // appraocch 2
 class Solution {
    public int numberOfSteps(int num) {
        return helper(num,0);
    }
    public int helper(int num,int count){
            if(num==0){
                return count;
            }
            if(num%2==0){
                return helper(num/2,count+1);
            }
            else{
                return helper(num-1,count+1);
            }

    }
}
}
