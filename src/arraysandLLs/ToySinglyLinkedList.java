package arraysandLLs;

public class ToySinglyLinkedList {
    public static class Node { // a nested self-referential class
        Character element;
        Node next;

        public Node(Character element, Node next) {
            this.element = element;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Character getElement() {
            return element;
        }
    }

    public static void main(String[] args) {

        Node nodeX = new Node('X', null); // the head

        Node nodeA = new Node('A', null);
        nodeX.setNext(nodeA);

        Node nodeK = new Node('K', null);
        nodeA.setNext(nodeK);

        Node nodeP = new Node('P', null);
        nodeK.setNext(nodeP);

        Node nodeC = new Node('C', null);
        nodeP.setNext(nodeC);

//        Node head = nodeX;
//        Node tail = nodeC;

//        Node nodeT = new Node('T', null); // the tail
//        nodeC.setNext(nodeT);

        // X --> A  --> K --> P  --> C

        // Printing out the linked list created so far using a while-loop
        Node current = nodeX;
        while (current != null) {
            System.out.print(current.getElement());

            if (current.next != null)
                System.out.print(" -> ");

            current = current.next;
        }
    }
}
