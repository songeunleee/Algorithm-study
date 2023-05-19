import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int first = Math.abs(o1);
				int second = Math.abs(o2);
				if (first == second) {
					return o1 > o2 ? 1 : -1;
				} else {
					return first - second;
				}
			}
		});

		for (int i = 0; i < N; i++) {
			int requset = Integer.parseInt(br.readLine());
			if (requset == 0) {
				if(q.isEmpty()) {
				System.out.println(0);}
				else {
					System.out.println(q.poll());
				}
			} else {
				q.add(requset);
			}
		}
	}

}
