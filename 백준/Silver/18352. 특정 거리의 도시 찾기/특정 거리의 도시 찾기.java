import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//그래프를 인접리스트를 이용해 구현한 뒤, bfs 깊이를 계산
public class Main {
	static ArrayList<Integer>[] A;
	static int visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<Integer> answer = new ArrayList<>();
		A = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			A[s].add(e);
		}
		visited = new int[N + 1];
		for(int i =0;i<=N;i++) {
			visited[i] = -1;
		}
		BFS(X);

		for (int i = 0; i <=N; i++) {
			if (visited[i] == K)
				answer.add(i);
		}

		Collections.sort(answer);

		if (answer.isEmpty())
			System.out.println(-1);
		else {
			for (int a : answer) {
				System.out.println(a);
			}
		}

	}

	private static void BFS(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		visited[x] = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i : A[now]) {
				if (visited[i] == -1) {
					visited[i] = visited[now] + 1;
					q.add(i);
				}
			}
		}

	}

}
