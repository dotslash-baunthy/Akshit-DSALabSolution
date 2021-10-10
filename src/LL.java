import java.util.*;

public class LL {

    public static void main(String args[]) {
        // Creating object of the
        // class linked list
        LinkedList<Integer> ll = new LinkedList<Integer>();

        // Adding elements to the linked list
        ll.add(10);
        ll.add(20);
        ll.addLast(15);
        ll.addFirst(66);
        ll.add(2, 999);

        System.out.println(ll);

        ll.remove(ll.indexOf(20));
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);
    }
}