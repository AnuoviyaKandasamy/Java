import java.util.Scanner;

public class MinFrogsSolver {
    public static int minNumberOfFrogs(String croakOfFrogs) {
        int c=0,r=0,o=0,a=0,k=0;
        int minFrogs=0, frogs=0;

        for(char ch: croakOfFrogs.toCharArray()){
            if(ch=='c') {c++; frogs++;}
            else if(ch=='r') {
                r++;
                if(--c < 0) 
                    return -1;
            }
            else if(ch=='o') {
                o++;
                if(--r < 0) 
                    return -1;
            }
            else if(ch=='a') {
                a++; 
                if(--o < 0)
                    return -1;
            }
            else if(ch=='k') {
                k++;
                if(--a < 0) return -1;
                minFrogs = Math.max(minFrogs,frogs);
                frogs--;}
            else return -1;
        }
        if(c > 0 || r > 0 || o > 0 || a > 0) return -1;
        return minFrogs;
    }

    static void main(String[] args) {
        System.out.println("Enter the String:");
        Scanner sc = new Scanner(System.in);
        String cf = sc.next();
        System.out.println(minNumberOfFrogs(cf));
    }
}
