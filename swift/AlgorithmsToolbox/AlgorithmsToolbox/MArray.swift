//
//  Arrays.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Goulart on 02/04/22.
//

import Foundation

/// Value (not Reference)
final class MArray: DataStructureProtocol {

    static private var mMutArray: [Int] = []

    static func run() {
        mMutableArray()
        iteration()
        findElement(2)
        findPrimes()
        uniqueSort()
        mapDouble()
        reduceArray()
        mFlatMap()
        twoDimensions()
        slices()
    }

    static private func mMutableArray() {
        mMutArray.append(1)
        mMutArray.append(2)
        mMutArray.append(1)

        print(mMutArray)
    }

    static private func iteration() {
        for x in mMutArray {
            print(x)
        }

        for x in mMutArray.dropFirst() {
            print(x)
        }

        for x in mMutArray.dropLast(2) {
            print(x)
        }

        for (index, value) in mMutArray.enumerated() {
            print("num: \(index), element: \(value)")
        }
    }

    static private func findElement(_ element: Int) {
        if let index = mMutArray.firstIndex(where: { $0 == element }) {
            print("element \(element) is at index: \(index)")
        } else {
            print("not found")
        }
    }

    static private func findPrimes() {
        let primes = mMutArray.filter { value in
            isPrime(value)
        }
        print(primes)
        print(mMutArray)
    }

    static private func uniqueSort() {
        let set: Set<Int> = Set(mMutArray)
        let sorted: [Int] = Array(set).sorted()
        print(sorted)
    }

    static private func mapDouble() {
        let doubled = mMutArray.map {
            $0 * 2
        }
        print(doubled)
    }

    static private func reduceArray() {
        let reduced = mMutArray.reduce(into: []) { result, element in
            if isPrime(element) {
                result.append(element)
            }
        }
        print(reduced)

        let reducedToInt: Int = mMutArray.reduce(into: 0) { result, element in
            result = element + result
        }
        print(reducedToInt)
    }

    static private func isPrime(_ value: Int) -> Bool {
        return value > 1 && !(2..<value).contains { value % $0 == 0 }
    }

    // flattens the resulting “array of arrays” into just a single array
    static private func mFlatMap() {
        let myFlat = mMutArray.compactMap { element in
            (0...100).map {
                $0*element
            }
        }
        print(myFlat)

        let mMap = mMutArray.compactMap { element in
            element * 2
        }

        print(mMap)
    }

    static func twoDimensions() {
        var my2DArray: [[Int]] = [[1,2], [10,11], [20, 30]]
        for x in my2DArray {
            print(x)
        }
    }

    static func slices() {
        var mySlice = mMutArray[1...]
        print(mySlice)
    }
}
