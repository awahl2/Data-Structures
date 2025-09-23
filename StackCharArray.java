
//StackCharArray.java
//dr. lehman
//fall 2025
//class to implement stack ADT with array
//

public class StackCharArray {

    // data
    private char data[];
    private int top;
    private int MAX;
    private int size;

    // methods

    /**
     * create empty stack with max size 5
     */
    public StackCharArray() {
        MAX = 5;
        data = new char[MAX];
        top = data.length;
        size = 0;
    }

    /**
     * create stack with max size m
     * 
     * @param m max size of array
     */
    public StackCharArray(int m) {
        MAX = m;
        data = new char[MAX];
        top = data.length;
        size = 0;
    }

    /**
     * add char to stack
     * 
     * @param v char to add
     */
    public void push(char v) {
        if (!full()) {
            top--;
            data[top] = v;
            size++;
        }
    }

    /**
     * returns last item added to stack (does not remove item)
     * or '?' if stack is empty
     * 
     * @return top item or '?' if empty
     */
    public char top() {
        if (!empty())
            return data[top];
        else
            return '?';
    }

    /**
     * remove last item added to stack
     */
    public void pop() {
        if (!empty()) {
            top++;
            size--;
        }
    }

    /**
     * returns empty if not items on status
     * 
     * @return true if stack empty
     */
    public boolean empty() {
        return top == MAX;
    }

    /**
     * returns true if size equals max
     * 
     * @return true if stack is full
     */
    public boolean full() {
        return top == 0;
    }

    /**
     * returns number of items stored in stack
     * 
     * @return number of items stored in stack
     */
    public int size() {
        return size;
    }

    public String toString() {
        String result = "+   +\n";
        int cur = this.top;
        for (int x = 0; x < this.size(); x++) {
            result = result + "| " + this.data[cur] + " |\n";
            cur++;
        }
        result = result + "+---+\n";
        return result;
    }
}// class