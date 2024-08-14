package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
	public static class Edge {
		int v1;
		int v2;
		int cost;

		public Edge(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
	}

	static List<Edge> graph = new ArrayList<>();
	static List<Edge> result = new ArrayList<>();
	static int v = 4;
	static int[] parent;

	public static void main(String[] args) {
		initGraph();
		kruskal();
		printResult();
	}

	public static void initGraph() {
		graph.add(new Edge(3, 4, 10));
		graph.add(new Edge(1, 2, 2));
		graph.add(new Edge(1, 3, 4));
		graph.add(new Edge(2, 3, 5));
		graph.add(new Edge(2, 4, 7));
	}

	public static void kruskal() {
		parent = new int[v];
		for(int i =0; i < v; i++) {
			parent[i] =i;
		}

		Collections.sort(graph, (s1, s2) -> s1.cost - s2.cost);
		for(Edge e: graph) {
			if(find(e.v1 -1) != find(e.v2 -1)) {
				union(e.v1-1, e.v2 -1);
				result.add(e);
			}
		}
	}

	public static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return find(parent[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x > y) {
			parent[x] = y;
		} else {
			parent[y] = x;
		}
	}

	public static void printResult() {
		int total =0;
		for(Edge e: result) {
			System.out.printf("[%d -> %d]: %d%n", e.v1, e.v2, e.cost);
			total += e.cost;
		}
		System.out.printf("Total Cost: %d", total);
	}
}
