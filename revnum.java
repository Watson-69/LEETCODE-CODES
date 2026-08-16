import java.util.*;
public class revnum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sd=sc.nextInt();
        int temp=sd;
        if(temp<0){
            temp=-1*temp;
        }
        int rem,total=0;
        while(temp>0){
            rem=temp%10;
            total=total*10+rem;
            temp=temp/10;
        }
            public int reverse(int x) {
        // int temp=x;
        int rem;
        long total=0; // for integer overflow
        for (int temp = x; temp != 0; temp /= 10) {
             rem = temp % 10;
            total = total * 10 + rem;
        }

        if (total >= Integer.MAX_VALUE || total <= Integer.MIN_VALUE) {
            return 0;
            }
        
        return (int)  total; //this is for integr overflw 
    }
    }
}
