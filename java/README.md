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
* Self-balancing BST - O(log N) insertions, deletions and retrievals
* Require a bit less memory
* Can rebalance faster: Used in situations where the tree will be modified frequently
* Every node is either red or black
* The root is black
* The leaves, which are NULL nodes, are considered black
* Every red node must have 2 black children. That is, a red node cannot have red children (although a black node can have black children)
* Every path from a node to its leaves must have the same number of black children

### AVL Tree
* One way to implement tree balancing
* Stores in each node the height of the subtrees rooted at this node
* For any node, we can check if it is height balanced: heights of left subtree and right subtree differ by no more than 1 
* We can check and fix the balance at each node though a series of rotations (left or right)

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
* Tree is a type of graph (connected without cycles)
* Directed: "one way street"
* Undirected: "two way street"
* Connected graph: there is a path between evey pair of vertices
* 2 ways of implementing: adjacency list and adjacency matrices

### Graph Search
* DFS - Depth-first search (visit all nodes starting from root)
* BFS - Breadth-first search (used for shortest path between 2 nodes)


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
| ArrayList   | GET          | 1            |
|             | ADD          | 1            |
|             | REMOVE       | n            |
| LinkedList  | GET          | n            |
|             | ADD          | 1 (amortized)|
|             | REMOVE       | n            |

## Recursão

Todo algoritmo de recursão ocupa O(n) de espaço

## SOLID

* Single responsability - Não pode haver mais de uma razão para uma classe mudar. Exemplos de razões de mudanças: formato da mensagem (Json/XML), protocolo (Html), segurança na comunicação (autenticação). Se dentro do controller temos a lógica de validação de usuário, precisamos criar uma nova classe UserValidator.
* Open Closed  - Entidades (classes, módulos, métodos) devem estar abertas para extensão, mas fechadas para modificações. Exemplo: ter uma classe abstrata mãe para extensão.
* Liskov Substitution - Deve ser possível substituir as classes base pelas classes filhas sem alteração de comportamento / características do software. Exemplo: Se estendemos retangulo para criar a classe quadrado, e a classe retangulo já tem um teste feito para que a altura tenha 20 e a largura tenha 30. Vai falhar para quadrado. Solução: Quadrado não deve mais estender de retangulo, pois o comportamento de um retangulo é distinto de um quadrado. Devemos criar uma interface Shape com o metodo comum: computeArea()
* Interface Segregation -  Clientes nao devem ser forçados a depender de interfaces que eles não utilizam. Interface pollution. Sinais de violação: métodos com implementação vazia ou retornando null / default / valor dummy ou estourando UnsupportedOperationException (ou similar). Exemplo: ter na interface um metodo findByName e fazer uma classe implementar isto sem precisar.  
* Dependency Inversion - Trata de acoplamento entre classes. Módulos de alto nível (Regra de negócios) nao devem depender de módulos de baixo nível (SDKs, métodos de linguaguem). Modulos de alto e baixo niveis devem depender de abstrações. As abstrações, por sua vez, não devem depender de detalhes, mas de abstrações. Ex: tenho um método que pega um json e grava no disco. Se eu utilizo funcoes acopladas ao metodo Json e ao disco, eu fico refem destas classes. Solução: enviar a interface como parametro: public void writeReport(Formatter formatter, Writer writer) { Report report = new Report; String report = formatter.format(report); writer.write("My Report");