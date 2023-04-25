import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nb1, nb2, result;
        String str1 = "stop";
        String str2 = "STOP";

        do {
            nb1 = (int) (Math.random() * 10);
            nb2 = (int) (Math.random() * 10);
            System.out.println(nb1 + " x " + nb2 + " = ");
            result = sc.nextInt();
            if (result == nb1 * nb2) {
                System.out.println("Correct");
                sc.next();
            } else {
                System.out.println("Incorrect");
                System.exit(1);
            }
        } while (str1.equalsIgnoreCase(str2));

    }
}