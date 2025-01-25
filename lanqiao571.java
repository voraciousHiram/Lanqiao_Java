/* lanqiaoOJ 571
 * GPI
 * January 23, 2025
 */
import java.util.*;

public class Main {
    static char[] s = new char[1100];
    static char[] tree = new char[4400];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String input = scan.next();
        s = input.toCharArray();
        buildFBI(1, 0, s.length-1);
        postorder(1);
        scan.close();
    }
    public static int ls(int p) {
        return p<<1;
    }
    public static int rs(int p) {
        return p<<1 | 1;
    }
    public static void buildFBI(int p, int left, int right) {
        if (left == right) {
            if (s[left] == '1') {
                tree[p] = 'I';
            }
            else {
                tree[p] = 'B';
            }
            return;
        }
        int mid = (left + right) / 2;
        buildFBI(ls(p), left, mid);
        buildFBI(rs(p), mid + 1, right);
        if (tree[ls(p)] == 'B' && tree[rs(p)] == 'B') {
            tree[p] = 'B';
        }
        else if (tree[ls(p)] == 'I' && tree[rs(p)] == 'I') {
            tree[p] = 'I';
        }
        else {
            tree[p] = 'F';
        }
    }
    public static void postorder(int p) {
        if(tree[ls(p)] != 0) {
            postorder(ls(p));
        }
        if (tree[rs(p)] != 0) {
            postorder(ls(p));
        }
        System.out.println(tree[p]);
    }
}