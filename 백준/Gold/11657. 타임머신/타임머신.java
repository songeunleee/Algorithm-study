import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//벨만 포드, 음수사이클이 있는지 확인한다.

public class Main {

	static Edge[] A;

	static long D[];
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		D = new long[N + 1];
		A = new Edge[M];

		for (int i = 1; i <= N; i++) {

			D[i] = INF;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			A[i] = new Edge(s, e, v);
		}

		D[1] = 0;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Edge edge = A[j];
				if (D[edge.start] != INF && D[edge.end] > D[edge.start] + edge.value) {
					D[edge.end] = D[edge.start] + edge.value;
				}
			}
		}
		boolean mCycle = false;

		for (int i = 0; i < M; i++) {
			Edge edge = A[i];
			if (D[edge.start] != INF && D[edge.end] > D[edge.start] + edge.value) {
				mCycle = true;
			}
		}

		if (!mCycle) {
			for (int i = 2; i <= N; i++) {
				if (D[i] == INF)
					System.out.println("-1");
				else
					System.out.println(D[i]);
			}
		} else
			System.out.println("-1");

	}
}

class Edge {
	int start;
	int end;
	int value;

	Edge(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}

}