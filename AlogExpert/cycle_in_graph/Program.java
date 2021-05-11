package cycle_in_graph;

class Program {

	final int NOT_VISITED = 0;
	final int NO_CYCLE = 1;
	
  public boolean cycleInGraph(int[][] edges) {
    // Write your code here.
		boolean[] visited = new boolean[edges.length];
		int[] dp = new int[edges.length];
		for (int i = 0; i < edges.length; i++) {
			if (haveCycleAt(i, edges, visited, dp)) return true;
		}
    return false;
  }
	
	boolean haveCycleAt(int node, int[][] edges, boolean[] visited, int[] dp) {
		if (dp[node] == NO_CYCLE) return false;
		if (visited[node]) return true;
		visited[node] = true;
		for (int child: edges[node]) {
			if (haveCycleAt(child, edges, visited, dp)) return true;
		}
		visited[node] = false;
		dp[node] = NO_CYCLE;
		return false;
	}
}