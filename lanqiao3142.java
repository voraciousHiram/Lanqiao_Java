/* lanqiaoOJ 3142
 * GIP
 * Januray 25, 2025
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long[] a;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        a = new long[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = scan.nextLong();
        }
        Arrays.sort(a, 1, n+1);
        long[] sum = new long[n+1];
        for (int i=1; i<=n; i++) {
            sum[i] = sum[i-1] + a[i];
        }
        long ans = (long)1e18;
        for (int p=1; p<=k; p++) {
            ans = Math.min(sum[2*p] + sum[n] - sum[n+p-k], ans);
        }
        scan.close();
        System.out.println(ans);
    }
}