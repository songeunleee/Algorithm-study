
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int T;
	static int N;
	static String arr[];
	static int answer = 0;
	static boolean visited[];
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			// System.out.println(N);
			visited = new boolean[4];
			answer = 0;
			dfs(0);

			System.out.println(answer);
		}

	}

	static void dfs(int sum) {
		if (sum >= N) {
			if (sum == N) {
				answer += 1;
			}
			return;
		}

		for (int i = 1; i <= 3; i++) {

			dfs(sum + i);

		}
	}

}
