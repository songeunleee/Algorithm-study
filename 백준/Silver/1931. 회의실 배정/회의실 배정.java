import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//삭제하는 노드부터 탐색하지 않는 방법으로 구함, 리프노드 구하는 방법은 for문에 들어가서 자식노드 변수 cNode에 1을 더하고, DFS를 다시 탐색할 때 초기화 해 주어, 자식노드 변수가 0일때는 리프노드임을 알 수있다.
public class Main {

	static int[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][2];
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,(o1,o2)->{
			if(o1[1]==o2[1]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1];
		});
		
		int answer =0;
		
		int end = -1;
		
		for(int a[]:arr) {
			if(a[0]>=end) {
				answer++;
				end = a[1];
			}
		}
		
		System.out.println(answer);
		
	}

}
