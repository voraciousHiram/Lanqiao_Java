import java.util.Scanner;

public class lanqiao498 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();

        int ok = 0;
        for (int i=N+1; i<=99991231; i++) {
            int y = i/10000;
            int m = (i/100)%100;
            int d = i%100;
            int D = 30;
            int M = 12;
            int Y = 9999;

            if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
                D = 31;
            }
            if (m==2 && ((y%4==0 && y%100!=0) || y%400==0)) {
                D = 29;
            }
            else if (m==2){
                D = 28;
            }

            if (d>D || m>M || y>Y || m<1 || d<1) {  // Don't forget m<1 || d<1
                continue;
            }

            // String s = String.valueOf(i);   //1**
            // Boolean flag = true;
            // for (int j=0; j<4; j++) {
            //     if (s.charAt(j) != s.charAt(7-j)) {
            //         flag = false;
            //         break;
            //     }
            // }
            // if (flag == true) {
            //     System.out.println(s);   //2**
            // }

            // if (s.charAt(0) == s.charAt(2) && s.charAt(0) == s.charAt(5) && s.charAt(0) == s.charAt(7) && s.charAt(1) == s.charAt(3) && s.charAt(1) == s.charAt(4) && s.charAt(1) == s.charAt(6)) {
            //     System.out.println(s);   //2**
            // }
            /* Firstly, if i is converted into a string for processing, it cannot handle cases where y is less than 1000, i.e. there should be a leading 0. Secondly, after outputting the first type of palindrome string, the first type should not be outputted again, and the loop should end after outputting the second type of palindrome string. */
            if(i % 10 == i / 10000000 && i / 10 % 10 == i / 1000000 % 10 && i / 100 % 10 == i / 100000 % 10 && i / 1000 % 10 == i / 10000 % 10 && ok == 0) {
                System.out.println(i);
                ok = 1;
            }
            if(i % 10 == i / 10000000 && i % 10 == i / 100000 % 10 && i % 10 == i / 100 % 10 &&
               i / 10 % 10 == i / 1000 % 10  && i / 10 % 10 == i / 10000 % 10 && i / 10 % 10 == i / 1000000 % 10) {
                System.out.println(i);
                break;
            }
        }
    }
}