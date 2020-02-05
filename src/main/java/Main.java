import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;

import com.google.gson.*;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

//class TreeNode {
//    public String Name;
//    public TreeNode[] children;
//}

public class Main {

    /** Arrays ***/

    // 2D: int[][] twoD_arr = new int[10][20];

    /*
    public class MyClass {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    for (int i = 0; i < cars.size(); i++) {
      System.out.println(cars.get(i));
    }
  }
}

List<Integer> listNumbers = new ArrayList<>();
List<String> linkedWords = new LinkedList<>();


ArrayList al = new ArrayList();
al.add(3);
al.add(2);
al.add(1);
al.add(4);
al.add(5);
al.add(6);
al.add(6);
Iterator iter1 = al.iterator();
while(iter1.hasNext()){
System.out.println(iter1.next());
}

LinkedList ll = new LinkedList();
ll.add(3);
ll.add(2);
ll.add(1);
ll.add(4);
ll.add(5);
ll.add(6);
ll.add(6);
Iterator iter2 = al.iterator();
while(iter2.hasNext()){
System.out.println(iter2.next());
}
     */

    /**** Hashmaps ***/
    /*
    HashMapis implemented as a hash table, and there is no ordering on keys or values.
    TreeMap is implemented based on red-black tree structure, and it is ordered by the key. --> PRECISA DE COMPARABLE
    LinkedHashMap preserves the insertion order
    Hashtable  is synchronized in contrast to HashMap -> overhead for synchronization
    */

    /*

    ATENCAO:

    1) If two objects are equal, then they must have the same hash code.
    2) If two objects have the same hash code, they may or may not be equal.
     */


    /**** hashmap
     *
     *
     * public static void main(String[] args) {
     * 		HashMap<Dog, Integer> hashMap = new HashMap<Dog, Integer>();
     * 		Dog d1 = new Dog("red");
     * 		Dog d2 = new Dog("black");
     * 		Dog d3 = new Dog("white");
     * 		Dog d4 = new Dog("white");
     *
     * 		hashMap.put(d1, 10);
     * 		hashMap.put(d2, 15);
     * 		hashMap.put(d3, 5);
     * 		hashMap.put(d4, 20);
     *
     * 		//print size
     * 		System.out.println(hashMap.size());
     *
     * 		//loop HashMap
     * 		for (Entry<Dog, Integer> entry : hashMap.entrySet()) {
     * 			System.out.println(entry.getKey().toString() + " - " + entry.getValue());
     *                }* 	}
     */

    /* TREEMAPS */

    /*

    class Dog implements Comparable<Dog>{
	String color;
	int size;

	Dog(String c, int s) {
		color = c;
		size = s;
	}

	public String toString(){
		return color + " dog";
	}

	@Override
	public int compareTo(Dog o) {
		return  o.size - this.size;
	}
}

public class TestTreeMap {
	public static void main(String[] args) {
		Dog d1 = new Dog("red", 30);
		Dog d2 = new Dog("black", 20);
		Dog d3 = new Dog("white", 10);
		Dog d4 = new Dog("white", 10);

		TreeMap<Dog, Integer> treeMap = new TreeMap<Dog, Integer>();
		treeMap.put(d1, 10);
		treeMap.put(d2, 15);
		treeMap.put(d3, 5);
		treeMap.put(d4, 20);

		for (Entry<Dog, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}

     */



    /*** Graphs ***/

    public static class Graph {
        List<List<Integer>> adjLst;
        int size;

        public Graph(int size) {
            adjLst = new ArrayList<>();
            this.size = size;
            while (size-- > 0)//Initialize the adjancency list.
                adjLst.add(new ArrayList<Integer>());
        }

        public void addEdge(int first, int second) {
            adjLst.get(first).add(second);
            adjLst.get(second).add(first);
            // For undirected graph, you gotta add edges from both sides.
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            Arrays.fill(distances, -1); // O(n) space.
            Queue<Integer> que = new LinkedList<>();

            que.add(startId); // Initialize queue.
            distances[startId] = 0;
            HashSet<Integer> seen = new HashSet<>(); //O(n) space. Could be further optimized. I leave it to you to optimize it.

            seen.add(startId);
            while (!que.isEmpty()) { // Standard BFS loop.
                Integer curr = que.poll();
                for (int node : adjLst.get(curr)) {
                    if (!seen.contains(node)) {
                        que.offer(node);
                        // Right place to add the visited set.
                        seen.add(node);
                        // keep on increasing distance level by level.
                        distances[node] = distances[curr] + 6;
                    }
                }
            }
            return distances;
        }
    }


