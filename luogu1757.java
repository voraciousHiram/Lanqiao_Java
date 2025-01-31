/* luogu1757
 * GIP
 * January 31, 2025
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] cnt = new int[101];
        int[][] w = new int[101][1001];
        int[][] c = new int[101][1001];
        int[][] dp = new int[101][1001];
        int C = scan.nextInt();
        int x = scan.nextInt();
        int n = 0;
        for (int i=1; i<=x; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int p = scan.nextInt();
            cnt[p]++;
            int v = cnt[p];
            c[p][v] = a;
            w[p][v] = b;
            n = Math.max(n, p);
        }
        for (int i=1; i<=n; i++) {
            for (int j=0; j<=C; j++) {
                dp[i][j] = dp[i-1][j];
                for (int k=0; k<=cnt[i]; k++) {
                    if (j>=c[i][k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-c[i][k]]+w[i][k]);
                    }
                }
            }
        }
        System.out.println(dp[n][C]);
        scan.close();
    }
}
