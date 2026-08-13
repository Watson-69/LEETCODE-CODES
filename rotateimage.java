public class rotateimage {
    public static void main(String[] args) {
        int[][] matrix=new int[3][3];
        int n=matrix.length;
        int temp[][]=new int[n][n];
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i].length;j++){
               temp[i][j]=matrix[n-1-j][i];
            }          // brute force apprach problem 48
        } 
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i].length;j++){
              matrix[i][j] = temp[i][j];
            }
        }
        int n=matrix.length;
         for (int i = 0; i < n / 2; i++) { 
            for (int j = i; j < n - 1 - i; j++) {
                int top = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = top;
            }
            // optimized apparoach 
    }
}
