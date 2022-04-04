//
//  main.swift
//  AlgorithmsToolbox
//
//  Created by Fernando Goulart on 02/04/22.
//

import Foundation

protocol DataStructureProtocol {
    static func run()
}

final class Main: DataStructureProtocol {
    static func run() {
        //MArray.run()
        //MDictionary.run()
        // MStack.run()
        MGraph.run()
    }
}

Main.run()
