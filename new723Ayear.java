import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
public class new723Ayear {
    public static void main(String[] args) {
        Scanner inpr=new Scanner(System.in);
        int[] x=new int[3];
        x[0]=inpr.nextInt();
        x[1]=inpr.nextInt();
        x[2]=inpr.nextInt();
        int gf=Math.min(x[0],Math.min(x[1],x[2]));
        int hg=Math.max(x[0],Math.max(x[1],x[2]));
        int mindistance=hg-gf;
        System.out.println(mindistance);
        inpr.close();
    }
}
