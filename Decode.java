import java.util.Scanner;

public class Decode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the encoded string: ");
        String s = scanner.nextLine();
        Solution solution = new Solution();
        int result = solution.numDecodings(s);
        System.out.println("Number of ways to decode: " + result);
    }
}
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int prev = 1, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = curr;
            curr = (s.charAt(i) == '0') ? 0 : curr;
            int twoDigit = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev;
            }
            prev = temp;
        }
        return curr;
    }
}
