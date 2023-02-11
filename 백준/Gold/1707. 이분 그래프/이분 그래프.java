import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//그래프를 인접리스트를 이용해 구현한 뒤, 모든 노드에 bfs를 실행하고, 한 노드 당 탐색횟수를 answer배열에 저장함
public class Main {
	static ArrayList<Integer>[] A;
	static int[] answer;
	static int visited[];
	static int ans[];
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {

			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A = new ArrayList[V + 1];
			for (int j = 0; j <= V; j++) {
				A[j] = new ArrayList<>();
			}
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				A[s].add(e);
				A[e].add(s);
			}
			visited = new int[V + 1];
			check = true;
			ans = new int[V + 1];
			for (int j = 1; j <= V; j++) {
				if (!check)
					break;
				if (ans[j] == 0)
					ans[j] = 1;

				BFS(j);
			}

			System.out.println(check ? "YES" : "NO");

		}

	}

	private static void BFS(int x) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(x);
		visited[x] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i : A[now]) {

				if (visited[i] == 0) {
					visited[i] = 1;
					ans[i] = ans[now] * -1;
					q.add(i);
				} else if (ans[i] == ans[now]) {

					check = false;
					return;
				}

			}

		}
	}
}
