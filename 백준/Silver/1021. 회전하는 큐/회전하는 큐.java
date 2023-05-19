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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		LinkedList<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int seq[] = new int[M];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		int count =0;

		for (int i = 0; i < M; i++) {
			int target_idx = q.indexOf(seq[i]);
			int half_idx;

			if (q.size() % 2 == 0) {
				half_idx = q.size() / 2 - 1;
			} else {
				half_idx = q.size() / 2;
			}
			
			if(target_idx<=half_idx) {
				while(q.peekFirst()!=seq[i]) {
					q.offerLast(q.pollFirst());
					count++;
				}
				
				
			}else {
				while(q.peekLast()!=seq[i]) {
					q.offerFirst(q.pollLast());
					count++;
				}
				q.offerFirst(q.pollLast());
				count++;
				
			}
			q.pollFirst();
		}
		
		System.out.println(count);

	}

}
