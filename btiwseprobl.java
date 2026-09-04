public class btiwseprobl { // this is the approach for the addition via binary
    public static void main(String[] args) {
        int s=1;
        int sas=2;
        int res;
        while(sas!=0){
            int car=s&sas;
            s=s^sas;
            sas=car<<1;
        }
        System.out.println(s);
    }
}
