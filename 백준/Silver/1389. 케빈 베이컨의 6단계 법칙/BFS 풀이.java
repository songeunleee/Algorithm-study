import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//BFS풀이

public class Main {

	static ArrayList<Integer>[] A;
	static int visited[];
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		int result[] = new int[N + 1];
		int index[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			visited = new int[N + 1];
			BFS(i);
			int sum = 0;
			visited[i] = 0;
			for (int j = 1; j <= N; j++) {
				sum += visited[j];
			
			}

			result[i] = sum;
			index[i] = sum;
		}

		Arrays.sort(result);
		int answer = N;
		for (int i = 1; i <= N; i++) {
			if (result[1] == index[i])
				if (answer > i)
					answer = i;
		}

		System.out.println(answer);

	}

	private static void BFS(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int x : A[now]) {
				if (visited[x] == 0) {
					visited[x] = visited[now] + 1;
					q.add(x);
				}
			}
		}

	}

}
