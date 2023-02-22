import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//삭제하는 노드부터 탐색하지 않는 방법으로 구함, 리프노드 구하는 방법은 for문에 들어가서 자식노드 변수 cNode에 1을 더하고, DFS를 다시 탐색할 때 초기화 해 주어, 자식노드 변수가 0일때는 리프노드임을 알 수있다.
public class Main {

	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int answer;
	static int delete;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		tree = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}
		int root = 0;
		for (int i = 0; i < N; i++) {
			int n = s.nextInt();
			if (n == -1)
				root = i;
			else {
				tree[i].add(n);
				tree[n].add(i);
			}
		}
		delete = s.nextInt();

		DFS(root);
		if (delete == root) {
			System.out.println(0);
		} else
			System.out.println(answer);
	}

	private static void DFS(int x) {
		visited[x] = true;
		int cNode = 0;
		for (int i : tree[x]) {
			int now = i;
			if (!visited[i] && i != delete) {
				visited[i] = true;
				cNode++;
				DFS(i);
			}
		}
		if (cNode == 0)
			answer++;

	}
}
