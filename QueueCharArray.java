
/*
 * QueueCharArray.java *** sample solution ***
 * fall 2025
 * prof. lehman
 * 
 * Queue approach has first and last point
 * to first and last elements in array.
 * The variable size is used to denote
 * an empty vs. full queue
 */
public class QueueCharArray {

    // data
    char data[];
    int front;
    int back;
    int size;
    int MAX;

    // default constructor
    public QueueCharArray() {
        MAX = 5;
        data = new char[MAX];
        front = 0;
        back = -1;
        size = 0;
    }

    // alternate constructor
    public QueueCharArray(int max) {
        MAX = max;
        data = new char[max];
        front = 0;
        back = -1;
        size = 0;
    }

    // delete all items in queue
    public void clear() {
        front = 0;
        back = -1;
        size = 0;
    }

    // add to back of queue
    public void add(char v) {
        if (!full()) {
            back = (back + 1) % MAX;
            data[back] = v;
            size++;
        }
    }

    // see if queue is empty
    public boolean empty() {
        return size == 0;
    }

    // see if queue is full
    public boolean full() {
        return size == MAX;
    }

    // return element from front of queue
    public char front() {
        if (!empty())
            return data[front];
        else
            return '?';
    }

    public char back() {
        if (size > 0)
            return data[back];
        else
            return '?';
    }

    // remove element from front of queue
    public boolean remove() {
        if (!empty()) {
            front = (front + 1) % MAX;
            size--;
            return true; // success
        } else
            return false; // error condition
    }

    // return size
    public int size() {
        return size;
    }

    // display queue with ASCII version
    public String toString() {
        // create top and bottom based on queue size +-------------+
        String side = "+---+\n";
        if (size > 0) {
            side = "+";
            for (int x = 0; x < size; x++)
                side += "--";
            side += "+\n ";
        }

        String result = side;
        boolean first = true;

        int count = this.size();
        int i = front;

        while (count > 0) {
            if (first) {
                result = result + data[i];
                first = false;
            } else
                result = result + "," + data[i];
            i = i + 1;
            if (i == MAX)
                i = 0;

            count--;
        }

        result = result + "\n" + side;
        return result;
    }

}// class