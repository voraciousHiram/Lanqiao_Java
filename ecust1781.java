/* ecust1781
 * GIP
 * February 2, 2025
 */
import java.util.Scanner;
public class Main {
    static final int N = 1000005;
    static int[] a = new int[N];
    static int[][] dp = new int[N][2];
    static long ans;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i=1; i<=n; i++) {
            a[i] = scan.nextInt();
        }
        scan.close();

        for (int i=1; i<=n; i++) {
            if (a[i] == 1) {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1];
            }
            else if (a[i] == -1) {
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0] + 1;
            }
        }

        for (int i=1; i<=n; i++) {
            ans += dp[i][0];
        }

        System.out.println(ans);
    }
}
