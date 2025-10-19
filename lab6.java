import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * lab6.java
 * fall 2025
 * 
 * Anna Wahl
 * 
 * convert String to double using Java Collection Stack and Queue
 */

public class lab6 {
    public static void main(String[] args) {

        // test cases - add x3 additional cases here
        test("6", 6.0);
        test("7,000,000", 7000000.0);
        test(" $$$7 000 000 ", 7000000.0);
        test("$5,678.13 ", 5678.13);
        test("$0.25", 0.25);
        test(" -$.25", -0.25);
        test("-8.96", -8.96);

        // *** add three additional test cases here

    }// main

    private static double toDouble(String a) {

        double answer = 0.0;

        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        boolean decimalFound = false; // *** may or may not use this approach
        boolean negative = false; // *** may or may not use this approach

        // Removes excess spaces
        a = a.trim();

        // Checks for negative
        if (a.contains("-")) {
            negative = true;
        }

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);

            // If digit, excludes anything else
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);

                // Before decimal -> to stack
                if (!decimalFound) {
                    s.push(digit);
                    // System.out.println("stack push: " + digit); // for debugging
                }

                // After decimal -> to queue
                else {
                    q.add(digit);
                    // System.out.println("queue add: " + digit); // for debugging
                }
            }

            // Marks where decimal is
            else if (c == '.') {
                decimalFound = true;
                // System.out.println("decimal found"); // for debugging
            }
        }

        // Gets number from stack
        double place = 1.0; // 1, 10, 100, etc.
        while (!s.isEmpty()) {
            int digit = s.pop();
            answer += digit * place;
            // System.out.println("popped" + digit); // for debugging
            place *= 10;
        }

        // Gets decimal from queue
        double divisor = 10.0;
        while (!q.isEmpty()) {
            int digit = q.remove();
            answer += digit / divisor;
            // System.out.println("queue remove" + digit); // for debugging
            divisor *= 10;
        }

        // Adds negative (if true)
        if (negative) {
            answer = -answer;
        }

        // System.out.println("final answer: " + answer); // for debugging
        return answer;

    }// toDouble

    // test method
    private static void test(String s, double expected) {

        double actual = toDouble(s);

        if (actual == expected)
            System.out.printf("Passed: %15s => %15f\n", s, actual);
        else
            System.out.printf(" Error: %15s => %15f   Expected: %15f\n", s, actual, expected);

    } // test

}// class
