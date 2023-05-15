import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	static int[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int A[] = new int[N ];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());

		 Arrays.sort(A);
		int L = 0;
		int R = N-1;
		int sum = 0;
		int answer = 0;

		while (L<R) {
			if(A[L]+A[R]<x) {
				L++;
			}else if(A[L]+A[R]>x) {
				R--;
			}else {
				answer++;
				R--;
				L++;
			}
		}
		System.out.println(answer);

	}

}
