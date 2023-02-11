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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		answer = new int[N + 1];
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

		for (int i = 1; i <= N; i++) {
			visited = new int[N + 1];
			BFS(i);
		}

		int max = 0;
		for (int i = 0; i <= N; i++) {
			max = Math.max(max, answer[i]);
		}
		
		for(int i =0;i<=N;i++) {
			if(answer[i]==max) System.out.print(i+" ");
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
					answer[i]++;
					q.add(i);
				}
			}
		}

	}

}
