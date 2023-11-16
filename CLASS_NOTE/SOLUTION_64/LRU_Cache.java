public class Solution<K, V> {
  // limit is the max capacity of the cache
  static class Node<K, V> {
    Node<K, V> prev;
    Node<K, V> next;
    K key;
    V value;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }

    void update(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  private Map<K, Node<K, V>> map;
  private final int limit;
  private Node<K, V> head; // head is the oldest
  private Node<K, V> tail; // tail is the newest

  public Solution(int limit) {
    this.limit = limit;
    this.map = new HashMap<K, Node<K, V>>();
  }
  
  public void set(K key, V value) {
    if (map.containsKey(key)) {
      Node<K, V> node = map.get(key);
      node.value = value;
      map.put(key, node);
      remove(node);
      append(node);
    } else {
      int number = map.size();
      if (number == limit) {
        remove(head);
      }
      Node<K, V> newNode = new Node<K ,V>(key, value);
      append(newNode);
    } 
    return ;
  }
  
  public V get(K key) {
    Node<K ,V> node = map.get(key);
    if (node == null) {
      return null;
    }
    remove(node);
    append(node);
    return node.value;
  }

  // only focus on remove
  private void remove(Node<K, V> node) {
    map.remove(node.key);
    if (head == node && tail == node) {
      tail = null;
      head = null;
      return ;
    } else if (head == node) {
      head = head.next;
      head.prev = null;
    } else if (tail == node) {
      tail = tail.prev;
      tail.next = null;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    return ;
  }

  // Only focus on append
  private void append(Node<K, V> node) {
    map.put(node.key, node);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      node.prev = tail;
      tail = tail.next;
    }
  }
}