    /****/
    /* Trees */

    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            //visit(node);
            inOrderTraversal(node.right);
        }
    }

    void preOrderTraversal(Node node) {
        if (node != null) {
            //visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            //visit(node);
        }
    }

    /****/

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

    /*****/
    static final String BASEURL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";

    static class Movie {

        String poster;
        String title;
        String type;
        int year;
        String imdbID;

        Movie(String poster, String title, String type, int year, String imdbID) {
            this.poster = poster;
            this.title = title;
            this.type = type;
            this.imdbID = imdbID;
        }

        Movie() {
            this.poster = "";
            this.title = "";
            this.type = "";
            this.imdbID = "";
        }

    }

    /***
     * ParseMovie method: transform a JsonObject to a Movie instance
     *
     *
     * @param movie JsonObject received from Rest Call
     * @return Movie instance
     */
    static Movie parseMovie(JsonObject movie) {
        Movie film = new Movie();

        try {
            film.poster = movie.get("Poster").getAsString();
        } catch (Exception e) {
            film.poster = "";
        }
        try {
            film.title = movie.get("Title").getAsString();
        } catch (Exception e) {
            film.title = "";
        }
        try {
            film.type = movie.get("Type").getAsString();
        } catch (Exception e) {
            film.type = "";
        }
        try {
            film.imdbID = movie.get("imdbID").getAsString();
        } catch (Exception e) {
            film.imdbID = "";
        }
        try {
            film.year = movie.get("Year").getAsInt();
        } catch (Exception e) {
            film.year = 0;
        }

        return film;
    }

    /***
     * restMovieCall makes a REST get call to example API
     *
     * @param substr  name to be searched (eg: spiderman)
     * @param page send 1 for first call
     * @return API content
     */
    static StringBuffer restMovieCall(String substr, int page) {

        String urlString = BASEURL + substr;
        if (page > 1) {
            urlString = urlString + "&page=" + page;
        }
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            con.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        try {
            int status = con.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputLine;
        StringBuffer content = new StringBuffer();
        try {
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;

    }

    /***
     * getMovies retrieves all movies from API and return a String array with the titles
     *
     *
     * @param substr Title of the movie being search
     * @return String array with titles
     */
    static List<Movie> getMovies(String substr) {

        List<Movie> myMovies = new ArrayList<>();


        JsonParser parser = new JsonParser();
        JsonObject o;
        JsonArray myData;
        int totalPages = 2;
        int total = 1;
        int page = 1;

        while (page <= totalPages) {
            o = parser.parse(String.valueOf(restMovieCall(substr, page))).getAsJsonObject();
            ;
            page = o.get("page").getAsInt();
            totalPages = o.get("total_pages").getAsInt();
            myData = o.getAsJsonArray("data");
            for (int i = 0; i < myData.size(); i++) {
                Movie newMovie;
                newMovie = parseMovie(myData.get(i).getAsJsonObject());
                myMovies.add(newMovie);

            }
            page++;

        }

        return myMovies;

    }

    static String[] getMovieTitles(String substr) {


        List<Movie> myMovies = new ArrayList<>();
        myMovies = getMovies(substr);
        String[] titles = new String[myMovies.size()];

        int aux = 0;


        for (Movie movie : myMovies) {
            titles[aux] = movie.title;

            aux = aux + 1;
        }

        Arrays.sort(titles);
        return titles;

    }


    /***********************/

    public static void QueueAndStack() {
        Queue<Character> myQueue = new LinkedList<>();
        Stack<Character> myStack = new Stack<>();

        //STACK - PUSH AND POP
        char a = Character.valueOf('b');
        myStack.push(a);
        System.out.println(myStack.pop());

        //QUEUE - ADD AND POLL
        myQueue.add(a);
        System.out.println(myQueue.poll());

    }

    //Integer MaxHeap
    static class MaxHeap {
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
                return Integer.MAX_VALUE;
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
    static class MinHeap {
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

    public static void main(String[] args) throws IOException {

        Solution.generalizedGCD(2, new int[]{2, 9});

//        int[] input = { 1,0,0,0,0,1,0,0};
//        int days = 1;
//
//        List<Integer> myList = Solution.cellCompete(input,days);

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> css = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            String[] cssRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//            List<Integer> cssRowItems = new ArrayList<>();
//
//            for (int j = 0; j < 2; j++) {
//                int cssItem = Integer.parseInt(cssRowTempItems[j]);
//                cssRowItems.add(cssItem);
//            }
//
//            css.add(cssRowItems);
//        }
//
//        int m = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> customers = new ArrayList<>();
//
//        for (int i = 0; i < m; i++) {
//            String[] customersRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//            List<Integer> customersRowItems = new ArrayList<>();
//
//            for (int j = 0; j < 2; j++) {
//                int customersItem = Integer.parseInt(customersRowTempItems[j]);
//                customersRowItems.add(customersItem);
//            }
//
//            customers.add(customersRowItems);
//        }
//
//        int vacant_cssCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String[] vacant_cssItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        List<Integer> vacant_css = new ArrayList<>();
//
//        for (int i = 0; i < vacant_cssCount; i++) {
//            int vacant_cssItem = Integer.parseInt(vacant_cssItems[i]);
//            vacant_css.add(vacant_cssItem);
//        }
//
//        //int cs_distribution = csRush(n, m, css, customers, vacant_css);
//
//        bufferedReader.close();

    }


}
