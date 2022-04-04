//
//  Edge.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Goulart on 03/04/22.
//

import Foundation

public struct Edge<T: Equatable & Hashable>: Equatable {

  public let from: Vertex<T>
  public let to: Vertex<T>
}

public func == <T:Equatable>(lhs: Edge<T>, rhs: Edge<T>) -> Bool {
  guard lhs.from == rhs.from else {
    return false
  }

  guard lhs.to == rhs.to else {
    return false
  }

  return true
}

extension Edge: Hashable {

    public func hash(into hasher: inout Hasher) {
        let stringHash = "\(from.index) -> \(to.index)"
        hasher.combine(stringHash)
    }
}
