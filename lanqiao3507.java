/* lanqiao3507
 * GIP
 * January 26, 2025
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = scan.nextInt();
        }
        scan.close();

        long ans=0;  // pay attention to using the long type!!!
        for (int i=0; i<=20; i++) {
            int sum=0;
            long ansi = 0;
            int one = 0;
            int zero = 1;
            for (int j=0; j<n; j++) {
                int x = (a[j]>>i) & 1;
                sum ^= x;
                if (sum == 0) {
                    ansi += one;
                    zero++;
                }
                else {
                    ansi += zero;
                    one++;
                }
            }
            ans += ansi*(1L << i); // long type!
        }
        System.out.println(ans);
    }
}

/*
 * 运用了异或的性质，是挺难的题，真的不好想
 */