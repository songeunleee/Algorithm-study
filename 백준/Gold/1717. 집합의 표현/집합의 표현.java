import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//유니온 파인드 문제

public class Main {

	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		A = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			A[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0)
				union(b, c);
			else
				System.out.println(findParent(b, c) ? "YES" : "NO");
		}

	}

	private static int find(int a) {
		if (A[a] == a)
			return a;
		return A[a] = find(A[a]);

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b)
			A[b] = a;
		else
			A[a] = b;
	}

	private static boolean findParent(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return true;
		return false;
	}
}
