import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
            reversed = reversed + word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome (String Reverse)");
        } else {
            System.out.println(word + " is not a Palindrome (String Reverse)");
        }
    }

    // UC4: Character Array Based Palindrome Check
    public static void checkPalindromeCharArray(String word) {
        char[] chars = word.toCharArray();
        boolean isPalindrome = true;
        int length = chars.length;

        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome (Char Array)");
        } else {
            System.out.println(word + " is not a Palindrome (Char Array)");
        }
    }

    // UC5: Stack Based Palindrome Checker
    public static void checkPalindromeStack(String word) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        // Pop characters to build reversed string
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome (Stack)");
        } else {
            System.out.println(word + " is not a Palindrome (Stack)");
        }
    }

    // UC6: Queue + Stack Based Palindrome Check
    public static void checkPalindromeQueueStack(String word) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Push and enqueue all characters
        for (char c : word.toCharArray()) {
            stack.push(c);   // Stack  → LIFO → gives reverse order
            queue.add(c);    // Queue  → FIFO → gives original order
        }

        boolean isPalindrome = true;

        // Compare stack (reverse) with queue (original)
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome (Queue + Stack)");
        } else {
            System.out.println(word + " is not a Palindrome (Queue + Stack)");
        }
    }

    // UC7: Deque Based Optimized Palindrome Checker
    public static void checkPalindromeDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();

        // Add all characters to deque
        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        // Compare front and back simultaneously
        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome (Deque)");
        } else {
            System.out.println(word + " is not a Palindrome (Deque)");
        }
    }

    public static void main(String[] args) {
        String word = "madam";

        checkPalindromeBruteForce(word);
        checkPalindromeByReverse(word);
        checkPalindromeCharArray(word);
        checkPalindromeStack(word);
        checkPalindromeQueueStack(word);
        checkPalindromeDeque(word);
    }
}