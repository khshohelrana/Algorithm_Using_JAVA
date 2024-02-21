import java.util.Scanner;

public class MAinCLass {
    static int [][] matrix= new int[50][50];
    public static void main(String[] args) {
        int e=7, n=6;

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the edges: ");
        for(int i=0; i<e; i++) {
            int j = scan.next().charAt(0);
            int k = scan.next().charAt(0);
            matrix[(int) j - 65][(int) k - 65] = matrix[(int) k - 65][(int) j - 65] = 1;
        }

        System.out.println("Öutput Of the Graph: ");
        for(int a=0; a<n; a++){

            for(int b=0; b<n; b++){

                System.out.print(matrix[a][b]+" ");
            }
            System.out.println("");

        }
    }

}

