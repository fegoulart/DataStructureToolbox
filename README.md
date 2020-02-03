# Algorithms Toolbox

## Trees

* Tree cannot contain cycles
* Leaf: node without children

### Binary Tree 
* Each node up to 2 children
* __Complete Binary Tree__: every level if fully filled, except for perhaps the lst level. Last level must be filled left to right.
* __Full Binary Tree__: Every node has either zero or 2 children. No nodes have only one child.

### Perfect Binary Tree
* All interior nodes have 2 children and all leaf nodes are at the same level. 
* Very rare in interviews and in real life

### Balanced tree
* Not terribly imbalanced
* Ensures O(log n) times for **INSERT** and **FIND**

### Red-Black Tree

### AVL Tree

### BST - Binary Search Tree
* Binary tree in which every node: left descendents <= parent < right descendents 

### Traversal (Binary Trees)
* In-order: Ascending order - left branch, current node, right branch.
* Pre-order: Root first, left branch then right branch.
* Post-order: Root last. Left branch first, right branch and then current node.

## Bloom Filter
* Like hashmap
* More space efficient
* Cannot delete
* Cannot store pointers to objects
* 0.1 to 1% false positive probability

## String

# Rabin-Karp Substring Search

## Graph

# Topological sort
* Only for directed and acyclic (DAGs)
* Way of ordering the list of nodes such that if (a,b) is an edge then a will appear before b in the list
* Implementation: create 2 queues: order and processNext

# Dijkstra Shortest Path
* Weighted direct graph
* Can have cycles
* Edges with positive values only
* n vertices
* m edges
* Uses priority queue
* Priority queues are implemented by array O(n2) or min heap O((m+n)log n)
* Use array if dense graph because O(n2) better than O((n+n2)log n)
* Use min heap if sparse graph
 

## Useful math
* Sum of integers (1 through N): (n*(n+1))/2
* Sum of powers of 2: 2^0 + 2^1 + 2^2 + ... + 2^n = 2^(n+1) - 1
* Log base convertion: 2 to 10: log10 p = log2 p / log2 10
* Permutations: k length string with n unique characters (no repetition): n!/(n-k)!
* Combinations: n choose k = n!/(k!*(n-k)!) 

## Big O

| Estrutura   | Running Time | Running Time |
|-------------|--------------|--------------|
| Sorted Array| SEARCH       | log n        |
|             | MIN          | 1            |
|             | MAX          | 1            |
|             | PREDECESSOR  | log n        |
|             | SUCCESSOR    | log n        |
|             | OUTPUT SORTED| n            |
|             | SELECT       | 1            |
|             | RANK         | log n        |
|             | INSERT       | n (LENTO !)  |
|             | DELETE       | n (LENTO !)  |
| B S Tree    | SEARCH       | log n        |
|             | MIN          | log n        |
|             | MAX          | log n        |
|             | PREDECESSOR  | log n        |
|             | SUCCESSOR    | log n        |
|             | OUTPUT SORTED| n            |
|             | SELECT       | log n        |
|             | RANK         | log n        |
|             | INSERT       | log n        |
|             | DELETE       | log n        |
| Hash table  | LOOKUP       | 1            |
|             | INSERT       | 1            |
|             | DELETE       | 1            |
| Heap        | INSERT       | log n        |
|             | EXTRACT MIN  | log n        |
|             | FIND MIN     | 1            |
|             | HEAPIFY      | n            |
|             | DELETE       | log n        |