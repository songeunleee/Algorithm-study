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

		int K = Integer.parseInt(st.nextToken());

		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 0)
				s.pop();
			else
				s.push(num);

		}
		int sum=0;
		while(!s.isEmpty()) {
			sum = sum + s.pop();
		}
		
		System.out.println(sum);

	}

}
