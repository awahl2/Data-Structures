/*
 * review.java
 * exam #1 Review Fall 2025
 * lehman
 */
public class review {

    public static void main(String[] args) {

        // #1 - data class
        data alice = new data(); // instance alice using default constructor
        data bob = new data(false, 12); // instance bob using alternate constructor

        // see if there are any command line arguments ie. java reivew 25
        if (args.length >= 1) {
            int v = Integer.parseInt(args[0]); // get first argument ie. 25
            alice.setYears(v);
        }

        System.out.println(alice);
        System.out.println(alice.toString());
        System.out.println(bob);

        alice.setYears(20);
        alice.setFound(true);
        System.out.println(alice);

        System.out.println(alice.getYears());

        System.out.println();

        // #2 - test recursive function f with two arguments
        System.out.println(f(9, 13));
        System.out.println();
        System.out.println(f(10, 9));
        System.out.println();

        // #3 - test recursive function f with three arguments
        f(12, 8, 10);
        System.out.println();
        f(6, 4, 2);
        System.out.println();

        // #4 - test recursive count function
        System.out.println(count("abba"));
        int temp = count("abba");
        System.out.println("count = " + temp);
        System.out.println();
        System.out.println(count("aabbaa"));
        System.out.println(count("nope"));
        System.out.println();

        System.out.println(countAlt("aabbaa"));
        System.out.println(countAlt("nope"));
        System.out.println();
        System.out.println();

        // Stacks - see implementation file StackCharArray.java
        StackCharArray s = new StackCharArray();

        s.push('x');
        s.push('y');
        System.out.println(s);
        System.out.println("top = " + s.top());
        System.out.println();

        s.push('z');
        s.pop();
        s.pop();

        System.out.println(s);
        System.out.println("top = " + s.top());
        System.out.println();

        // Stacks - see implementation file QueueCharArray.java
        QueueCharArray q = new QueueCharArray();
        q.add('A');
        q.add('B');
        q.add('C');
        q.add('D');

        System.out.println(q);
        System.out.println();

        int count = 0;
        while (count < 4) {
            System.out.print(q.front() + " is front rn");
            q.add(q.front());
            q.remove();
            count++;
        }

        System.out.println();
        System.out.println(q);
        System.out.println();

        // to reverse a queue, remove all values and place in stack,
        // then remove all stack items and place back in queue

        // to reverse a stack, remove all values and place in queue,
        // then remove all queue items and place back in stack

    }// main

    // sample recursive function
    public static int f(int a, int b) {
        System.out.println("f: " + a + " " + b); // use for debug only

        if (a % 2 != 0)
            return f(a - 1, b);
        else if (b % 2 != 0)
            return f(a, b - 1);
        else if (a > b)
            return a; // base case
        else
            return b; // base case
    }

    // sample recursive function
    public static void f(int a, int b, int c) {
        System.out.println("f: " + a + " " + b + " " + c);// use for debug only
        if (a > b)
            f(b, a, c);

        else if (b > c)
            f(a, c, b);

        else
            System.out.println(a + ", " + b + ", " + c); // base case
    }

    // recursive function to count occurrences of 'a' in string s
    public static int count(String s) {

        System.out.println("s = " + s);
        if (s.length() == 0) // base case
            return 0;
        else if (s.charAt(0) == 'a')
            return 1 + count(s.substring(1));
        else
            return 0 + count(s.substring(1));
    }

    // alternate approach
    public static int countAlt(String s) {
        return countHelper(s, 0); // use recursive helper
    }

    // recursive helper function
    public static int countHelper(String s, int i) {
        if (i == s.length()) // base case
            return 0;
        else if (s.charAt(i) == 'a')
            return 1 + countHelper(s, i + 1);
        else
            return 0 + countHelper(s, i + 1);
    }

}// class