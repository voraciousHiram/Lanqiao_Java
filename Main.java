/*  http://oj.ecustacm.cn/problem.php?id=1734
    GIP
    January 21, 2025
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i=0; i<N; i++) {
            int x = scan.nextInt();
            a.add(x);
        }
        scan.close();

        //int ans = (N-1)*2;      !!!!!!!!!! 十年oi两茫茫，不开longlong见祖宗
        long ans = (N-1)*2;
        Stack<Integer> st = new Stack<Integer>();
        for (int i=0; i<N; i++) {
            while ((!st.empty()) && a.get(i) > a.get(st.peek())) {
                st.pop();
                if (!st.empty()) {
                    //ans += i - st.peek() + 1;       !!!!!!!
                    ans += (long)(i - st.peek() + 1);
                }
            }
            st.push(i);
        }
        System.out.println(ans);
    }
}