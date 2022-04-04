//
//  Vertex.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Goulart on 03/04/22.
//

import Foundation

public struct Vertex<T: Equatable & Hashable>: Equatable {

    public var data: T
    public let index: Int

}

public func ==<T:Equatable>(lhs: Vertex<T>, rhs: Vertex<T>) -> Bool {
    guard lhs.data == rhs.data else {
        return false
    }
    return true
}

extension Vertex: Hashable {

    public func hash(into hasher: inout Hasher) {
        hasher.combine(index)
    }
}
