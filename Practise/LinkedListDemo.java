import java.util.LinkedList;
import java.util.ListIterator;

class Order {
    int orderId;
    String item;

    Order(int orderId, String item) {
        this.orderId = orderId;
        this.item = item;
    }

    @Override
    public String toString() {
        return orderId + " - " + item;
    }
}

public class LinkedListDemo {

    public static void main(String[] args) {

        /* Creating LinkedList*/ 
        LinkedList<Order> orders = new LinkedList<>();
        
        /* Adding elements*/
        orders.add(new Order(101, "Laptop"));     // add at end
        orders.addLast(new Order(102, "Phone"));  // add at end
        orders.addFirst(new Order(100, "Tablet"));// add at start

        System.out.println("Orders after adding:");
        System.out.println(orders);
        
        /* Queue operations (Deque)*/
        Order processingOrder = orders.pollFirst(); // remove from front
        System.out.println("\nProcessing order: " + processingOrder);

        Order nextOrder = orders.peekFirst(); // view front without removing
        System.out.println("Next order to process: " + nextOrder);
        
        /* Stack operations*/
        orders.push(new Order(103, "Monitor")); // add to front
        System.out.println("\nAfter push (stack):");
        System.out.println(orders);

        Order lastAction = orders.pop(); // remove from front
        System.out.println("Popped order: " + lastAction);
        
        /* Iteration using Iterator*/
        System.out.println("\nIterating orders:");
        for (Order o : orders) {
            System.out.println(o);
        }
        /*  ListIterator (forward + backward)*/
        System.out.println("\nUsing ListIterator:");
        ListIterator<Order> iterator = orders.listIterator();

        while (iterator.hasNext()) {
            System.out.println("Forward: " + iterator.next());
        }

        while (iterator.hasPrevious()) {
            System.out.println("Backward: " + iterator.previous());
        }

        /* Remove specific object*/
        orders.removeIf(order -> order.orderId == 101);
        System.out.println(orders);
        
        /* Utility methods*/
        System.out.println("\nSize: " + orders.size());
        System.out.println("Is empty? " + orders.isEmpty());
       
       
        /* Clear list*/
        orders.clear();
        System.out.println("\nAfter clear:");
        System.out.println("Orders: " + orders);
    }
}
