import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUnit 5 Example")
class ToolBoxTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test methods");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test method");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all test methods");
    }

    @Test
    public void testMinHeap() {
        int[] myNums = { 7, 2,2, 1,1,8,5,0,3,4,4,5,6,10,9,10};
        Main.MinHeap myMinHeap = new Main.MinHeap(myNums,myNums.length);
        assertEquals(0, myMinHeap.extractMin());
        assertEquals(1, myMinHeap.extractMin());
        assertEquals(1, myMinHeap.extractMin());
    }

    @Test
    public void testMaxHeap() {
        int[] myNums = { 7, 2,2, 1,1,8,5,0,3,4,4,5,6,10,9,10};
        Main.MaxHeap myMaxHeap = new Main.MaxHeap(myNums,myNums.length);
        assertEquals(10, myMaxHeap.extractMax());
        assertEquals(10, myMaxHeap.extractMax());
        assertEquals(9, myMaxHeap.extractMax());
        assertEquals(8, myMaxHeap.extractMax());
    }
}
