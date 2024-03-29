//
//  DijkstraNode.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Goulart on 03/04/22.
//

import Foundation

public class DijkstraNode<T: Equatable & Hashable>: Equatable {
    public var value: T
    public var edges:[DijkstraEdge<T>]
    public var visited: Bool

    public var distance:Int = Int.max

    public var previous:DijkstraNode<T>?

    public init(value: T, edges:[DijkstraEdge<T>], visited: Bool) {
        self.value = value
        self.edges = edges
        self.visited = visited
    }
}

public func == <T: Equatable> (lhs: DijkstraNode<T>, rhs: DijkstraNode<T>) -> Bool {
    guard lhs.value == rhs.value else {
        return false
    }
    return true
}

extension DijkstraNode: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine(value)
    }
}
