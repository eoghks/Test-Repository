package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordTest {
	public static class Edge {
		int st;
		int des;
		int cost;

		public Edge(int st, int des, int cost) {
			this.st = st;
			this.des = des;
			this.cost = cost;
		}
	}

	static List<Edge> edges = new ArrayList<>();
	static int v = 4;
	static int start = 1;
	static int[] dist;

	public static void getTestEdge() {
		edges.add(new Edge(1, 2, 1));
		edges.add(new Edge(2, 3, 1));
		edges.add(new Edge(3, 4, 2));
		edges.add(new Edge(4, 2, -1));
	}

	public static void initDist() {
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
	}

	public static void main(String[] args) {
		getTestEdge();
		initDist();
		bellmanford();
	}

	public static void bellmanford() {
		//정점의 갯수만큼 반복
		for(int i=0; i<v; i++) {
			//간선의 개수 만큼 반복
			for(int j = 0; j < edges.size(); j++) {
				Edge edge = edges.get(j);
				if(dist[edge.st] != Integer.MAX_VALUE && dist[edge.des] > dist[edge.st] + edge.cost) {
					dist[edge.des] = dist[edge.st] + edge.cost;
				} //출발 노드가 이미 방문한 노드인 경우에만 확인
			}
		}

		//음수 사이클 확인
		for(int i=0; i<v; i++) {
			//간선의 개수 만큼 반복
			for(int j = 0; j < edges.size(); j++) {
				Edge edge = edges.get(j);
				if(dist[edge.st] != Integer.MAX_VALUE && dist[edge.des] > dist[edge.st] + edge.cost) {
					System.out.println("음수 사이클이 존재합니다.");
					return;
				} //출발 노드가 이미 방문한 노드인 경우에만 확인
			}
		}
		for (int i = 1; i < dist.length; i++) {
			if(start != i) {
				System.out.println("[" + start + "->" +  i + "]: " + dist[i] );
			}
		}
	}
}
