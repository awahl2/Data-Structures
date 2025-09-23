
// prof. lehman
// fall 2025
//
// sample code for virtual class day
// demonstrates using StackCharArray and QueueCharArray classes
//
// Note: Code requires StackCharArray.java and QueueCharArray.java
//
//
// Place all files in same folder
//
// If compiling and running from command line
//
//    javac *.java
//    java DemoStackQueue
//

class DemoStackQueue {

    public static void main(String[] args) {

        // *** Part 1 - reverse stack
        //

        String word = "Anna wahl"; // *** change text to be your name ie. Norman Forester

        StackCharArray st = new StackCharArray(100);

        // add all leters from word to stack
        int i = 0;
        while (i < word.length()) {
            st.push(word.charAt(i));
            i++;
        }

        System.out.println(st);

        // to reverse stack
        // place all items from stack into queue
        // place all items in queue into stack
        QueueCharArray qu = new QueueCharArray(100); // ** notice size change

        while (st.empty() == false) {
            qu.add(st.top());
            st.pop();
        }

        while (qu.empty() == false) {
            st.push(qu.front());
            qu.remove();
        }

        System.out.println(st); // stack now reversed

        // clear stack
        st = new StackCharArray(100);

        // *** Part 2 - reverse queue
        //

        // add all leters from word to queue
        int j = 0;
        while (j < word.length()) {
            qu.add(word.charAt(j));
            j++;
        }

        System.out.println(qu);

        // to reverse queue
        // place all items from queue into stack
        // place all items from stack back into queue
        while (qu.empty() == false) {
            st.push(qu.front());
            qu.remove();
        }

        while (st.empty() == false) {
            qu.add(st.top());
            st.pop();
        }

        System.out.println(qu); // stack now reversed

    }// main

}// class