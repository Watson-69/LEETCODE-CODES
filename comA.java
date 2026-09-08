public class comA {
    public static void main(String[] args) {
        int n=213;
        System.out.println(countcommas);
    
    }
      // approach 1
    public int countCommas(int n) {
        int comma = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                temp = temp / 10;
                count++;
            }
            if (count >= 4) {
                comma++;
            }
        }
        return comma;
    }
    // approch 2;
    math.max(0,n-999);
}
