import java.util.Scanner;
public class monococm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int cnt0 = 0;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                if (a[i] == 0) {
                    cnt0++;
                }
            }
            if (a[0] == 0 && a[n - 1] == 0) {
                System.out.println(0);
            }

            else if (a[0] == 0 || a[n - 1] == 0) {
                if (cnt0 >= 2) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }

            else {
                if (cnt0 >= 2) {
                    System.out.println(2);
                } else {
                    System.out.println(-1);
                }
            }
        }
        scanner.close();
    }
}
