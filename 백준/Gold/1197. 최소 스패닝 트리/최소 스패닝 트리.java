import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//유니온 파인드를 이용한 크루스칼 알고리즘

public class Main {
	static int parent[];
	static Edge A[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		A = new Edge[E];
		parent = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			A[i] = new Edge(s, e, v);
		}
	
		Arrays.sort(A);
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (!findParent(A[i].start, A[i].end)) {
				sum += A[i].value;
				union(A[i].start, A[i].end);
			}
		}
		System.out.println(sum);

	}

	static public int getParent(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = getParent(parent[a]);
	}

	static public void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a > b)
			parent[a] = b;
		else
			parent[b] = a;
	}

	static public boolean findParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a == b)
			return true;

		return false;
	}

}

class Edge implements Comparable<Edge> {
	int start, end, value;

	public Edge(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}

	@Override
	public int compareTo(Edge o) {

		return this.value - o.value;
	}
}
