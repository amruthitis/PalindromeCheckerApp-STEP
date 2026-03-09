```java
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

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

    public static void checkPalindromeStack(String word) {
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

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

    public static void checkPalindromeQueueStack(String word) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        boolean isPalindrome = true;

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

    public static void checkPalindromeDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

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

    public static void checkPalindromeLinkedList(String word) {
        Node head = null;
        Node tail = null;

        for (char c : word.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome (Linked List)");
        } else {
            System.out.println(word + " is not a Palindrome (Linked List)");
        }
    }

    public static boolean recursiveCheck(String word, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }

        return recursiveCheck(word, start + 1, end - 1);
    }

    public static void checkPalindromeRecursive(String word) {
        boolean isPalindrome = recursiveCheck(word, 0, word.length() - 1);

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome (Recursion)");
        } else {
            System.out.println(word + " is not a Palindrome (Recursion)");
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
        checkPalindromeLinkedList(word);
        checkPalindromeRecursive(word);
    }
}
```
