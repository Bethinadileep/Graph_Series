/*

Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Example 1:

Input:   

Output: 1
Explanation: 1->2->3->4->1 is a cycle.
Example 2:

Input: 

Output: 0
Explanation: No cycle in the graph.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.

NOTE: The adjacency list denotes the edges of the graph where edges[i][0] and edges[i][1] represent an edge.

 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)

*/

//code

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends

class Node{
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public static boolean checkforCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[]){
        Queue<Node> q = new LinkedList<>();//BFS
        q.add(new Node(s,-1));
        vis[s] = true;
        
        while(!q.isEmpty()) {
            int node = q.peek().first;
            int pat = q.peek().second;
            q.remove();
            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                    q.add(new Node(it,node));
                    vis[it] = true;
                }
                
                else if(pat != it) return true;
            }
        }
        
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        for(int i = 0; i < V; i++) {
            if(vis[i] == false){
                if(checkforCycle(adj,i,vis)){
                    return true;
                }
            }
        }
        return false;
        
    }
}
