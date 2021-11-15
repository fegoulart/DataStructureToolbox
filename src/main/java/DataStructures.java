import java.util.*;

class Dog implements Comparable<Dog> {
    String color;
    int weight;

    Dog(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public int compareTo(Dog o) {
        // 0 = equals
        // negative  = current less than other
        // positive = current greater than other
        return this.weight - o.weight;
    }
}

public class DataStructures {
    int[][] twoDArray = new int[10][20];
    List<Integer> listNumbers = new ArrayList<>();
    List<String> linkedWords = new LinkedList<>();
    HashMap<Dog, Integer> hashMap = new HashMap<Dog, Integer>();

    /**** Hashmaps ***/
    /*
    HashMaps implemented as a hash table, and there is no ordering on keys or values.
    TreeMap is implemented based on red-black tree structure, and it is ordered by the key. --> PRECISA DE COMPARABLE
    LinkedHashMap preserves the insertion order
    Hashtable  is synchronized in contrast to HashMap -> overhead for synchronization
    */
    public void arrayListOperations(List<String> mList) {
        mList.add("Volvo");
        String rootItem = mList.get(0);
        System.out.println(rootItem);
        Iterator mIterator = mList.iterator();
        while (mIterator.hasNext()) {
            System.out.println(mIterator.next());
        }
    }

    public void hashMapOperations(HashMap<Dog, Integer> item) {
        Dog d1 = new Dog("red", 25);
        item.put(d1, 10);
        int itemSize = item.size();
        System.out.println(itemSize);
        for (Map.Entry<Dog, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue());
        }
    }

    public void treeMapOperations() {
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 20);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("white", 10);

        TreeMap<Dog, Integer> treeMap = new TreeMap<Dog, Integer>();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);

        for (Map.Entry<Dog, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

    public static void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            //visit(node);
            inOrderTraversal(node.right);
        }
    }

    public static void preOrderTraversal(Node node) {
        if (node != null) {
            //visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            //visit(node);
        }
    }

    public static int getHeight(Node root) {

        if (root == null) {
            return -1;
        }
        if (root.right == null && root.left == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}

class TreeNode {
    public String Name;
    public TreeNode[] children;
}

class MaxHeap {
    int[] harr;
    int heap_size;
    int capacity;

    public MaxHeap(int a[], int size) {
        heap_size = size;
        capacity = size;
        harr = a;
        int i = (heap_size - 1) / 2;
        while (i >= 0) {
            MaxHeapify(i);
            i--;
        }
    }

    void MaxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heap_size && harr[l] > harr[i])
            largest = l;
        if (r < heap_size && harr[r] > harr[largest])
            largest = r;
        if (largest != i) {
            swap(i, largest);
            MaxHeapify(largest);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    int extractMax() {
        if (heap_size <= 0)
            return Integer.MIN_VALUE;
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }

        int root = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MaxHeapify(0);

        return root;
    }

    void insertKey(int k) {
        if (heap_size == capacity) {
            System.out.println("Overflow: Could not insertKey");
            return;
        }

        heap_size++;
        int i = heap_size - 1;
        harr[i] = k;

        while (i != 0 && harr[parent(i)] < harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    boolean isSizeOne() {
        return (heap_size == 1);
    }

    void swap(int x, int y) {
        int temp = harr[x];
        harr[x] = harr[y];
        harr[y] = temp;
    }

}

//Integer MinHeap
class MinHeap {
    int[] harr;
    int heap_size;
    int capacity;

    public MinHeap(int a[], int size) {
        heap_size = size;
        capacity = size;
        harr = a;
        int i = (heap_size - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i])
            smallest = l;
        if (r < heap_size && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            MinHeapify(smallest);
        }
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    int extractMin() {
        if (heap_size <= 0)
            return Integer.MAX_VALUE;
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }

        int root = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);

        return root;
    }

    void insertKey(int k) {
        if (heap_size == capacity) {
            System.out.println("Overflow: Could not insertKey");
            return;
        }

        heap_size++;
        int i = heap_size - 1;
        harr[i] = k;

        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    boolean isSizeOne() {
        return (heap_size == 1);
    }

    void swap(int x, int y) {
        int temp = harr[x];
        harr[x] = harr[y];
        harr[y] = temp;
    }

}

