/* lanqiao2128
 * GIP
 * January 27, 2025
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long ans1 = 0;
        long ans2 = 0;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n+1];
        int[] d = new int[n+1];
        int[] cnt = new int[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        for (int i=0; i<m; i++) {
            int L = scan.nextInt();
            int R = scan.nextInt();
            d[L]++;
            d[R+1]--;
        }
        scan.close();

        for (int i=1; i<=n; i++) {
            cnt[i] = cnt[i-1] + d[i];
        }
        for (int i=1; i<=n; i++) {
            ans1 += (long)cnt[i]*a[i]; // use long type!!!
        }
        Arrays.sort(a);
        Arrays.sort(cnt);
        for (int i=1; i<=n; i++) {
            ans2 += (long)cnt[i]*a[i];
        }
        System.out.println(ans2 - ans1);
    }
}
