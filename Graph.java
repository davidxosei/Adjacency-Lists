import java.util.ArrayDeque;
import java.util.Queue;

class Graph{

        int size;
        Vertex vertices[];

        public Graph(int size){

            // Save size
            this.size = size;

            // Initialize vertices
            vertices = new Vertex[size];
            for (int i = 0; i < size; i++)
                vertices[i] = new Vertex();

        }

        public void AddEdge(int source, int target){

                // Create edge
                Edge edge = new Edge(target);

                // Add it at the head of the adjacency list
                edge.next = vertices[source].edge;
                vertices[source].edge = edge;


        }

        public void AddUndirectedEdge(int source, int target){

                AddEdge(source, target);
                AddEdge(target, source);

        }

        public int GetSize(){

                return size;
        }
        public void Print(){

                System.out.println("** Graph **");
                for (int i = 0; i<size; i++){
                        // Title
                        System.out.println("Vertex " + i + ":");

                        // Print fields for BFS
                        System.out.println(" Distance: " + vertices[i].distance);
                        System.out.println(" Parent: " + vertices[i].parent);

                        // Print fields for DFS
                        System.out.println(" Time in: " + vertices[i].time_in);
                        System.out.println(" Time out: " + vertices[i].time_out);

                        // Print edges
                        System.out.println(" Edges:");
                        for (Edge edge = vertices[i].edge; edge != null; edge = edge.next)
                                System.out.println("    "+ i + " -> " + edge.target);

                }

        }


        public void BFS(int start){

                // Initialize
                for (int i = 0; i < size; i++){

                        vertices[i].color = i == start ? Vertex.GRAY : Vertex.WHITE;
                        vertices[i].distance = i == start ? 0 : Integer.MAX_VALUE;
                        vertices[i].parent = -1;


                }
                // Create queue and insert source vertex in it
                Queue<Integer> queue = new ArrayDeque<Integer>();
                queue.add(start);

                // Process queue
                while (queue.peek() != null){
                        // Extract vertex from queue
                        int source = queue.remove();

                        // Traverese adjacency list
                        for (Edge edge = vertices[source].edge; edge != null; edge = edge.next){
                                // Get target
                                int target = edge.target;

                                // Check if target is still white
                                if (vertices[target].color == Vertex.WHITE){

                                        //Update target vertex
                                        vertices[target].color = Vertex.GRAY;
                                        vertices[target].parent = source;
                                        vertices[target].distance = vertices[source].distance + 1;

                                        // Enqueue target vertex
                                        queue.add(target);

                                }


                        }

                        // Finish processing vertex
                        vertices[source].color = Vertex.BLACK;


                }
        }

       public void PrintShortestPath(int source, int target){

                if(source == target){
                        System.out.print(source);
        }
        else if (vertices[target].parent == -1){
                System.out.print("Undreachable");

        }
        else{
                PrintShortestPath(source,vertices[target].parent);
                System.out.print(" -> " + target);

                }
        }
        // This function takes the current logical time as an input,
                // and returns the updated logical time after processing
                // the vertex.
                int DFSVisit(int source, int time){

                        // Color vertex gray
                        vertices[source].color = Vertex.GRAY;
                        vertices[source].time_in= time++;

                        // Traverse adjacency list
                        for (Edge edge = vertices[source].edge; edge != null; edge = edge.next){

                                //Get target vertex
                                int target = edge.target;

                                // Visit target vertex if it hasn't been visited yet
                                if (vertices[target].color == Vertex.WHITE){
                                        vertices[target].parent = source;
                                        time = DFSVisit(target, time);


                                        }
                                }

                                // Color source vertex black
                                vertices[source].color = Vertex.BLACK;
                                vertices[source].time_out = time++;


                                // Return updated time
                                return time;
                }

                public void DFS(int start){

                        // Initialize all vertices
                        for (int i = 0; i < size; i++){
                                vertices[i].color = Vertex.WHITE;
                                vertices[i].parent = -1;
                                vertices[i].time_in = -1;
                                vertices[i].time_out = -1;


                        }

                        // Trigger recursive calls
                        DFSVisit(start, 0);



                        }
                        private boolean HasEdge(int source, int target)
       {
               for (Edge edge = vertices[source].edge; edge != null; edge = edge.next)
                       if(edge.target == target)
                               return true;
               return false;
       }

       public boolean HasPath(int vertices[])
       {
               for(int i = 0; i < vertices.length - 1; i++)
               {

                       int source = vertices[i];
                       int target = vertices[i+1];
                       if(HasEdge(source, target) == false)
                               return false;


               }

               return true;
       }


}
