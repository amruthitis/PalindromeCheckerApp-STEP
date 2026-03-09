```java
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    public static boolean checkBruteForce(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkReverse(String word) {
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }
        return word.equals(reversed);
    }

    public static boolean checkStack(String word) {
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

    public static boolean checkDeque(String word) {
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

    public static void main(String[] args) {

        String word = "madam";

        long start1 = System.nanoTime();
        boolean r1 = checkBruteForce(word);
        long end1 = System.nanoTime();
        System.out.println("Brute Force Result: " + r1);
        System.out.println("Brute Force Time: " + (end1 - start1) + " ns");

        long start2 = System.nanoTime();
        boolean r2 = checkReverse(word);
        long end2 = System.nanoTime();
        System.out.println("Reverse Result: " + r2);
        System.out.println("Reverse Time: " + (end2 - start2) + " ns");

        long start3 = System.nanoTime();
        boolean r3 = checkStack(word);
        long end3 = System.nanoTime();
        System.out.println("Stack Result: " + r3);
        System.out.println("Stack Time: " + (end3 - start3) + " ns");

        long start4 = System.nanoTime();
        boolean r4 = checkDeque(word);
        long end4 = System.nanoTime();
        System.out.println("Deque Result: " + r4);
        System.out.println("Deque Time: " + (end4 - start4) + " ns");
    }
}
```
