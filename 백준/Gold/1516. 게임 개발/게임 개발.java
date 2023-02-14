import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//위상정렬 문제

public class Main {

	static int[] inDegree;
	static ArrayList<Integer>[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		A = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Integer>();
		}

		inDegree = new int[N + 1];
		int[] build = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			build[i] = time;
			while (true) {
				int nextToken = Integer.parseInt(st.nextToken());
				if (nextToken == -1)
					break;
				int s = nextToken;
				int e = i;
				A[s].add(e);
				inDegree[e]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				result[i] = build[i];
				q.offer(i);
			}

		}

		for (int i = 1; i <= N; i++) {
			if (q.isEmpty()) {
				System.out.println("사이클 발생");
				return;
			}
			int x = q.poll();
			for (int next : A[x]) {
				result[next] = Math.max(result[next], result[x] + build[next]);
				--inDegree[next];
				if (inDegree[next] == 0) {
					q.offer(next);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}

	}

}
