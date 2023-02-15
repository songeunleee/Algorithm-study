import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//다익스트라 

public class Main {

	static ArrayList<Edge>[] A;
	static int visited[];
	static int D[];
	static int INF = 1000000000;
	static PriorityQueue<Edge> q = new PriorityQueue<Edge>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		A = new ArrayList[N + 1];
		D = new int[N + 1];
		visited = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			D[i] = INF;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			A[u].add(new Edge(v, w));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);

		System.out.println(D[end]);

	}

	private static void dijkstra(int start) {
		D[start] = 0;
		q.add(new Edge(start, 0));
		while (!q.isEmpty()) {
			Edge current = q.poll();
			int c_v = current.vertex;
			if (visited[c_v] == 0) {
				visited[c_v] = 1;
				for (int i = 0; i < A[c_v].size(); i++) {
					int next = A[c_v].get(i).vertex;
					int value = A[c_v].get(i).value;
					if (D[next] > D[c_v] + value) {
						D[next] = D[c_v] + value;
						q.add(new Edge(next, D[next]));
					}
				}
			}
		}
	}

}

class Edge implements Comparable<Edge> {
	int vertex;
	int value;

	Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}

	public int compareTo(Edge e) {
		if (this.value > e.value)
			return 1;
		else
			return -1;
	}
}