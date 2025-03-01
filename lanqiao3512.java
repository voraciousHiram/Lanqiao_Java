/* lanqiao3512
 * GIP
 * January 31, 2025
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] dp = new int[10];
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int longest = 0;
        for (int i=0; i<n; i++) {
            //int x = scan.nextInt(); // Reading by string makes the subsequent operations simpler
            String x = scan.next();
            int head = x.charAt(0) - '0';
            int tail = x.charAt(x.length()-1) - '0';
            dp[tail] = Math.max(dp[tail], dp[head]+1);
            longest = Math.max(longest, dp[tail]);
        }
        scan.close();
        System.out.println(n-longest);
    }
}
