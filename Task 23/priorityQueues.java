import java.util.PriorityQueue;

public class priorityQueues {

  public static void main(String[] args) {
    // Initialise queues
    PriorityQueue<String> prioQueue1 = new PriorityQueue<String>();
    prioQueue1.offer("George");
    prioQueue1.offer("Jim");
    prioQueue1.offer("John");
    prioQueue1.offer("Blake");
    prioQueue1.offer("Kevin");
    prioQueue1.offer("Micheal");

    PriorityQueue<String> prioQueue2 = new PriorityQueue<String>();
    prioQueue2.offer("George");
    prioQueue2.offer("Katie");
    prioQueue2.offer("Kevin");
    prioQueue2.offer("Michelle");
    prioQueue2.offer("Ryan");

    System.out.println("Queue 1: " + prioQueue1);
    System.out.println("Queue 2: " + prioQueue2 + "\n");

    // Testing functions
    System.out.println("Union: " + union(prioQueue1,prioQueue2) + "\n");
    difference(prioQueue1,prioQueue2);
    System.out.println("\nIntersection: " + intersection(prioQueue1,prioQueue2));

  }

  // Determine the union of 2 priority queues.
  public static PriorityQueue<String> union(PriorityQueue<String> prioQueue1, PriorityQueue<String> prioQueue2) {
    PriorityQueue<String> union = new PriorityQueue<String>(prioQueue1);
    union.addAll(prioQueue2);
    return union;
  }

  // Determine the difference of 2 priority queues.
  public static void difference(PriorityQueue<String> prioQueue1, PriorityQueue<String> prioQueue2) {

    PriorityQueue<String> firstDifference = new PriorityQueue<String>(prioQueue1);
    firstDifference.removeAll(prioQueue2);
    System.out.println("Queue1 difference Queue2: " + firstDifference);

    PriorityQueue<String> secondDifference = new PriorityQueue<String>(prioQueue2);
    secondDifference.removeAll(prioQueue1);
    System.out.println("Queue1 difference Queue2: " + secondDifference);
  }

  // Determine the intersection of 2 priority queues.
  public static PriorityQueue<String> intersection(PriorityQueue<String> prioQueue1,
                                                   PriorityQueue<String> prioQueue2) {

    PriorityQueue<String> intersect = new PriorityQueue<>(prioQueue1);
    intersect.retainAll(prioQueue2);
    return intersect;
  }
}
