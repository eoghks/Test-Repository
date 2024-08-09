package algorithm;

public class FloydWarshallTest {
	static int  inf = 10000;
	static int[][] graph = {
			{  0,  10,   5, inf, inf},
			{inf,   0,   2, inf, inf},
			{  1,  13,   0, inf, inf},
			{  8, inf, inf,   0,   3},
			{inf,  31, inf,   9,   0}
	};

	public static void main(String[] args) {
		floydWarshall();
		printShortPath();
	}

	public static void floydWarshall() {
		for(int mid = 0; mid <graph.length; mid++) {
			for(int start = 0; start<graph.length; start++) {
				for(int end = 0; end < graph.length; end++) {
					if(graph[start][mid] != inf && graph[mid][end] != inf) {
						graph[start][end] = Math.min(graph[start][end], graph[start][mid]+ graph[mid][end]);
					}
				}
			}
		}
	}

	public static void printShortPath() {
		for(int i = 0; i < graph.length; i++) {
			if(graph[i][i] < 0) {
				System.out.println("음의 사이클이 존재하여 최소 경로를 구할 수 없습니다.");
				return;
			}
		}

		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				System.out.print(String.format("%-3s| ", graph[i][j] != inf? graph[i][j]: "inf"));
			}
			System.out.println("\n------------------------");
		}
	}
}
