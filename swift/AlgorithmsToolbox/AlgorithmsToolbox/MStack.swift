//
//  MStack.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Goulart on 03/04/22.
//

import Foundation

public struct Stack<T> {
    private var elements = [T]()
    public init() {}

    public mutating func pop() -> T? {
        return self.elements.popLast() // Array tem popLast()
    }

    public mutating func push(_ element: T) {
        self.elements.append(element)
    }

    public func peek() -> T? {
        return self.elements.last
    }

    public var isEmpty: Bool {
        return self.elements.isEmpty
    }

    public var count: Int {
        return self.elements.count
    }

}

extension Stack: CustomStringConvertible, CustomDebugStringConvertible {
    public var description: String {
        return self.elements.description
    }

    public var debugDescription: String {
        return self.elements.debugDescription
    }

}

extension Stack: ExpressibleByArrayLiteral {

    public init(arrayLiteral elements: T...) {
        self.init(elements)
    }
}

public struct ArrayIterator<T>: IteratorProtocol {
    var currentElement: [T]

    init(elements: [T]) {
        self.currentElement = elements
    }

    mutating public func next() -> T? {
        if (!self.currentElement.isEmpty) {
            return self.currentElement.popLast()
        }
        return nil
    }
}

extension Stack: Sequence {
    public func makeIterator() -> some IteratorProtocol {
        return ArrayIterator<T>(elements: self.elements)
    }
}

extension Stack {

    public init<S : Sequence>(_ s: S) where S.Iterator.Element == T {
        self.elements = Array(s.reversed())
    }
}

class MStack: DataStructureProtocol {
    // STACK: LIFO : Last-in first out (pilha)
    // push() - add element to top of stack
    // pop() - removes and return element from top of stack
    // peek() - returns but not removes

    // helper operations:
    // count
    // isEmpty()
    // isFull()

    static func run() {
        let myStack = [4,5,6,7]
        var myStackFromStack = Stack<Int>(myStack)
        myStackFromStack.push(55)
        print(myStackFromStack)
    }


}
