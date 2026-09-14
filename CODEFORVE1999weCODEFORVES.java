import  java.util.Scanner;
public class CODEFORVE1999weCODEFORVES {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int as;
        as=sc.nextInt();
        while(as-->0){
            int inp=sc.nextInt();
            int temp=inp;
            int total=0;
            int rem;
            while (temp>0) {
                rem=temp%10;
                total=total+rem;
                temp=temp/10;
            }
            System.out.println(total);
        }
    }
}
