import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int priority[] = new int[N];

			st = new StringTokenizer(br.readLine());
	
			Queue<Integer> q = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				priority[j] = Integer.parseInt(st.nextToken());
				q.offer(j);
			}
			int ans = 0;
			while (!q.isEmpty()) {
				int now = q.peek();
				int max = 0;
				for (int j = 0; j < N; j++) {
					max = Math.max(max, priority[j]);
				}

				if (max > priority[now]) {
					q.offer(q.poll());
				} else if (max == priority[now]) {
					q.poll();
					priority[now] = -1;
					ans++;
					if (now == M) {
						System.out.println(ans);
					}
				}

			}

		}

	}

}
