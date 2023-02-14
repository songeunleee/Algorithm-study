import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//위상정렬 문제, 노드와 에지가 주어지고, 조건이 있음

public class Main {

	static int[] inDegree;
	static ArrayList<Integer>[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		A = new ArrayList[n + 1];
		inDegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			inDegree[e]++;
		}

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}

		for (int i = 1; i <= n; i++) {
			if (q.isEmpty()) {
				System.out.println("사이클 발생");
				return;
			}
			int x = q.poll();
			System.out.print(x+" ");
			for (int next : A[x]) {
				inDegree[next]--;
				if (inDegree[next] == 0) {
					q.offer(next);
				}
			}

		}

	}
}
