//
//  DijkstraEdge.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Goulart on 03/04/22.
//

import Foundation

public class DijkstraEdge<T: Equatable & Hashable>: Equatable {
    public var from: DijkstraNode<T>
    public var to: DijkstraNode<T>
    public var weight: Double

    public init(weight: Double, from: DijkstraNode<T>, to: DijkstraNode<T>) {
        self.weight = weight
        self.from = from
        self.to = to
        from.edges.append(self)
    }
}

public func == <T: Equatable> (lhs: DijkstraEdge<T>, rhs: DijkstraEdge<T>) -> Bool {
    guard lhs.from.value == rhs.from.value else {
        return false
    }
    guard lhs.to.value == rhs.to.value else {
        return false
    }
    return true
}

extension DijkstraEdge: Hashable {
    public func hash(into hasher: inout Hasher) {
        hasher.combine("\(from.value)->\(to.value)")
    }
}
