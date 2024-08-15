package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Prim {
	public static class Node{
		int val;
		List<Edge> edges = new ArrayList<>();

		public Node(int val) {
			this.val = val;
		}
	}

	public static class Edge {
		int des;
		int cost;

		public Edge(int des, int cost) {
			this.des = des;
			this.cost = cost;
		}
	}

	static List<Node> graph = new ArrayList<>();
	static int v = 4;
	static boolean[] visited = new boolean[v];
	static int start = 1;

	public static void main(String[] args) {
		initGraph();
		prim();
	}

	public static void initGraph() {
		for(int i =0; i<v; i++) {
			graph.add(new Node(i+1));
		}
		graph.get(0).edges.add(new Edge(2,2));
		graph.get(0).edges.add(new Edge(3,4));

		graph.get(1).edges.add(new Edge(1,2));
		graph.get(1).edges.add(new Edge(3,5));
		graph.get(1).edges.add(new Edge(4,7));

		graph.get(2).edges.add(new Edge(4,10));
		graph.get(2).edges.add(new Edge(1,4));
		graph.get(2).edges.add(new Edge(2,5));

		graph.get(3).edges.add(new Edge(2,7));
		graph.get(3).edges.add(new Edge(3,10));
	}

	public static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.cost -e2.cost);
		Map<Integer, List<Edge>> map = new HashMap<>();
		String str = null;
		int total = 0;

		for(Node n: graph) {
			map.put(n.val, n.edges);
		}
		pq.add(new Edge(start, 0));

		while(pq.isEmpty() == false) {
			Edge e = pq.poll();
			if(visited[e.des-1] == true) {
				continue;
			}
			if(str != null) {
				System.out.printf("[%s -> %d]: %d\n", str, e.des, e.cost);
			}
			str = Integer.toString(e.des);
			visited[e.des-1] = true;
			total += e.cost;
			for(Edge e1: map.get(e.des)) {
				if(!visited[e1.des-1]) {
					pq.add(e1);
				}
			}
		}
		System.out.printf("Total Cost: %d", total);
	}
}
