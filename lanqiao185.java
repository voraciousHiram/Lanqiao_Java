/* lanqiao185
 * GPI
 * January 25, 2025
 */
import java.util.*;

public class Main {
    static int[] s;
    public static int find_set(int x) {
        if (x != s[x]) {
            s[x] = find_set(s[x]);
        }
        return s[x];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int A[] = new int[n+1];
        s = new int[1000005];
        for (int i=0; i<1000005; i++) {
            s[i] = i;
        }
        for (int i = 1; i<=n; i++) {
            A[i] = scan.nextInt();
            int root = find_set(A[i]);
            A[i] = root;
            s[root] = find_set(root+1); // s[root] = root+1 也是可以的，但是我第一次写成了s[root] = root++， 这是明显的错误，root先赋值再加加，不要再犯
        }
        scan.close();
        for (int i=1; i<=n; i++) {
            System.out.print(A[i] + " ");
        }
    }
}