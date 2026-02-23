import java.util.Scanner;

public class PalindromeCheckerApp {
    public static boolean checkPalindrome(String n){
        n = n.toLowerCase();
        int i=0, j= n.length() - 1;
        while (i<j){
            if (n.charAt(i) != n.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("------ Welcome to Palindrome Checker App --------");
        System.out.println("Version : 1.0");
        System.out.println("System Initialised Successfully");

        Scanner scanner = new Scanner(System.in);
        String name =  scanner.nextLine();
        System.out.println(checkPalindrome(name));
    }
}

