import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//다익스트라 
//클래스 생성할때 비교하는 방법 

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
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());
		A = new ArrayList[V + 1];
		D = new int[V + 1];
		visited = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 1; i <= V; i++) {
			D[i] = INF;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			A[u].add(new Edge(v, w));
		}

		dijkstra(start);

		for (int i = 1; i <= V; i++) {
			if (D[i] == INF)
				System.out.println("INF");
			else
				System.out.println(D[i]);
		}

	}

	static private void dijkstra(int start) {
		D[start] = 0;
		q.add(new Edge(start, 0));
		while (!q.isEmpty()) {
			Edge current = q.poll();
			int c_v = current.vertex;
			if (visited[c_v] == 1)
				continue;
			for (Edge next : A[c_v]) {
				if (D[next.vertex] > D[c_v] + next.value) {
					D[next.vertex] = D[c_v] + next.value;
					q.add(new Edge(next.vertex, D[next.vertex]));
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