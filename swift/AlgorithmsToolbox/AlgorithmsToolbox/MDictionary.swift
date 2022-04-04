//
//  MDictionary.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Goulart on 02/04/22.
//

import Foundation

class MDictionary: DataStructureProtocol {

    static var myDict = Dictionary<Int, String>()
    static var myDict2 = [Int: String]()
    static var myDict3: [Int: String] = [1: "One", 2: "Two"]

    static func run() {
        addValues()
        removeValues()
        retrievingData()
        sorted()
    }

    static func addValues() {
        var result = myDict.updateValue("Three", forKey: 3)
        // nil if new value
        // value? if update
        print(result)

        result = myDict.updateValue("New Three", forKey: 3)
        print(result)
    }

    static func removeValues() {
        let result = myDict.removeValue(forKey: 3)
        print("\(result) was removed from key: 3")

        myDict[2] = nil

    }

    static func retrievingData() {
        for numericKey in myDict3.keys {
            print(numericKey)
            //print("\(numericKey) is the numeric form of \(stringValue)")
        }

        for (numericKey, stringValue) in myDict3 {
            print("\(numericKey) is the numeric form of \(stringValue)")
        }
    }

    static func sorted() {
        let sortedArrayFromDict: [(Int, String)] = myDict3.sorted( by: { $0.0 < $1.0 })
        print(sortedArrayFromDict)
        for (key) in sortedArrayFromDict.map({ $0.0}) {
            print("The key: \(key)")
        }
        for (value) in sortedArrayFromDict.map({ $0.1}) {
            print("The value: \(value)")
        }
    }

    
}
