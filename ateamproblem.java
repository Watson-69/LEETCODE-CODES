import java.util.Scanner;
public class ateamproblem {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int s;
       int counter=0;
       s=sc.nextInt();
       for(int i=0;i<s;i++){
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
            if((a+b+c)>=2){
                counter++;
            }
       }
       System.out.println(counter);
    }
}
