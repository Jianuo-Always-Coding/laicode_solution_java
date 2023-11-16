public class Solution {

    static class Node {
        Node prev;
        Node next;
        char ch;

        Node(char ch) {
            this.ch = ch;
        }
    }

    private Node head;
    private Node tail;
    private Map<Character, Node> map;

    public Solution() {
        // Initialize the class.
        this.map = new HashMap<Character, Node>();
    }

    public void read(char ch) {
        // Implement this method here.
        if (map.containsKey(ch)) {
            if (map.get(ch) != null) {
                remove(map.get(ch));
                map.put(ch, null);
            }
        } else {
            Node newNode = new Node(ch);
            map.put(ch, newNode);
            append(newNode);
        }
        return;
    }

    public Character firstNonRepeating() {
        // Implement this method here.
        if (head == null) {
            return null;
        }
        return head.ch;
    }

    private void remove(Node node) {
        if (head == node && tail == node) {
            head = null;
            tail = null;
        } else if (head == node) {
            head = node.next;
            head.prev = null;
        } else if (tail == node) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return;
    }

    private void append(Node newNode) {
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
        return;
    }
}
