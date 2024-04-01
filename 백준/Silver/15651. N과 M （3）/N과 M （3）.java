

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static boolean visited[];
	static int[] arr;
	static int m,n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);

		n = s.nextInt();
		m = s.nextInt();

		visited = new boolean[n];
		arr = new int[m];
		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == m) {
			for (int val : arr) {
				sb.append(val + " ");
			}
			sb.append('\n');
			return;
		}

		for (int i = 1; i <= n; i++) {
				arr[depth] = i;
				dfs(depth+1);
			}
		}
	

}
