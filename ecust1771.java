/* ecust1771
 * GIP
 * February 2, 2025
 */
import java.util.Scanner;
public class Main {
    static int[] a = new int[100005];
    static int[][][] dp = new int[100005][23][4];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        k++;
        for (int i=1; i<=n; i++) {
            a[i] = scan.nextInt();
        }
        scan.close();

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=k; j++) {
                for (int lastk=1; lastk<=3; lastk++) {
                    for (int nextk=1; nextk<=3; nextk++) {
                        if (nextk == lastk) {
                            dp[i][j][nextk] = Math.max(dp[i][j][nextk], dp[i-1][j][lastk] + play(a[i], nextk));
                        }
                        else {
                            dp[i][j][nextk] = Math.max(dp[i][j][nextk], dp[i-1][j-1][lastk] + play(a[i], nextk));
                        }
                    }
                }
            }
        }

        System.out.println(Math.max(dp[n][k][1], Math.max(dp[n][k][2], dp[n][k][3])));
    }
    public static int play(int red, int blue) {
        if ((red==2 && blue==1) || (red==3 && blue==2) || (red==1 && blue==3)) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
// 挺难的， 边界不好理解；
// 注意dp第二个参数j是指变换了小于等于j次手势（其实是j-1次；因为j==1时是初始，即变换了0次），
// 比如求dp[1][3][1]时，可以理解为在并不存在的0，-1，-2...轮游戏中变换了手势。