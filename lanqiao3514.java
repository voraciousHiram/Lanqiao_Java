/* lanqiao3514
 * GIP
 * January 31, 2025
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        String s = scan.next();
        char c1 = scan.next().charAt(0); // remember how to read in the char type
        char c2 = scan.next().charAt(0);
        scan.close();

        int length = s.length();
        s = '-' + s;
        int[] dp = new int[length+1];

        // int ans = 0;
        long ans = 0;

        for (int i=1; i<=length; i++) {
            
            //
            dp[i] = dp[i-1]; // don't forget

            if (s.charAt(i) == c1) {
                dp[i] = dp[i-1] + 1;
            }
            if (i>=k && s.charAt(i) == c2) {
                ans += dp[i-k+1];
            }
        }
        System.out.println(ans);
    }
}
