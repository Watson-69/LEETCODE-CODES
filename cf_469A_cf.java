import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class cf_469A_cf {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int S1;
        S1=sc.nextInt();  //level reader 
        int p ,q; // X and Y friend level
        Set<Integer> levelcovered =new HashSet<>();
        p=sc.nextInt();
        for(int i=0;i<p;i++){
            levelcovered.add(sc.nextInt());
        }
        q=sc.nextInt();
        for(int i=0;i<q;i++){
            levelcovered.add(sc.nextInt());
        }
        if(levelcovered.size()==S1){
            System.out.println("I become the guy.");
        }
        else{
            System.out.println("Oh, my keyboard!");
        }
    }
}
