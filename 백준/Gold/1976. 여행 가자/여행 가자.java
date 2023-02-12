import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//유니온 파인드 문제 도시들이 이어져있는지 확인한다.

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		int dosi[][] = new int[n + 1][n + 1];
		int route[] = new int[m + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				dosi[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dosi[i][j] == 1)
					union(i, j);
			}
		}
		int index = find(route[1]);
		for (int i = 2; i <=m; i++) {
			if (index != find(route[i])) {
				System.out.println("NO");
				return;
			}
		}

		
		System.out.println("YES");

	}

	private static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	private static boolean findParent(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return true;
		return false;
	}
}
