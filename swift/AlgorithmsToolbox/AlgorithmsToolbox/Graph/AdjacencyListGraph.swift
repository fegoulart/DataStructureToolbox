public struct VertexEdgesList<T:Equatable & Hashable> {
    // Each VertexEdgesList contains the vertex itself and its connected
    // vertices stored in an array of edges
    public let vertex:Vertex<T>
    public var edges:[Edge<T>] = []
    public init(vertex: Vertex<T>) {
        self.vertex = vertex
    }

    public mutating func addEdget(edge: Edge<T>) {
        guard !self.edges.contains(where: { $0 == edge }) else {
            return
        }
        self.edges.append(edge)
    }
}

public struct AdjacencyListGraph<T: Equatable & Hashable> {
    public var adjacencyLists: [VertexEdgesList<T>] = []

    public var vertices: [Vertex<T>] {
        get {
            var vertices = [Vertex<T>]()
            for list in adjacencyLists {
                vertices.append(list.vertex)
            }
            return vertices
        }
    }

    public var edges: [Edge<T>] {
        get {
            var edges = Set<Edge<T>>()
            for list in adjacencyLists {
                for edge in list.edges {
                    edges.insert(edge)
                }
            }
            return Array(edges)
        }
    }

    public init() { }

    public mutating func addVertex(data: T) -> Vertex<T> {
        //Check if vertex exists
        for list in adjacencyLists {
            if list.vertex.data == data {
                return list.vertex
            }
        }

        //Create it, update the graph and return it
        let vertex: Vertex<T> = Vertex(data: data, index: adjacencyLists.count)
        let adjacencyList = VertexEdgesList(vertex: vertex)
        adjacencyLists.append(adjacencyList)
        return vertex
    }

    public mutating func addEdge(from: Vertex<T>, to: Vertex<T>) -> Edge<T> {
        let edge = Edge(from: from, to: to)
        let list = adjacencyLists[from.index]

        //Check if the edge already exists
        if list.edges.count > 0 {
            for existingEdge in list.edges {
                if existingEdge == edge {
                    return existingEdge
                }
            }
            adjacencyLists[from.index].edges.append(edge)
        } else {
            adjacencyLists[from.index].edges = [edge]
        }
        return edge
    }
}
