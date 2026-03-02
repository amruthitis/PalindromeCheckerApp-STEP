public class PalindromeCheckerApp {

    // UC2: Brute Force Method
    public static void checkPalindromeBruteForce(String word) {
        boolean isPalindrome = true;
        int length = word.length();

        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome (Brute Force)");
        } else {
            System.out.println(word + " is not a Palindrome (Brute Force)");
        }
    }

    // UC3: String Reverse Method
    public static void checkPalindromeByReverse(String word) {
        String reversed = "";
        int length = word.length();

        for (int i = length - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);  // String Concatenation
        }

        if (word.equals(reversed)) {  // equals() compares content not reference
            System.out.println(word + " is a Palindrome (String Reverse)");
        } else {
            System.out.println(word + " is not a Palindrome (String Reverse)");
        }
    }

    public static void main(String[] args) {
        String word = "madam";

        checkPalindromeBruteForce(word);
        checkPalindromeByReverse(word);
    }
}