import java.util.Scanner;
public class codeforcebeautifulmatrix {
    public static void beautiful_matrix(int[][] arr,Scanner sc){
        int tarcol=0;
        int tarrow=0;
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                int value=sc.nextInt();
                if(value==1){
                    tarrow=i;
                    tarcol=j;
                }
            }
        }
        int rowdif=tarrow-3;
        if(rowdif<0){
            rowdif=-rowdif;
        }
        int coldif=tarcol-3;
        if(coldif<0){
            coldif=-coldif;
        }
        int moves=rowdif+coldif;
        System.out.println(moves);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] arr=new int[5][5];
        beautiful_matrix(arr,sc);
    }
}
