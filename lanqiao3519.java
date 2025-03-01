/* lanqiao3519
 * GIP
 * February 1, 2025
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        scan.close();

        s = "#" + s;
        int[] dp = new int[s.length()];
        for (int i=2; i<s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i) || s.charAt(i-1) == '?' || s.charAt(i) == '?') {
                dp[i] = Math.max(dp[i-1], dp[i-2]+1);
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        System.out.println(dp[s.length()-1]);
    }
}
