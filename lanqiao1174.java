/* lanqiao1174
 * GIP
 * January 30, 2025
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int C = scan.nextInt();
        int[] c = new int[n+1];
        int[] w = new int[n+1];
        for (int i=1; i<=n; i++) {
            c[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        scan.close();
        int[][] dp = new int[n+1][C+1];
        for (int i=1; i<=n; i++) {
            for (int j=0; j<=C; j++) {
                if (c[i]>j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c[i]]+w[i]);
                }
            }
        }
        System.out.println(dp[n][C]);
    }
}
