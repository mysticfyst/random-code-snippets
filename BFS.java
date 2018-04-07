import java.util.*;

public class BFS{
    
    public LinkedList<Integer>[] graph;
    public Queue<Integer> q;
    public int[] level;
    public boolean[] visited;
    
    
    @SuppressWarnings("unchecked")
	public BFS(int vertex){
        graph = (LinkedList<Integer>[]) new LinkedList[vertex];
        q = new LinkedList<Integer>();
        level = new int[vertex];
        visited = new boolean[vertex];
        level[0] = 1;
        for(int i = 0; i < vertex; i++){
            graph[i] = new LinkedList<>();
        }
    }
    
    //undirected edge
    public void addEdge(int a, int b){
        graph[a].add(b);
        graph[b].add(a);
    }
    
    public void traverseUsingBFS(int lvl){
        q.add(0);
        visited[0] = true;
        //System.out.print("1");
        int count = 0;
        boolean breakOnThroughToTheOtherSide = false;
        while(!q.isEmpty()) {
        	int v = q.poll();
        	for(int i = 0; i < graph[v].size(); i++) {
        		int x = graph[v].get(i);
        		if(!visited[x]) {
	        		q.add(x);
	        		visited[x] = true;
	        		level[x] = level[v] + 1;
	        		if(level[x] == lvl) {
	        			count++;
	        			//System.out.print(level[x]+" Count value "+count);
	        		}
	        		if (level[x]> lvl) {
	        			System.out.println(count);
	        			breakOnThroughToTheOtherSide = true;
	        			break;
	        		}
	        		//System.out.print(" ->"+(x+1)+"("+level[x]+")");
        		}
        	}
        	if(breakOnThroughToTheOtherSide) {
        		break;
        	}
    			
        }
    }
    
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        BFS ob = new BFS(n);
        for(int i = 0; i < n-1; i++){
            ob.addEdge(s.nextInt()-1, s.nextInt()-1);
        }
        ob.traverseUsingBFS(s.nextInt());
    }
}











