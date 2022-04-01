class Test
{
        public static void main(String args[])
        {
                //Create graph
                Graph graph = new Graph(5);

                //Add edge
                graph.AddEdge(0,1);
                graph.AddEdge(1,3);
                graph.AddEdge(3,2);
                graph.AddEdge(2,1);
                graph.AddEdge(1,4);

                //Run BFS
                //graph.BFS(1);

                //Print it
                //graph.Print();

                // a = 0, b = 1, c = 2, d = 3, e = 4

                int path1[] =  {0,1,3,2,1};
                int path2[] =  {0,1,2,3};
                int path3[] =  {3,2,1,4};

                System.out.println("Path 1 exists?: "+graph.HasPath(path1));
                System.out.println("Path 2 exists?: "+graph.HasPath(path2));
                System.out.println("Path 3 exists?: "+graph.HasPath(path3));



        }

}
