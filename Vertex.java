class Vertex
{
        public Edge edge;


        //Colors
        public static final int WHITE = 0;
        public static final int GRAY = 1;
        public static final int BLACK = 2;
        //Fields for BFS
        public int color;
        public int distance;
        public int parent;

        //Fields for DFS
        public int time_in;
        public int time_out;


}
