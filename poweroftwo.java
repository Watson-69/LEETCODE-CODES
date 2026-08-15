public class poweroftwo {
        public boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n-1))==0;
    } // bitwise manipulation approach
        public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        else{
            for(long i=1;i<=n;i=i*2){
                if(i==n){
                    return true;
                }
            }
        }
        return false;
    }
}
