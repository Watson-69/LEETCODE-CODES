public class commapart2_ {
    class Solution { 

    public long countCommas(long n) { 
        long totalcommas = 0; 
        totalcommas += Math.max(0, n - 999L); 
        totalcommas += Math.max(0, n - 999999L);        
        totalcommas += Math.max(0, n - 999999999L); 
        totalcommas += Math.max(0, n - 999999999999L); 
        totalcommas += Math.max(0, n - 999999999999999L); 
        totalcommas += Math.max(0, n - 999999999999999999L); 
        
        return totalcommas; 
    } 
}
}
