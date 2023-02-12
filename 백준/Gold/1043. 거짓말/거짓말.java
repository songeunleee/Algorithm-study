import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//유니온 파인드 문제 진실을 말하는 사람과 파티를 할 예정인 사람, 진실을 아는 사람과 파티를 한 사람, 진실을 아는 사람과 파티에 같이 있는 사람모두에게 과장된 이야기를 하면 안됨
//파티를 아는 사람의 정보를 저장하는 방법(ArrayList 사용)이 익숙치 않았음. 연습

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 사람 수
		int m = Integer.parseInt(st.nextToken()); // 파티 수

		st = new StringTokenizer(br.readLine());
		int truth = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
		int trueP[] = new int[truth];

		for (int i = 0; i < truth; i++) {
			trueP[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer>[] party = new ArrayList[m];

		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int party_size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < party_size; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int firstPeople = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}

		int result = 0;

		for (int i = 0; i < m; i++) {
			boolean isPossible = true;
			int cur = party[i].get(0);
			for (int j = 0; j < trueP.length; j++) {
				if (find(cur) == find(trueP[j])) {
					isPossible = false;
					break;
				}
			}
			if (isPossible)
				result++;
		}

		System.out.println(result);

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
