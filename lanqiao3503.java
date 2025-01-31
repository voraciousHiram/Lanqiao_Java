/* lanqiao3503
 * GIP
 * January 27, 2025
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int ans = 0;
        int[][] dp = new int[5010][5010];
        for (int k=1; k<s.length(); k++) {
            for (int i=0; i+k<s.length(); i++) {
                int j = i+k;
                if (s.charAt(i) > s.charAt(j)) {
                    dp[i][j] = 1;
                }
                else if (s.charAt(i) < s.charAt(j)) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i+1][j-1];
                }
                if (dp[i][j] == 1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
        scan.close();
    }
}