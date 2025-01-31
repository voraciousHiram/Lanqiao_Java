/* luogu1164
 * GIP
 * January 31, 2025
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] a = new int[N+1];
        int[][] dp = new int[N+1][M+1];
        for (int i=1; i<=N; i++) {
            a[i] = scan.nextInt();
        }
        scan.close();
        for (int i=0; i<=N; i++) {  // !!! important initialization, the 'i' starts from 0
            dp[i][0] = 1;
        }
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (j>=a[i]) {
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-a[i]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
