// Adjacency Matrix for spGraph (directed)
//          |Adachi|Bunkyo|Chiyoda|Itabashi|Edogawa
// Adachi   |     0|    50|      0|      80|      0
// Bunkyo   |     0|     0|     60|      90|      0
// Chiyoda  |     0|     0|      0|       0|     40
// Itabashi |     0|     0|     20|       0|     70
// Edogawa  |     0|    50|      0|       0|      0

public class ShortestPathApp {
    public static void main(String[] args) {
        DirectedWeightedGraph spGraph = new DirectedWeightedGraph();
        spGraph.addVertex("Adachi");
        spGraph.addVertex("Bunkyo");
        spGraph.addVertex("Chiyoda");
        spGraph.addVertex("Itabashi");
        spGraph.addVertex("Edogawa");

        // Adachi
        spGraph.addEdge(0, 1, 50);
        spGraph.addEdge(0, 3, 80);
        // Bunkyo
        spGraph.addEdge(1, 2, 60);
        spGraph.addEdge(1, 3, 90);
        // Chiyoda
        spGraph.addEdge(2, 4, 40);
        // Itabashi
        spGraph.addEdge(3, 2, 20);
        spGraph.addEdge(3, 4, 70);
        // Edogawa
        spGraph.addEdge(4, 1, 50);
        spGraph.shortestPath("Chiyoda", "Itabashi");
        // Expected Result -> Chiyoda->Edogawa->Bunkyo->Itabashi
        //                    Expected Cost: $180
        spGraph.shortestPath("Bunkyo", "Chiyoda");
        // Expected Result -> Bunkyo->Chiyoda
        //                    Expected Cost: $60
        spGraph.shortestPath("Adachi", "Itabashi");
        // Expected Result -> Adachi->Itabashi
        //                    Expected Cost: $80
        // Expected Result -> Adachi->Itabashi->Chiyoda->Edogawa
        //                    Expected Cost: $140
        spGraph.displayAllPairsShortestPath();
        // Expected Result
        // 0 50 100 80 140
        // - 0 60 90 100
        // - 90 0 180 40
        // - 110 20 0 60
        // - 50 110 140 0
    }
}
