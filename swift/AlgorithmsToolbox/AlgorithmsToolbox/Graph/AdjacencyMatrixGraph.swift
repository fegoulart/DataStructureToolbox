//
//  AdjacencyMatrixGraph.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Luiz Goulart on 15/07/22.
//

import Foundation


// Um grafo com 7 nós (0 a 6)
let graph = [[false, true,  false, false, false, false, false],
                [true,  false, false, false, false, false, false],
                [false, false, false, true,  false, false, false],
                [false, false, true,  false, false, false, false],
                [false, false, false, false, false, false, true ],
                [false, false, false, false, true,  false, false],
                [false, false, false, false, false, true,  false]]

// Verificar se a quantidade de nos que entram é a mesma da que sai:

func solution(roadRegister: [[Bool]]) -> Bool {
    let graph = graphBuilder(roadRegister)
    print(graph)
    return checkIfBalanced(graph: graph, numberOfNodes: roadRegister.count)
}

func graphInitializer(_ roadRegister: [[Bool]] ) -> [Int: (Int, Int)] {
    var graph: [Int: (Int, Int)] = [:]
    for nodeIndex in 0..<roadRegister.count {
        var initialValue: (Int, Int) = (0,0)
        graph[nodeIndex] = initialValue
    }
    return graph
}

func graphBuilder(_ roadRegister:[[Bool]]) -> [Int: (Int, Int)] {
    var graph: [Int: (Int, Int)] = graphInitializer(roadRegister)
    for (nodeIndex, node) in roadRegister.enumerated() {
        for (index, value) in node.enumerated() {
            if value {
                graph[nodeIndex]!.1 = graph[nodeIndex]!.1 + 1
                graph[index]!.0 = graph[index]!.0 + 1
            }
        }
    }
    return graph
}

func checkIfBalanced(graph: [Int: (Int, Int)], numberOfNodes: Int) -> Bool {
    for nodeIndex in 0..<numberOfNodes {
        guard graph[nodeIndex]!.0 == graph[nodeIndex]!.1 else {
            return false
            }
    }
    return true
}
