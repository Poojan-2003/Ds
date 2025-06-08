import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int tc = sc.nextInt();

        switch (tc) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println("Default");
                break;
        }
    }
}
