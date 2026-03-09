import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

interface PalindromeStrategy {
    boolean checkPalindrome(String word);
}

class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String word) {
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        return word.equals(reversed);
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String word) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }

        return true;
    }
}

class PalindromeChecker {

    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String word) {
        return strategy.checkPalindrome(word);
    }
}

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        PalindromeChecker checker1 = new PalindromeChecker(new StackStrategy());
        boolean result1 = checker1.check(word);

        if (result1) {
            System.out.println(word + " is a Palindrome (Stack Strategy)");
        } else {
            System.out.println(word + " is not a Palindrome (Stack Strategy)");
        }

        PalindromeChecker checker2 = new PalindromeChecker(new DequeStrategy());
        boolean result2 = checker2.check(word);

        if (result2) {
            System.out.println(word + " is a Palindrome (Deque Strategy)");
        } else {
            System.out.println(word + " is not a Palindrome (Deque Strategy)");
        }
    }
}