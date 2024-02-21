public class DijktraAlgorithm {

    public static void main(String[] args)
    {
        int[][] adjacencyMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijkstra(adjacencyMatrix, 0);
    }

        private static void dijkstra(int[][] adjacencyMatrix,int startVertex)
        {
            int endVertices = adjacencyMatrix[0].length;
            int[] shortestDistances = new int[endVertices];
            boolean[] added = new boolean[endVertices];
            for (int vertexIndex = 0; vertexIndex < endVertices;
                 vertexIndex++)
            {
                shortestDistances[vertexIndex] = Integer.MAX_VALUE;
                added[vertexIndex] = false;
            }
            shortestDistances[startVertex] = 0;
            int[] parents = new int[endVertices];
            parents[startVertex] = -1;
            for (int i = 1; i < endVertices; i++)
            {
                int nearestVertex = -1;
                int shortestDistance = Integer.MAX_VALUE;
                for (int vertexIndex = 0;
                     vertexIndex < endVertices;
                     vertexIndex++)
                {
                    if (!added[vertexIndex] &&
                            shortestDistances[vertexIndex] <
                                    shortestDistance)
                    {
                        nearestVertex = vertexIndex;
                        shortestDistance = shortestDistances[vertexIndex];
                    }
                }

                added[nearestVertex] = true;
                for (int vertexIndex = 0;
                     vertexIndex < endVertices;
                     vertexIndex++)
                {
                    int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                    if (edgeDistance > 0
                            && ((shortestDistance + edgeDistance) <
                            shortestDistances[vertexIndex]))
                    {
                        parents[vertexIndex] = nearestVertex;
                        shortestDistances[vertexIndex] = shortestDistance +
                                edgeDistance;
                    }
                }
            }

            printSolution(startVertex, shortestDistances, parents);
        }

        private static void printSolution(int startVertex,
                                          int[] distances,
                                          int[] parents)
        {
            int nVertices = distances.length;
            System.out.print("Vertex\t Distance\tPath");
            for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
            {
                if (vertexIndex != startVertex)
                {
                    System.out.print("\n" + startVertex + " -> ");
                    System.out.print(vertexIndex + " \t\t ");
                    System.out.print(distances[vertexIndex] + "\t\t");
                    printPath(vertexIndex, parents);
                }
            }
        }

        private static void printPath(int currentVertex,int[] parents)
        {

            if (currentVertex == -1)
            {
                return;
            }
            printPath(parents[currentVertex], parents);
            System.out.print(currentVertex + " ");
        }

 }
