public class testQueue {

    public static void main(String[] args) {

        QueueCharArray q = new QueueCharArray(); // default constructor

        q.add('a');
        q.add('b');
        q.add('c');
        q.add('d');
        q.add('e');
        System.out.println("size: " + q.size()); // 5

        q.add('f');// no error shown
        System.out.println("size: " + q.size()); // 5

        q.remove();
        System.out.println("size: " + q.size()); // 4
        q.add('f');

        q.remove();
        System.out.println("size: " + q.size()); // 4

        q.add('f');
        System.out.println("size: " + q.size()); // 5

        System.out.println(q.front()); // c
        System.out.println("size: " + q.size());// 5

        q.remove();

        System.out.println(q.front());// d
        System.out.println("size: " + q.size()); // 4

        q.clear();

        System.out.println();
        System.out.println(q.front()); // ? denotes empty
        System.out.println(q.size()); // 0

        QueueCharArray b = new QueueCharArray(100);
        b.add('a');
        b.add('b');
        b.add('c');
        b.add('d');
        b.add('e');

        System.out.println();
        System.out.println(b.front()); // a
        System.out.println("size: " + b.size()); // 5

        while (!b.empty()) {
            System.out.println(b.front()); // a b c d e
            b.remove();
        }

        System.out.println();
        System.out.println(q.front()); // ? denotes empty
        System.out.println("size: " + q.size()); // 0

        // Additional test case
        QueueCharArray g = new QueueCharArray(100);
        g.add('g');
        g.add('h');
        g.add('i');
        g.add('j');
        g.add('k');

        System.out.println();
        System.out.println(g.front()); // g
        System.out.println("size: " + g.size()); // 5

        while (!g.empty()) {
            System.out.println(g.front()); // g h i j k
            g.remove();
        }

        System.out.println();
        System.out.println(g.front()); // ? denotes empty
        System.out.println("size: " + g.size()); // 0
    }// main

}// class