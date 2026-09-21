import java.util.*;

public class cf2263_A {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int no_of_iteratores;
        // no_of_iteratores = sc.nextInt();
        
        // while (no_of_iteratores > 0) {
        //     int n = sc.nextInt();
        //     int[] a = new int[n];
        //     for (int i = 0; i < n; i++) {
        //         a[i] = sc.nextInt();
        //     }
            
        //     if ((a[0] == 1 && a[n - 1] == 1) || (a[n - 1] == 0)) {
        //         System.out.println("Bessie");
        //     } else {
        //         System.out.println("Elsie");
        //     }
            
        //     no_of_iteratores--;
        // }
        // sc.close();
        // failed test vase 2
        Scanner sc = new Scanner(System.in);
        int no_of_iteratores;
        no_of_iteratores = sc.nextInt();
        
        while (no_of_iteratores > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int count_ones = 0; 
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == 1) {
                    count_ones++; 
                }
            }
            
            if (count_ones >= 2 || (count_ones == 1 && n == 2)) {
                System.out.println("Bessie");
            } else {
                System.out.println("Elsie");
            }
            
            no_of_iteratores--;
        }
        sc.close();
    
        import java.util.*;
    public class cf2263_A {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int no_of_iteratores = sc.nextInt();
            
            while (no_of_iteratores > 0) {
                int n = sc.nextInt();
                int count_ones = 0;
                for (int i = 0; i < n; i++) {
                    int val = sc.nextInt();
                    if (val == 1) {
                        count_ones++;
                    }
                }
int count_zeros = n - count_ones;
if (count_ones >= count_zeros) {
    System.out.println("Bessie");
} else {
    System.out.println("Elsie");
}
                
                no_of_iteratores--;
            }
            sc.close();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}