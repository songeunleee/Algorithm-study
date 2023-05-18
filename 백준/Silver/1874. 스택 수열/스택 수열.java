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
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		Stack<Integer> s = new Stack<>();
		
		int j = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int pop = Integer.parseInt(st.nextToken());
			if(pop>j) {
				while(j+1<=pop) {
					s.push(j+1);
					sb.append("+").append("\n");
					j++;
				}
			}else if(s.peek()!=pop) {
				System.out.println("NO");
				return;
			}
			
			s.pop();
			sb.append("-").append("\n");
		
		}
		
		System.out.println(sb);
		
		
	}

}
