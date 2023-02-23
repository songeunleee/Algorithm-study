import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//이진트리 탐색
public class Main {

	static int[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		tree = new int[26][2];
		s.nextLine();

		for (int i = 0; i < N; i++) {
			String[] temp = s.nextLine().split(" ");
			int node = temp[0].charAt(0) - 'A';
			int left = temp[1].charAt(0);
			int right = temp[2].charAt(0);

			if (left == '.') {
				tree[node][0] = -1;
			} else {
				tree[node][0] = left - 'A';
			}
			if (right == '.') {
				tree[node][1] = -1;
			} else {
				tree[node][1] = right - 'A';
			}

		}

		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);

	}

	public static void preOrder(int now) {
		if (now == -1)
			return;
		System.out.print((char) (now + 'A'));
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);

	}

	public static void inOrder(int now) {
		if (now == -1)
			return;
		inOrder(tree[now][0]);
		System.out.print((char) (now + 'A'));
		inOrder(tree[now][1]);

	}

	public static void postOrder(int now) {
		if (now == -1)
			return;
		postOrder(tree[now][0]);
		postOrder(tree[now][1]);
		System.out.print((char)(now + 'A'));

	}

}
