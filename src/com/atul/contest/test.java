import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, ArrayList<Pair>> graph = new HashMap<>();
        HashMap<Integer,Integer> result = new HashMap<>();
        HashMap<Integer,Boolean> visited = new HashMap<>();
        for(int i = 0;i<n;i++)
        {
            int num = sc.nextInt();
            graph.put(num, new ArrayList<Pair>());
            result.put(num, Integer.MAX_VALUE);
            visited.put(num,false);
        }
        int edge = sc.nextInt();
        for(int i = 0;i<edge;i++){
            int num1= sc.nextInt();
            int num2 = sc.nextInt();
            int weight = sc.nextInt();
            graph.get(num1).add(new Pair(num2, weight));
        }
        int src = sc.nextInt();
        int des = sc.nextInt();
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(Comparator.comparingInt(a -> a.weight));
        queue.add(new Pair(src,0));
        while(!queue.isEmpty()){
            Pair node = queue.poll();
            visited.put(node.num, true);
            for(Pair node1:graph.get(node.num)){
                if(result.get(node1.num)>(node.weight+node1.weight)){
                    visited.put(node1.num, true);
                    result.put(node1.num, (node.weight+node1.weight));
                    queue.add(new Pair(node1.num, (node.weight+node1.weight)));
                }
            }

        }
        if(result.get(des) != Integer.MAX_VALUE)
            System.out.print(result.get(des));
        else
            System.out.print("-1");
    }
    static class Pair{
        int num;
        int weight;
        public Pair(int num, int weight)
        {
            this.num = num;
            this.weight = weight;
        }
    }
}