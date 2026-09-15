
public class SDSAAS {
    public static void main(String[] args) {
       int[] sd={3,2,2,3}; 
       int tar=3;
       int index=0;
       int count=0;
        for(int i=0;i<sd.length;i++){
            if(sd[i]!=tar){
                count++;
                int temp=sd[i];
                sd[i]=sd[index];
                sd[index]=temp;
                index++;
            }
        }
        
        for(int s:sd){
            System.out.println(s+" ");
        }
    }
}
