/// palindrome.java 
//
// fall 2025
// lab4b assignment
//
// Anna Wahl
//
// Use for paindrome.java

public class lab4b {

    public static void main(String[] args) {

        // single call to test
        System.out.println(palindrome("racecar")); // true
        System.out.println(palindrome("sass")); // false

        // uncomment to test additional words

        String words[] = { "a", "racecar", "noon", "hannah", "abcba", "abbca",
                "nope", "ab" };

        for (int i = 0; i < words.length; i++) {

            if (palindrome(words[i]) == true)
                System.out.println(words[i] + " IS a palindrome");
            else
                System.out.println(words[i] + " IS NOT a palindrome");
        }

    }// main

    // *** use StackCharArray and QueueCharArray here to determine Palindrome
    private static boolean palindrome(String word) {

        // assume status is true
        boolean status = true;

        // initialize stack and queue
        StackCharArray st = new StackCharArray(100);
        QueueCharArray qu = new QueueCharArray(100);

        // Add letters to stack and queue
        int i = 0;
        while (i < word.length()) {
            st.push(word.charAt(i));
            qu.add(word.charAt(i));
            i++;
        }

        // Check for palindrome
        while (st.size() != 0 && status == true) {
            // If not equal, stop while + return false
            if (st.top() != qu.front()) {
                status = false;
            }
            // Else, continue
            else {
                st.pop();
                qu.remove();
            }
        }

        // Return
        return status;

    }// palindrome method

}// class
