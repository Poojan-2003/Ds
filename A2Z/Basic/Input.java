import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // This will take whole line as input
        // String a = sc.nextLine();
        // This will take input upto next line or space
        // String b = sc.next();
        // System.out.println(b);
        
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++){
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int j=0;j<n;j++){
                arr[j] = sc.next();
            }
            for(String ans: arr){
                System.out.println(ans);
            }
            // System.out.println();
            // System.out.println(Arrays.toString(arr));
        }
    }
}
