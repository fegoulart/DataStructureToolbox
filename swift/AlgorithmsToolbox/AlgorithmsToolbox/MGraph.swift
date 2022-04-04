//
//  MGraph.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Goulart on 03/04/22.
//

import Foundation

// Vertix = Node
// Edge = Connection between nodes
// Undirected graph = 2 way street
// Directed graph = One way street

// Implementations

// OO approach (structs / classes)
// O(number vertices) time for commom operations
// O(vertices + edges) space

// Adjacency list
// Dictionary of all vertices - Each key list of its connected vertices
// O(m+n) space

// Adjacency matrix
// rows and columns are vertices
//   A B C D
// A 0 0 1 0
// B 0 0 1 1
// C 1 1 0 0
// D 0 1 0 0

class MGraph: DataStructureProtocol {

    static var myGraph = AdjacencyListGraph<Int>()

    static func run() {
//        let v1 = myGraph.addVertex(data: 1)
//        let v2 = myGraph.addVertex(data: 2)
//        let v3 = myGraph.addVertex(data: 3)
//        let v4 = myGraph.addVertex(data: 4)
//        let v5 = myGraph.addVertex(data: 5)
//        let v6 = myGraph.addVertex(data: 6)
//        myGraph.addEdge(from: v1, to: v2)
//        myGraph.addEdge(from: v2, to: v3)
//        myGraph.addEdge(from: v3, to: v4)
//        myGraph.addEdge(from: v1, to: v5)
//        let n1 = BFSNode(value: 1, neighbours: [], visited: false)
//        let n2 = BFSNode(value: 2, neighbours: [], visited: false)
//        let n3 = BFSNode(value: 3, neighbours: [], visited: false)
//        let n4 = BFSNode(value: 4, neighbours: [], visited: false)
//        let n5 = BFSNode(value: 5, neighbours: [], visited: false)
//        let n6 = BFSNode(value: 6, neighbours: [], visited: false)
//        n1.addNeighbour(node: n2)
//        n1.addNeighbour(node: n5)
//        n2.addNeighbour(node: n3)
//        n3.addNeighbour(node: n4)
//        var acumulacao = 0
//        BFSNode.breadthFirstSearch(first: n1, visit: { value in
//            print(value)
//        })
        let d1 = DijkstraNode(value: 1, edges: [], visited: false)
        let d2 = DijkstraNode(value: 2, edges: [], visited: false)
        let d3 = DijkstraNode(value: 3, edges: [], visited: false)
        let d4 = DijkstraNode(value: 4, edges: [], visited: false)
        let d5 = DijkstraNode(value: 5, edges: [], visited: false)
        let d6 = DijkstraNode(value: 6, edges: [], visited: false)
        let edge12 = DijkstraEdge(weight: 6, from: d1, to: d2)
        let edge23 = DijkstraEdge(weight: 6, from: d2, to: d3)
        let edge34 = DijkstraEdge(weight: 6, from: d3, to: d4)
        let edge15 = DijkstraEdge(weight: 6, from: d1, to: d5)
        let graph = DijkstraGraph(nodes: [d1, d2, d3, d4, d5])
        DijkstraGraph.dijkstraPath(startNode: d1, graph: graph, finishNode: d4)
    }
}
