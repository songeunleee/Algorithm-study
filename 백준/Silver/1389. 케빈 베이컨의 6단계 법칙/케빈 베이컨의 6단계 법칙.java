import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//플로이드 워셜로 풀이

public class Main {

	static int D[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		D = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				if (i == j)
					D[i][j] = 0;
				else
					D[i][j] = 10000001;

			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			D[s][e] = 1;
			D[e][s] = 1;

		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (D[i][k] + D[k][j] < D[i][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}

				}
			}
		}

		int min = Integer.MAX_VALUE;
		int answer = -1;
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			for (int j = 1; j <= N; j++) {
				temp += D[i][j];
			}
			if (min > temp) {
				min = temp;
				answer = i;
			}
			
		}
		System.out.println(answer);

	}

}