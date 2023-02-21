import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//크루스칼로 가장 적은 랜선사용 수를 전체 랜선의 수에서 뺀다. 가장 적은 랜선사용수를 크루스칼 알고리즘으로 구한다.

public class Main {

	static int parent[];

	static int N;
	static PriorityQueue<Edge> q = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		parent = new int[N];

		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char tempc[] = st.nextToken().toCharArray();

			for (int j = 0; j < N; j++) {
				int temp = 0;
				if (tempc[j] >= 'a' && tempc[j] <= 'z') {
					temp = tempc[j] - 'a' + 1;
				} else if (tempc[j] >= 'A' && tempc[j] <= 'Z') {
					temp = tempc[j] - 'A' + 27;
				}
				sum = sum + temp;
				if (i != j && temp != 0)
					q.add(new Edge(i, j, temp));

			}
		}

		int count = 0;
		int result = 0;
		

		while (!q.isEmpty()) {
			Edge now = q.poll();
			if (find(now.start) != find(now.end)) {
				union(now.start, now.end);
				result = result + now.value;
				count++;
			}
		}

		if (count == N - 1) {
			System.out.println( sum-result);
			
			
		} else
			System.out.println("-1");

	}

	public static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b)
			parent[a] = b;
		else
			parent[b] = a;
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
