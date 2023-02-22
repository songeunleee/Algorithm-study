import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//트리를 인접리스트로 구현하고. DFS로 부모를 구한다.
public class Main {

	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static int answer[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		A = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		answer = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
			A[e].add(s);
		}

		DFS(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}

	}

	private static void DFS(int x) {
		

		for (int i : A[x]) {
			int now = i;
			if (!visited[i]) {
				visited[i] = true;
				answer[now] = x;
				
				DFS(i);
			}
		}

	}
}
